package com.example.deck

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val deckListRoute = "deck_list_route"

fun NavController.navigateToDeckList() {
    this.navigate(deckListRoute)
}

fun NavGraphBuilder.deckListScreen(
    navigateToCard: () -> Unit,
    navigateToDeckDetail: () -> Unit,
) {
    composable(deckListRoute) {
        DeckListScreen(
            navigateToCard = navigateToCard,
            navigateToDeckDetail = navigateToDeckDetail,
        )
    }
}
