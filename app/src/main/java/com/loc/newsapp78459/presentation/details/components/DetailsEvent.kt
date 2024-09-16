package com.loc.newsapp78459.presentation.details.components

import com.loc.newsapp78459.domain.model.Article

sealed class DetailsEvent (){

    data class UpsertDeleteArticle(val article: Article) : DetailsEvent()

    object RemoveSideEffect : DetailsEvent()
}