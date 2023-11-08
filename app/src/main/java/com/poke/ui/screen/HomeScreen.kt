package com.poke.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.poke.state.PokeState
import com.poke.ui.theme.PokeTheme
import com.poke.ui.theme.medium
import com.poke.ui.theme.normal
import com.poke.ui.theme.regular
import com.poke.viewmodel.PokeViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(viewModel: PokeViewModel = hiltViewModel(), onNavigateDetail: () -> Unit) {
    val viewState by viewModel.viewState.collectAsState()
    val listState = rememberLazyListState()

    val state = rememberPullRefreshState(
        refreshing = viewState.isLoading,
        onRefresh = { viewModel.pullRefresh() })

    PokeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            Box(Modifier.pullRefresh(state)) {
                when {
                    viewState.isLoading -> Box(modifier = Modifier.fillMaxSize()) {
                        LinearProgressIndicator(
                            modifier = Modifier
                                .height(5.dp)
                                .align(Alignment.Center)
                        )
                    }

                    viewState.failed -> Column(modifier = Modifier.fillMaxSize()) {
                        Box(modifier = Modifier.fillMaxSize()) {
                            Text(
                                text = "Error loading data, try again\n${viewModel.errorMessage} ",
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    }

                    else -> LazyVerticalGrid(
                        columns = GridCells.Fixed(3),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = medium),
                        contentPadding = PaddingValues(regular),
                        verticalArrangement = Arrangement.spacedBy(regular),
                        horizontalArrangement = Arrangement.spacedBy(regular)
                    ) {

                        val itemCount = if (viewState.data.results.size % 2 == 0) {
                            viewState.data.results.size / 2
                        } else {
                            viewState.data.results.size / 2 + 1
                        }

                        items(viewState.data.results) { poke ->
                            if (viewState.data.results.size >= itemCount - 1 && listState.isScrolledToTheEnd()) {
                                viewModel.getPoke()
                            }
                            PokeItem(
                                poke = poke,
                                onClick = { selectedPoke ->
                                    viewModel.pokeId.value = selectedPoke.id
                                    onNavigateDetail()
                                })
                        }
                    }
                }
                PullRefreshIndicator(
                    viewState.isLoading,
                    state,
                    Modifier.align(Alignment.TopCenter)
                )
            }
        }
    }
}

fun LazyListState.isScrolledToTheEnd() =
    layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1

@Composable
fun PokeItem(poke: PokeState.Result, onClick: (PokeState.Result) -> Unit) {
    Card(
        colors = CardDefaults.elevatedCardColors(containerColor = Color.White),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 10.dp),
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxSize()
            .clickable { onClick(poke) }
    ) {
        Column {
            Text(
                text = "${poke.id}",
                modifier = Modifier
                    .padding(horizontal = normal)
                    .fillMaxWidth(),
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    textAlign = TextAlign.End
                )
            )

            Image(
                painter = rememberAsyncImagePainter(poke.url),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
            )

            Text(
                text = poke.name.uppercase(),
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
        }
    }
}
