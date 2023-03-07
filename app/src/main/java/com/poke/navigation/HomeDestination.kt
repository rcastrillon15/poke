package com.poke.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.poke.ui.screen.HomeScreen

object HomeDestination : NavigationDestination {
    override val route: String = "home_route"
    override val destination: String = "home_destination"
}

fun NavGraphBuilder.homeGraph(navController: NavController) {
    composable(route = HomeDestination.route) {
        HomeScreen(
            navigate = {
                navController.popBackStack()
            },
            viewModel = hiltViewModel()
        )
    }
}