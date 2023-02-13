package com.mayur.banksymoney.ui.transactionitem.elements

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mayur.banksymoney.data.local.database.TransactionCategory
import com.mayur.banksymoney.data.local.database.TransactionItem
import com.mayur.banksymoney.ui.theme.MyApplicationTheme

@Composable
fun TransactionCategoryList(
    modifier: Modifier = Modifier,
    transactionCategoryList: List<TransactionItem>
) {
    Column(
        modifier = modifier
            .padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            modifier = modifier.align(Alignment.Start),
            text = "Expenses By Category:",
            style = MaterialTheme.typography.bodySmall
        )

        LazyColumn(
            modifier = modifier,
            contentPadding = PaddingValues(
                vertical = 8.dp
            ),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(
                transactionCategoryList,
                contentType = { it.category }
            ) { transactionCategory ->
                TransactionItemView(
                    modifier = modifier,
                    transaction = transactionCategory
                )
            }
        }
    }
}

private val transactions = listOf(
    TransactionItem(
        amount = 3.00
    ),
    TransactionItem(
        amount = 3.01
    ),
    TransactionItem(
        amount = 3.02
    ),
    TransactionItem(

        amount = -3.03,
        category = TransactionCategory.GROCERIES
    ),
    TransactionItem(
        amount = 3.04
    ),
    TransactionItem(
        amount = 3.05,
        category = TransactionCategory.POWER
    ),
    TransactionItem(
        amount = -3.06
    ),
    TransactionItem(
        amount = 3.07
    ),
    TransactionItem(
        amount = 3.08,
        category = TransactionCategory.RENT
    ),
    TransactionItem(
        amount = 3.09
    ),
    TransactionItem(
        amount = 3.1
    ),
)

@Preview(
    name = "Light Mode",
    widthDp = 320,
    heightDp = 120,
    showBackground = true
)
@Composable
private fun PreviewTransactionCategoryList() {
    MyApplicationTheme {
        Surface {
            TransactionCategoryList(
                transactionCategoryList = transactions
            )
        }
    }
}

@Preview(
    name = "Dark Mode",
    widthDp = 320,
    heightDp = 120,
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun PreviewDarkTransactionCategoryList() {
    MyApplicationTheme {
        Surface {
            TransactionCategoryList(
                transactionCategoryList = transactions
            )
        }
    }
}


