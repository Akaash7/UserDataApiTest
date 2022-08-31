package com.akash.userdataapplication.data.repository

import android.service.autofill.UserData
import com.akash.userdataapplication.data.local.UsersDataDAO
import com.akash.userdataapplication.data.remote.UserDataApi
import com.akash.userdataapplication.data.remote.dto.Data
import com.akash.userdataapplication.data.remote.dto.DataDTO
import com.akash.userdataapplication.data.remote.dto.toUserDataItem

import com.akash.userdataapplication.domain.model.toUserData
import com.akash.userdataapplication.domain.repository.UserDataRepository

class UserDataRepositoryImpl(
    private val api : UserDataApi,
    private val dao : UsersDataDAO
) : UserDataRepository {

    override suspend fun getUserData(): List<Data> {
        val userDataList = api.getUserData().data.map { it.toUserDataItem()
        }
        dao.insertUsersData(usersData = userDataList)

        return dao.getUsersData().map { it.toUserData() }
    }

}