package com.mayur.banksymoney.ui.transactionitem.elements

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mayur.banksymoney.data.local.database.TransactionCategory
import com.mayur.banksymoney.data.local.database.TransactionItem
import com.mayur.banksymoney.ui.theme.MyApplicationTheme

@Composable
fun TransactionSummaryCard(
    modifier: Modifier = Modifier,
    transactionCategoryList: List<TransactionItem>,
    balanceAmount: Double
) {
    Card(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )

    ) {
        BalanceHeader(
            balanceAmount = balanceAmount, modifier = modifier
        )

        Divider(
            modifier = modifier.padding(8.dp),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Text(
            modifier = modifier.padding(start = 8.dp),
            text = "Amount Per Category",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold
        )

        TransactionCategoryList(
            modifier = modifier,
            transactionCategoryList = transactionCategoryList
        )
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
                transactionCategoryList = listOf(
                    TransactionItem(
                        amount = 32.9
                    ),
                    TransactionItem(
                        category = TransactionCategory.GROCERIES,
                        amount = 4.3
                    )
                ),
                balanceAmount = 30.00
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
                transactionCategoryList = listOf(
                    TransactionItem(
                        amount = 32.9
                    ),
                    TransactionItem(
                        category = TransactionCategory.GROCERIES,
                        amount = 4.3
                    )
                ),
                balanceAmount = 30.00
            )
        }
    }
}