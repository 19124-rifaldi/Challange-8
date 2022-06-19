package com.faldi.movieapp.presentation.view.register

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.faldi.movieapp.data.local.DataUser

@Composable
fun Register (navController : NavController,viewModel: RegViewModel= hiltViewModel()){
    val context = LocalContext.current
    var email by rememberSaveable {
        mutableStateOf("")
    }
    var pass by rememberSaveable {
        mutableStateOf("")
    }
    var nickname by rememberSaveable {
        mutableStateOf("")
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {


            Text(text = "regist", fontSize = 30.sp, modifier = Modifier.padding(top = 20.dp))
            TextField(value = email, onValueChange ={email = it}
                , label = { Text(text = "email")}
                , modifier = Modifier.padding(top = 20.dp)
            )

            TextField(value =nickname , onValueChange = {nickname= it}, modifier = Modifier.padding(top = 20.dp)
                , label = { Text(text = "nickname")}
            )

            TextField(value =pass , onValueChange = {pass = it}, modifier = Modifier.padding(top = 20.dp),
                label = { Text(text = "password")}
            )


            Button(onClick = {
                viewModel.registration(nickname,email,pass)
                val state = viewModel.register.value
                if (state !=null){
                    navController.navigate("login")
                }else{
                    Toast.makeText(context,"login error",Toast.LENGTH_SHORT).show()
                }

            }
                ,modifier = Modifier.padding(top = 20.dp))
            {
                Text(text = "regist")
            }
        }
    }
}