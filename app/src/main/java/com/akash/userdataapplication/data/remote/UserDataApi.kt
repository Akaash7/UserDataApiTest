package com.akash.userdataapplication.data.remote

import com.akash.userdataapplication.data.remote.dto.DataDTO
import retrofit2.http.GET

interface UserDataApi {

    @GET("api/users?page=1")
    suspend fun getUserData() : DataDTO
}