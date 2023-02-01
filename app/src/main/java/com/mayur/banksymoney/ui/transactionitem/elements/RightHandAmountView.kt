package com.mayur.banksymoney.ui.transactionitem.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mayur.banksymoney.ui.theme.MyApplicationTheme

/**
 * Displays a [Row] of content with the Amount formatted on the right side. See [AmountView]
 * @param balanceAmount -> Unformatted number, can be negative
 * @param textStyle -> The text style will be applied on [AmountView]
 * @param leftHandContent -> Composable method will displays the left hand side of the row. The view is not modified at all
 * */
@Composable
fun RightHandAmountView(
    modifier: Modifier = Modifier,
    balanceAmount: Double,
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    leftHandContent: @Composable () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        leftHandContent()

        AmountView(
            modifier = modifier,
            balanceAmount = balanceAmount,
            textStyle = textStyle
        )
    }
}

@Composable
private fun AmountView(
    modifier: Modifier = Modifier,
    balanceAmount: Double,
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {

        Text(
            text = if (balanceAmount < 0.0) "-$ " else "$ ",
            style = textStyle
        )

        Text(
            text = if (balanceAmount < 0.0) (balanceAmount.times(-1.0)).toString() else balanceAmount.toString(),
            style = textStyle
        )
    }
}

@Preview(
    name = "Right Hand Amount Preview",
    widthDp = 320
)
@Composable
private fun PreviewRightHandAmountView() {
    MyApplicationTheme {
        val textStyle = MaterialTheme.typography.bodyLarge
        Surface {
            RightHandAmountView(
                balanceAmount = 300.0,
                textStyle = textStyle,
                leftHandContent = {
                    Text(
                        text = "Test",
                        style = textStyle
                    )
                }
            )
        }
    }
}

@Preview(
    name = "Amount View Preview",
    widthDp = 320
)
@Composable
private fun PreviewAmountView() {
    MyApplicationTheme {
        Surface {
            AmountView(
                balanceAmount = -300.0
            )
        }
    }
}