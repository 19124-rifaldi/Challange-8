package com.faldi.movieapp.presentation.view.login

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import org.intellij.lang.annotations.JdkConstants


@Composable
fun Login(navController : NavController,viewModel: LoginViewModel= hiltViewModel()){
    val context = LocalContext.current
    var email by rememberSaveable {
        mutableStateOf("")
    }
    var pass by rememberSaveable {
        mutableStateOf("")
    }
    
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Text(text = "Login", fontSize = 30.sp, modifier = Modifier.padding(top = 20.dp))
            TextField(value = email,onValueChange ={email = it},
                label = { Text(text = "Email")},
                placeholder = { Text(text = "your email here")},
                modifier = Modifier.padding(top = 20.dp)
            )

            TextField(value =pass , onValueChange = {pass = it}, modifier = Modifier.padding(top = 20.dp)
                ,label = { Text(text = "password")},
                placeholder = { Text(text = "your password here")},
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Button(onClick = {
                viewModel.login(email,pass)
                Log.d("test",email)
                Log.d("test2",pass)
                val state = viewModel.state.value
                if (state != null){
                    Toast.makeText(context,"login success",Toast.LENGTH_SHORT).show()
                    navController.navigate("popular")
                }else{
                    Toast.makeText(context,"login error",Toast.LENGTH_SHORT).show()
                }
                },
                modifier = Modifier.padding(top = 20.dp))
            {
                Text(text = "Login")
            }
            Text(text = "new? regist first", fontSize = 10.sp, modifier = Modifier
                .padding(top = 20.dp)
                .clickable { navController.navigate("regist") }
            )
        }
    }

    

}