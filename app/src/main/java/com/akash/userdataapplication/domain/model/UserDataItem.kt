package com.akash.userdataapplication.domain.model

import android.service.autofill.UserData
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.akash.userdataapplication.data.remote.dto.Data

@Entity
data class UserDataItem(
    val avatar: String ,
    val email: String,
    val first_name: String ,
    @PrimaryKey val id: Int,
    val last_name: String
)
fun UserDataItem.toUserData() : Data {
    return Data(avatar = avatar,
    email = email,
    first_name = first_name ?: " ",
    id = id,
    last_name = last_name
    )
}
