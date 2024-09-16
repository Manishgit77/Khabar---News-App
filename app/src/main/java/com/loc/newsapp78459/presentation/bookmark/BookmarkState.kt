package com.loc.newsapp78459.presentation.bookmark

import com.loc.newsapp78459.domain.model.Article

data class BookmarkState(
    val articles : List<Article> = emptyList()
)
