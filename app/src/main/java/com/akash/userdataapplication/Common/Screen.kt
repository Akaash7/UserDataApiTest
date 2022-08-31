package com.akash.userdataapplication.Common

import okhttp3.Route

sealed class Screen(val route :String){
    object UserDataScreenRoute: Screen("user_screen")
}
