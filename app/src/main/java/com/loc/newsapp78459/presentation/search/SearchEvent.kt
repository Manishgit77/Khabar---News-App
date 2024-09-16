package com.loc.newsapp78459.presentation.search

sealed class SearchEvent {

    data class UpdateSearchQuery(val searchQuery: String):SearchEvent()

    object SearchNews : SearchEvent();
}