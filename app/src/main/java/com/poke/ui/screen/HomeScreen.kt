package com.poke.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.poke.ui.theme.PokeTheme
import com.poke.viewmodel.PokeViewModel

@Composable
fun HomeScreen(navigate: () -> Unit, viewModel: PokeViewModel) {
    val pokeState by viewModel.pokeState.collectAsState()
    PokeTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Text(text = pokeState.data.name)
            //Greeting("Android")
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