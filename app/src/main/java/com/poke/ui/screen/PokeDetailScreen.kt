package com.poke.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.poke.ui.theme.normal
import com.poke.viewmodel.PokeViewModel

@Composable
fun PokeDetailScreen(viewModel: PokeViewModel) {
    val viewState by viewModel.pokeSpecieState.collectAsStateWithLifecycle()

    Scaffold {
        when {
            viewState.isLoading -> Box(modifier = Modifier.fillMaxSize()) {
                LinearProgressIndicator(
                    modifier = Modifier
                        .height(5.dp)
                        .align(Alignment.Center)
                )
            }
            viewState.failed -> Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = "Error loading data, try again\n${viewModel.errorMessage} ",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            else -> {
                Column(modifier = Modifier.padding(it)) {
                    Text(
                        text = viewState.data.name.uppercase(),
                        maxLines = 1,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = normal),
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = Color.Black,
                            fontWeight = FontWeight.SemiBold,
                            textAlign = TextAlign.Center,
                            fontSize = 14.sp
                        )
                    )
                    Image(
                        painter = rememberAsyncImagePainter(viewState.data.url),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                            .padding(vertical = normal)
                    )
                }
            }
        }

        LaunchedEffect(Unit){
            viewModel.getPokemonSpecies()
        }
    }
}
