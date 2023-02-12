package com.mayur.banksymoney.ui.transactionitem.elements

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mayur.banksymoney.R
import com.mayur.banksymoney.ui.theme.MyApplicationTheme

@Composable
fun TransactionSummaryCard(
    modifier: Modifier = Modifier,
    balanceAmount: Double,
    expensesAmount: Double,
    incomeAmount: Double
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )

    ) {
        Column(
            modifier = modifier
                .padding(8.dp),
            verticalArrangement = Arrangement.Top
        ) {

            AmountHeader(
                amount = incomeAmount, headerString = R.string.income
            )

            AmountHeader(
                amount = expensesAmount, headerString = R.string.expenses
            )

            Divider(
                modifier,
                color = MaterialTheme.colorScheme.onBackground
            )

            AmountHeader(
                amount = balanceAmount, modifier = modifier, headerString = R.string.balance
            )

        }
    }
}

@Preview(
    widthDp = 640,
    showBackground = true
)
@Composable
private fun PreviewTransactionSummaryCard() {
    MyApplicationTheme {
        Surface {
            TransactionSummaryCard(
                balanceAmount = 30.00, expensesAmount = 60.00, incomeAmount = 90.00
            )
        }
    }
}

@Preview(
    widthDp = 640,
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun PreviewDarkTransactionSummaryCard() {
    MyApplicationTheme {
        Surface {
            TransactionSummaryCard(
                balanceAmount = 30.00, expensesAmount = 60.00, incomeAmount = 90.00
            )
        }
    }
}