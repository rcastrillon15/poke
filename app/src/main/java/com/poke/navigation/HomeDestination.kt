package com.poke.navigation

import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.poke.ui.screen.HomeScreen
import com.poke.ui.screen.PokeDetailScreen
import com.poke.viewmodel.PokeViewModel

object HomeDestination : NavigationDestination {
    override val route: String = "home_route"
    override val destination: String = "home_destination"
}

object PokeDetailDestination : NavigationDestination {
    override val route: String = "detail_route"
    override val destination: String = "detail_destination"
}

fun NavGraphBuilder.homeGraph(navController: NavController) {
    composable(route = HomeDestination.route) {
        HomeScreen(
            onNavigateDetail = { navController.navigate(PokeDetailDestination.route) }
        )
    }

    composable(route = PokeDetailDestination.route) {

        val parentEntry =
            remember(it) { navController.getBackStackEntry(HomeDestination.route) }

        val viewModel = hiltViewModel<PokeViewModel>(parentEntry)

        PokeDetailScreen(viewModel = viewModel)
    }
}
