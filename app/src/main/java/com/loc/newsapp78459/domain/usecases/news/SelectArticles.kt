package com.loc.newsapp78459.domain.usecases.news

import com.loc.newsapp78459.domain.model.Article
import com.loc.newsapp78459.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticles (
    private val newsRepository: NewsRepository
) {

    operator fun invoke( ): Flow<List<Article>> {
        return newsRepository.selectArticle()
    }
}