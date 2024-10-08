package com.loc.newsapp78459.presentation.search

import androidx.paging.PagingData
import com.loc.newsapp78459.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery:String = "",
    val articles: Flow<PagingData<Article>>? = null
) {
}