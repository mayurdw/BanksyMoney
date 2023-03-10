package com.mayur.banksymoney.ui.transactionitem.elements

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mayur.banksymoney.R
import com.mayur.banksymoney.ui.theme.MyApplicationTheme

@Composable
fun AmountHeader(
    modifier: Modifier = Modifier,
    amount: Double,
    @StringRes headerString: Int
) {
    RightHandAmountView(
        modifier = modifier,
        balanceAmount = amount,
        textStyle = MaterialTheme.typography.bodyLarge,
        leftHandContent = {
            Text(
                modifier = it.wrapContentSize(
                    align = Alignment.Center
                ),
                text = stringResource(headerString),
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
            AmountHeader(
                amount = 400.00,
                headerString = R.string.balance
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
            AmountHeader(
                amount = 5000.00,
                headerString = R.string.income
            )
        }
    }
}