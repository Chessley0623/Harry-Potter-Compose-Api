package com.example.hpapp.ui.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.hpapp.data.api.model.Characters
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.layout.ContentScale

@Composable
fun HomeScreen(){
    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
    val state by homeViewModel.state.collectAsState()

    LazyColumn{
        if (state.isEmpty()){
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(align = Alignment.Center)
                )
            }
        }

        items(state){characters: Characters ->
            CharacterImageCard(characters = characters)
        }
    }

}

@Composable
fun CharacterImageCard(characters: Characters){
    val imagePainter = rememberImagePainter(data = characters.image)
    
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.padding(16.dp)) {
        Box{

            Image(
                painter = imagePainter,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.FillBounds)

            Surface(
                color = MaterialTheme.colors.onSurface.copy(alpha = .3f),
                modifier = Modifier.align(Alignment.BottomCenter),
                contentColor = MaterialTheme.colors.surface
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                ) {
                    Text(text = "Real Name: ${characters.actor}")
                    Text(text = "Actor Name: ${characters.name}")
                }
            }
        }
    }
}