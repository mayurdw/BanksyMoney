package com.mayur.banksymoney.ui.transactionitem.elements

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mayur.banksymoney.ui.theme.MyApplicationTheme

@Composable
fun BalanceHeader(
    modifier: Modifier = Modifier,
    balanceAmount: Double
) {
    RightHandAmountView(
        modifier = modifier,
        balanceAmount = balanceAmount,
        leftHandContent = {
            Text(
                modifier = it.padding(top = 8.dp),
                text = "Balance",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    )
}

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