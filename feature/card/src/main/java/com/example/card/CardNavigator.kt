package com.example.card

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val cardRoute = "card_route"

fun NavGraphBuilder.cardScreen() {
    composable(cardRoute) {
        CardScreen()
    }
}