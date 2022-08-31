package com.akash.userdataapplication.domain.repository

import android.service.autofill.UserData
import com.akash.userdataapplication.data.remote.dto.Data

interface UserDataRepository {

    suspend fun getUserData() : List<Data>
}