package com.example.designsystem.component.modifier

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Indication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

fun Modifier.cookieboxClickable(
    indication: Indication? = null,
    onClick: () -> Unit,
) = composed {
    clickable(
        interactionSource = remember { MutableInteractionSource() },
        indication = indication,
        onClick = onClick
    )
}

@OptIn(ExperimentalFoundationApi::class)
fun Modifier.cookieboxCombinedClickable(
    indication: Indication? = null,
    onClick: () -> Unit,
    onLongClick: (() -> Unit)? = null,
    onDoubleClick: (() -> Unit)? = null,
) = composed {
    combinedClickable(
        interactionSource = remember { MutableInteractionSource() },
        indication = indication,
        onClick = onClick,
        onLongClick = onLongClick,
        onDoubleClick = onDoubleClick
    )
}
