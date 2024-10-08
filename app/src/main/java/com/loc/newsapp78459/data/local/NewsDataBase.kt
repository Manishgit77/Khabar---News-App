package com.loc.newsapp78459.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.loc.newsapp78459.domain.model.Article


@Database(entities = [Article::class], version =2)
@TypeConverters(NewsTypeConverter::class)
abstract class NewsDataBase:RoomDatabase() {

    abstract val newsDao:NewsDao
}