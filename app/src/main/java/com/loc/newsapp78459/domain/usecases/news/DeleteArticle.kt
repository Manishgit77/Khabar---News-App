package com.loc.newsapp78459.domain.usecases.news

import com.loc.newsapp78459.domain.model.Article
import com.loc.newsapp78459.domain.repository.NewsRepository

class DeleteArticle(
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(article: Article){
        newsRepository.deleteArticle(article)
    }
}