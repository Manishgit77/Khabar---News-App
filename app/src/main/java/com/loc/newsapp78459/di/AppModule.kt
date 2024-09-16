package com.loc.newsapp78459.di

import android.app.Application
import androidx.room.Room
import com.loc.newsapp78459.data.local.NewsDao
import com.loc.newsapp78459.data.local.NewsDataBase
import com.loc.newsapp78459.data.local.NewsTypeConverter
import com.loc.newsapp78459.data.manger.LocalUserMangerImp
import com.loc.newsapp78459.data.remote.dto.NewsApi
import com.loc.newsapp78459.data.repository.NewsRepositoryImpl
import com.loc.newsapp78459.domain.manger.LocalUserManager
import com.loc.newsapp78459.domain.manger.usecases.AppEntryUseCases
import com.loc.newsapp78459.domain.manger.usecases.ReadAppEntry
import com.loc.newsapp78459.domain.manger.usecases.SaveAppEntry
import com.loc.newsapp78459.domain.repository.NewsRepository
import com.loc.newsapp78459.domain.usecases.news.DeleteArticle
import com.loc.newsapp78459.domain.usecases.news.GetNews
import com.loc.newsapp78459.domain.usecases.news.NewsUseCases
import com.loc.newsapp78459.domain.usecases.news.SearchNews
import com.loc.newsapp78459.domain.usecases.news.SelectArticle
import com.loc.newsapp78459.domain.usecases.news.SelectArticles
import com.loc.newsapp78459.domain.usecases.news.UpsertArticle
import com.loc.newsapp78459.util.Constants.BASE_URL
import com.loc.newsapp78459.util.Constants.NEWS_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManager = LocalUserMangerImp(application)


    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager),
    )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi,
        newsDao: NewsDao
    ): NewsRepository = NewsRepositoryImpl(newsApi, newsDao)


    @Provides
    @Singleton
    fun provideNewsCases(
        newsRepository: NewsRepository,
        newsDao: NewsDao
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository),
            upsertArticle = UpsertArticle(newsRepository),
            deleteArticle = DeleteArticle(newsRepository),
            selectArticles = SelectArticles(newsRepository),
            selectArticle  = SelectArticle(newsRepository),
            )
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDataBase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDataBase::class.java,
            name = NEWS_DATABASE_NAME
        ).addTypeConverter(NewsTypeConverter())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDataBase: NewsDataBase
    ): NewsDao = newsDataBase.newsDao

}