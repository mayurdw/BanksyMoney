package com.mayur.banksymoney.ui.transactionitem.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.mayur.banksymoney.ui.theme.MyApplicationTheme

@Preview(
    widthDp = 320
)
@Composable
private fun PreviewAmountView(){
    MyApplicationTheme {
        Surface {
            AmountView(balanceAmount = 300.0)
        }
    }
}

@Composable
fun AmountView(
    modifier: Modifier = Modifier,
    balanceAmount: Double,
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {

        Text(
            text = "$ ",
            style = textStyle
        )

        Text(
            text = balanceAmount.toString(),
            style = textStyle
        )
    }
}