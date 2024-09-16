package com.loc.newsapp78459.domain.manger.usecases

import com.loc.newsapp78459.domain.manger.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {

    suspend operator fun invoke(): Flow<Boolean> {
        return localUserManager.readyAppEntry()
    }
}