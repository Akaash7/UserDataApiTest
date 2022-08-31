package com.akash.userdataapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.akash.userdataapplication.domain.model.UserDataItem

@Database(
    entities = [UserDataItem::class],
    version = 1
)
abstract class UserDataDatabase : RoomDatabase() {
    abstract val dao : UsersDataDAO

    companion object{
        const val DB_NAME = "users_db"
    }
}