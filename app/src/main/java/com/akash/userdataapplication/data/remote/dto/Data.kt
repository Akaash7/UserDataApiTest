package com.akash.userdataapplication.data.remote.dto

import android.service.autofill.UserData
import com.akash.userdataapplication.domain.model.UserDataItem

data class Data(
    val avatar: String,
    val email: String,
    val first_name: String,
    val id: Int,
    val last_name: String
)

fun Data.toUserDataItem() : UserDataItem {
    return UserDataItem(
        avatar = avatar,
        email = email,
        first_name = first_name,
        id = id,
        last_name
    )
}