package com.example.designsystem.component.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import coil.compose.AsyncImage
import com.example.designsystem.component.button.ButtonType
import com.example.designsystem.component.button.CookieboxButton
import com.example.designsystem.component.chip.CardColor
import com.example.designsystem.component.chip.CardType
import com.example.designsystem.component.chip.CookieboxChip
import com.example.designsystem.icon.IcCross
import com.example.designsystem.theme.CookieboxTheme

@Composable
fun CookieBoxDialog(
    modifier: Modifier = Modifier,
    cookieName: String,
    cookieLevel: Int,
    cookieHp: Int,
    imageUrl: String,
    cardType: CardType,
    cardColor: CardColor,
    skills: List<String>,
    skillCost: List<String>,
    onDismissRequest: () -> Unit,
    onSave: () -> Unit,
    onCopy: () -> Unit,
) {
    Dialog(
        onDismissRequest = onDismissRequest,
    ) {
        Column(
            modifier = modifier,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent),
                horizontalArrangement = Arrangement.End,
            ) {
                IcCross(
                    modifier = Modifier
                        .padding(bottom = 24.dp),
                    tint = Color.White,
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(8.dp),
                    )
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {

                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    model = imageUrl,
                    contentDescription = "cookieImage",
                    contentScale = ContentScale.Fit
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.Bottom,
                ) {
                    Text(
                        text = cookieName,
                        style = CookieboxTheme.typography.textMediumB,
                        color = Color.Black,
                    )
                    Text(
                        text = "LV.$cookieLevel",
                        style = CookieboxTheme.typography.textSmallR,
                        color = CookieboxTheme.color.grayscale40,
                    )
                    Text(
                        text = "HP.$cookieHp",
                        style = CookieboxTheme.typography.textSmallR,
                        color = CookieboxTheme.color.grayscale40,
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    CookieboxChip(
                        cardType = cardType,
                    )
                    CookieboxChip(
                        cardColor = cardColor,
                    )
                }

                Divider(
                    modifier = Modifier.padding(
                        bottom = 7.dp,
                    ),
                    color = CookieboxTheme.color.grayscale10,
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                ) {
                    skills.forEachIndexed { index, skill ->
                        Text(
                            text = buildAnnotatedString {
                                withStyle(style = SpanStyle(color = CookieboxTheme.color.grayscale40)) {
                                    append(skillCost[index])
                                }
                                append(" $skill") // 4.dp 주는거 대신 빈 공백 추가
                            },
                            style = CookieboxTheme.typography.captionR,
                            color = Color.Black
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    CookieboxButton(
                        text = "텍스트 복사",
                        buttonType = ButtonType.Secondary,
                    ) { onCopy() }
                    Spacer(modifier = Modifier.width(8.dp))
                    CookieboxButton(
                        text = "덱에 담기",
                        buttonType = ButtonType.Primary,
                    ) { onSave() }
                }
            }
        }
    }
}

@Composable
fun CookieBoxDeleteDialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    onDelete: () -> Unit,
    content: @Composable () -> Unit,
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(8.dp),
                )
                .padding(top = 16.dp, start = 8.dp, end = 8.dp, bottom = 8.dp),
        ) {
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = "정말 삭제하실 건가요?",
                style = CookieboxTheme.typography.textLargeB,
                color = Color.Black
            )

            content()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    modifier = Modifier
                        .padding(horizontal = 20.dp, vertical = 10.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = onDismissRequest
                        ),
                    text = "취소",
                    style = CookieboxTheme.typography.textMediumR,
                    color = Color.Black,
                )
                Text(
                    modifier = Modifier
                        .padding(horizontal = 20.dp, vertical = 10.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = onDelete
                        ),
                    text = "삭제",
                    style = CookieboxTheme.typography.textMediumR,
                    color = CookieboxTheme.color.red50,
                )
            }
        }
    }
}

@Preview
@Composable
fun CookieBoxDialogPreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        CookieBoxDialog(
            cookieName = "명량한 쿠키",
            cookieLevel = 2,
            cookieHp = 4,
            imageUrl = "",
            cardType = CardType.Cookie,
            cardColor = CardColor.Yellow,
            skills = listOf(
                "1데미지를 준다",
                "3데미지를 준다",
                "3데미지를 준다. 그리고 자신의 브레이크 에리어에 있는 LV.1의 카드를 한 장까지 선택한다. 그 카드를 트래시에 놓는다.",
            ),
            skillCost = listOf(
                "<믹스2>",
                "<옐로3><믹스1>",
                "<옐로2><믹스2>",
            ),
            onCopy = {},
            onSave = {},
            onDismissRequest = {},
        )

        CookieBoxDeleteDialog(
            onDismissRequest = { /*TODO*/ },
            onDelete = {},
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "아클레어 컨트롤",
                    style = CookieboxTheme.typography.textSmallR,
                    color = CookieboxTheme.color.red50,
                )
                Text(
                    text = "을 삭제하면 되돌릴 수 없어요",
                    style = CookieboxTheme.typography.textSmallR,
                    color = CookieboxTheme.color.grayscale40,
                )
            }
        }
    }
}
