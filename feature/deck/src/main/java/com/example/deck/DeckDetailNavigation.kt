package com.example.deck

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val deckDetailRoute = "deck_detail_route"

fun NavController.navigateToDeckDetail() {
    this.navigate(deckDetailRoute)
}

fun NavGraphBuilder.deckDetailRoute(
    navigateToCard: () -> Unit,
    navigateToDeckList: () -> Unit,
) {
    composable(deckDetailRoute) {
        DeckDetailScreen(
            navigateToCard = navigateToCard,
            navigateToDeckList = navigateToDeckList,
        )
    }
}
