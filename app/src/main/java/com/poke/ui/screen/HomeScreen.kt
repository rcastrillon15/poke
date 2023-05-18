package com.poke.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.poke.state.PokeState
import com.poke.ui.theme.PokeTheme
import com.poke.ui.theme.medium
import com.poke.ui.theme.normal
import com.poke.ui.theme.regular
import com.poke.ui.theme.xxlarge
import com.poke.viewmodel.PokeViewModel

@Composable
fun HomeScreen(navigate: () -> Unit, viewModel: PokeViewModel) {
    val viewState by viewModel.viewState.collectAsState()
    PokeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = medium, bottom = xxlarge),
                contentPadding = PaddingValues(regular),
                verticalArrangement = Arrangement.spacedBy(regular),
                horizontalArrangement = Arrangement.spacedBy(regular)
            ) {
                items(viewState.data.results) {
                    PokeItem(state = it, onClick = {

                    })
                }
            }
        }
    }
}

@Composable
fun PokeItem(state: PokeState.Result, onClick: (PokeState.Result) -> Unit) {
    Card(
        colors = CardDefaults.elevatedCardColors(containerColor = Color.White),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 10.dp),
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .width(100.dp)
            .height(85.dp)
            .fillMaxSize()
            .clickable { onClick(state) }
    ) {
        Box() {
            Image(
                painter = rememberAsyncImagePainter(state.url),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )

            Text(
                text = state.name,
                modifier = Modifier
                    .padding(normal)
                    .align(Alignment.BottomCenter),
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    shadow = Shadow(
                        color = Color.Black.copy(alpha = 0.2F),
                        offset = Offset(10.0f, 10.0f),
                        blurRadius = 5f
                    )
                )
            )
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
    PokeTheme {
        Greeting("Android")
    }
}
