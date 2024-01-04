package com.example.cookiebox

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.card.cardScreen
import com.example.card.navigateToCard
import com.example.deck.deckDetailRoute
import com.example.deck.deckListScreen
import com.example.deck.navigateToDeckDetail
import com.example.deck.navigateToDeckList

@Composable
fun CookieBoxNavHost(
    navController: NavHostController,
    startDestination: String,
) {
    NavHost(navController = navController, startDestination = startDestination) {
        cardScreen(
            navigateToDeckList = { navController.navigateToDeckList() }
        )
        deckListScreen(
            navigateToCard = { navController.navigateToCard() },
            navigateToDeckDetail = { navController.navigateToDeckDetail() },
        )
        deckDetailRoute(
            navigateToCard = { navController.navigateToCard() },
            navigateToDeckList = { navController.navigateToDeckList() },
        )
    }
}
