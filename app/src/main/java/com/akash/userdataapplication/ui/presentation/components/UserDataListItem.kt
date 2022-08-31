package com.akash.userdataapplication.ui.presentation.components

import android.service.autofill.UserData
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akash.userdataapplication.data.remote.dto.Data
import com.akash.userdataapplication.domain.model.UserDataItem

@Composable
fun UserDataListItem(
    userDataItem: Data
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(20.dp))
            .padding(8.dp),
        color = Color.LightGray,
        elevation = 4.dp
    ) {
        Column() {
            Text(
                modifier = Modifier.padding(8.dp),
                text = userDataItem.first_name +" "+ userDataItem.last_name,
                style = TextStyle(
                    fontSize = 24.sp,
                    color = Color.White
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier.padding(8.dp),
                text = userDataItem.email,
                style = TextStyle(
                    fontSize = 24.sp,
                    color = Color.White
                )
            )
        }
    }
}