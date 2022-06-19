package com.faldi.movieapp.presentation.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.Text
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.faldi.movieapp.data.remote.Result
import com.faldi.movieapp.presentation.theme.Teal200
import com.faldi.movieapp.presentation.view.popular.PopularViewModel

@Composable
fun Popular(navController : NavController,viewModel: PopularViewModel= hiltViewModel()){
    val data = viewModel.popState.value.result

    Box (
        modifier = Modifier
            .fillMaxSize()
    ){
        Column {
            Text1()
            Item(navController)
//            LazyColumn(){
//                items(data){
//                    Box(modifier = Modifier.clickable {
//                        navController.navigate("detail/${it?.id}")
//                    }) {
//                        Text(text = "${it?.title}")
//                    }
//
//                }
//            }

        }
    }
}


@Composable
fun Text1(){

    Box(modifier = Modifier
        .fillMaxWidth()
        .height(80.dp)
        .padding(20.dp)
    ) {
        Row {
            Text(text = "HELLO",
                textAlign = TextAlign.Center,
                fontSize = 25.sp
                )
        }
    }

}

@Composable
fun Item(navController : NavController,viewModel :PopularViewModel= hiltViewModel()) {
    val data = viewModel.popState.value.result
    LazyColumn{
        items(data){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .clickable {
                        navController.navigate("detail/${it?.id}")
                    }
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        val image =
                            rememberImagePainter(data = "https://image.tmdb.org/t/p/original/"+it?.posterPath )
                        Log.d("image", it!!.posterPath)

                        Image(
                            painter = image,
                            contentDescription = "iconfilm",
                            modifier = Modifier
                                .height(120.dp)
                                .width(70.dp)
                                .padding(5.dp)
                                .background(color = Teal200)
                        )
                        Column {
                            Text(text = it.title , modifier = Modifier.padding(bottom = 4.dp))

                            Text(
                                text = "Rating : ${it.voteAverage}", fontSize = 15.sp, modifier = Modifier
                                    .padding(top = 2.dp)
                            )
                        }
                    }
                }
            }
        }
    }

}