package com.example.designsystem.component.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.icon.IcSearch
import com.example.designsystem.theme.CookieboxTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CookieboxTextField(
    value: String,
    hint: String,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = CookieboxTheme.typography.textMediumR,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = true,
    maxLines: Int = 1,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onValueChange: (String) -> Unit,
    trailingIcon: (@Composable () -> Unit)? = null,
) {
    val coloredStyle = textStyle.copy(color = Color.Black)

    BasicTextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = CookieboxTheme.color.grayscale5, shape = RoundedCornerShape(21.dp)),
        value = value,
        enabled = enabled,
        readOnly = readOnly,
        textStyle = coloredStyle,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        onValueChange = onValueChange,
        singleLine = singleLine,
        maxLines = maxLines,
        visualTransformation = visualTransformation,
        interactionSource = interactionSource,
        decorationBox = { innerTextField ->
            TextFieldDefaults.TextFieldDecorationBox(
                value = value,
                innerTextField = innerTextField,
                enabled = enabled,
                singleLine = singleLine,
                visualTransformation = visualTransformation,
                interactionSource = interactionSource,
                placeholder = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = hint,
                        color = CookieboxTheme.color.grayscale40,
                        style = CookieboxTheme.typography.textMediumR
                    )
                },
                trailingIcon = trailingIcon,
                contentPadding = TextFieldDefaults.textFieldWithoutLabelPadding(
                    start = 20.dp, top = 8.dp, bottom = 8.dp
                )
            )
        }
    )
}

@Preview
@Composable
fun PreviewCookieboxTextField() {
    var text by remember { mutableStateOf("") }

    CookieboxTextField(
        value = text,
        hint = "덱 이름으로 검색",
        onValueChange = { text = it },
        trailingIcon = { IcSearch() }
    )
}
