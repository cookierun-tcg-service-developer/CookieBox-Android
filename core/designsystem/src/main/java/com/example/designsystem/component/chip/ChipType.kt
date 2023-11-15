package com.example.designsystem.component.chip

enum class CardColor {
    Red, Yellow, Green
}

enum class CardType {
    Cookie, Trap, Item, Stage
}

val CardColor.text: String
    get() = when (this) {
        CardColor.Red -> "레드"
        CardColor.Yellow -> "옐로우"
        CardColor.Green -> "그린"
    }

val CardType.text: String
    get() = when (this) {
        CardType.Cookie -> "쿠키 카드"
        CardType.Trap -> "트랩 카드"
        CardType.Item -> "아이템 카드"
        CardType.Stage -> "스테이지 카드"
    }
