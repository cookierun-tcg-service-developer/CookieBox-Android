package com.example.card

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val cardRoute = "card_route"

fun NavController.navigateToCard() {
    this.navigate(cardRoute)
}

fun NavGraphBuilder.cardScreen(navigateToDeckList: () -> Unit) {
    composable(cardRoute) {
        CardScreen(
            navigateToDeckList = navigateToDeckList
        )
    }
}
