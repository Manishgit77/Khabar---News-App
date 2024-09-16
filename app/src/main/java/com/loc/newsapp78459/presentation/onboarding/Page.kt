package com.loc.newsapp78459.presentation.onboarding

import androidx.annotation.DrawableRes
import com.loc.newsapp78459.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)


val pages = listOf(
    Page(
        title = "News on finger tips",
        description = "Now get news related to all the fields in just single app.",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Save it on a click",
        description = "Bookmark your news and re-visit it whenever you want.",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Personalize you experience",
        description = "Get news as per your interest and needs.",
        image = R.drawable.onboarding3
    )
)