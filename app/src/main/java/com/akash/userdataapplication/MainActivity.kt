package com.akash.userdataapplication

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.akash.userdataapplication.Common.Screen
import com.akash.userdataapplication.data.local.RoomInstance
import com.akash.userdataapplication.data.local.UserDataDatabase
import com.akash.userdataapplication.data.remote.RetrofitInstance
import com.akash.userdataapplication.data.repository.UserDataRepositoryImpl
import com.akash.userdataapplication.domain.repository.UserDataRepository
import com.akash.userdataapplication.ui.presentation.UserDataScreen
import com.akash.userdataapplication.ui.presentation.components.UserDataViewModel
import com.akash.userdataapplication.ui.theme.UserDataApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val api = RetrofitInstance.api
            val db = Room.databaseBuilder(
                applicationContext, UserDataDatabase::class.java, UserDataDatabase.DB_NAME
            ).build()
            val repository  = UserDataRepositoryImpl(api,db.dao)

            val viewModel:UserDataViewModel by viewModels {
                UserDataViewModel.Factory(repository)
            }
            UserDataApplicationTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.UserDataScreenRoute.route
                ){
                    composable(route = Screen.UserDataScreenRoute.route){
                        UserDataScreen(viewModel)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UserDataApplicationTheme {
        Greeting("Android")
    }
}