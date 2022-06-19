package com.faldi.movieapp.presentation.view.detail

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter

@Composable
fun Detail(id : Int,viewModel: DetailViewModel = hiltViewModel()){

//    Text(
//        text ="Selamat datang di detail, yahahahaha hayuuuuk,{$id}",
//        fontSize = 25.sp
//    )


    Box(modifier = Modifier
        .fillMaxSize()
        .padding(bottom = 10.dp)
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top = 20.dp)

        ) {


            Text(text = "Detail", fontSize = 40.sp
                , modifier = Modifier.padding(bottom = 30.dp)
            )
            val dataImage = viewModel.popState.value.detail?.posterPath.toString()
            val title = viewModel.popState.value.detail?.title
            val desc = viewModel.popState.value.detail?.overview.toString()
            Log.d("image",title.toString())

            val image = rememberImagePainter(data = "https://image.tmdb.org/t/p/original/$dataImage")

            Image(painter =image , contentDescription = "",
                modifier = Modifier
                    .background(color = Color.Black)
                    .width(150.dp)
                    .height(240.dp)
            )

            Text(text = title.toString(),
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(top = 40.dp)
            )
            Text(
                text = desc,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(top = 30.dp)
            )

        }

    }
}