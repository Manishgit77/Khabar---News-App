package com.loc.newsapp78459.domain.usecases.news

import com.loc.newsapp78459.domain.model.Article
import com.loc.newsapp78459.domain.repository.NewsRepository

class SelectArticle(
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(url: String): Article?{
        return newsRepository.selectArticle(url)
    }
}