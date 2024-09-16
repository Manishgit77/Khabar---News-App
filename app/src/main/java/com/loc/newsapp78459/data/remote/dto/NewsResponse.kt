package com.loc.newsapp78459.data.remote.dto

import com.loc.newsapp78459.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)