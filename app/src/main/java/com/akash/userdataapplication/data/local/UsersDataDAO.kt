package com.akash.userdataapplication.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.akash.userdataapplication.data.remote.dto.Data
import com.akash.userdataapplication.domain.model.UserDataItem

@Dao
interface UsersDataDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsersData(usersData : List<UserDataItem>)

    @Query("SELECT * FROM UserDataItem")
    suspend fun getUsersData() : List<UserDataItem>
}