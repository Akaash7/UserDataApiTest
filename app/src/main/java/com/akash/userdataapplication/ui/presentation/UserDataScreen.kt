package com.akash.userdataapplication.ui.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.akash.userdataapplication.ui.presentation.components.UserDataListItem
import com.akash.userdataapplication.ui.presentation.components.UserDataViewModel

@Composable
fun UserDataScreen(
    viewModel: UserDataViewModel
) {
    val listUsers = viewModel.state.value.UserDataList

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.Gray
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(listUsers){ userItem ->
               UserDataListItem(userDataItem = userItem)
            }
        }
    }
}
