package com.loc.newsapp78459.domain.manger

import kotlinx.coroutines.flow.Flow

interface LocalUserManager {


    suspend fun saveAppEntry()

    fun readyAppEntry(): Flow<Boolean>
}