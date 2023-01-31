package com.mayur.banksymoney.ui.transactionitem.elements

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mayur.banksymoney.ui.theme.MyApplicationTheme

@Preview(
    widthDp = 320
)
@Composable
private fun PreviewBalanceHeader() {
    MyApplicationTheme {
        Surface {
            BalanceHeader(
                balanceAmount = 400.00
            )
        }
    }
}

@Preview(
    widthDp = 320,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun PreviewDarkBalanceHeader() {
    MyApplicationTheme {
        Surface {
            BalanceHeader(
                balanceAmount = 5000.00
            )
        }
    }
}


@Composable
fun BalanceHeader(
    modifier: Modifier = Modifier,
    balanceAmount: Double
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Balance",
            fontSize = 24.sp
        )

        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {

            Text(
                text = "$ ",
                fontSize = 24.sp
            )

            Text(
                text = balanceAmount.toString(),
                fontSize = 24.sp
            )
        }
    }
}