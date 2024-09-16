package com.loc.newsapp78459.domain.manger.usecases

import com.loc.newsapp78459.domain.manger.LocalUserManager

class SaveAppEntry(
    private val localUserManager:LocalUserManager
) {

    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}