package com.mayur.banksymoney.ui.transactionitem.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mayur.banksymoney.R
import com.mayur.banksymoney.ui.theme.MyApplicationTheme

@Preview(
    widthDp = 320
)
@Composable
private fun PreviewCategoryItem() {
    val transaction =
        Transaction(
            icon = "Eating Out",
            category = "Eating Out",
            amount = 32.23
        )

    MyApplicationTheme {
        Surface {
            TransactionsCategoryList(transaction = transaction)
        }

    }
}


@Composable
fun TransactionsCategoryList(
    modifier: Modifier = Modifier,
    transaction: Transaction
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(
                    id = R.drawable.outline_eating_out_24,
                ),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onBackground
            )

            Text(
                modifier = modifier.padding(start = 8.dp),
                text = transaction.category,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        AmountView(
            modifier = modifier,
            balanceAmount = transaction.amount
        )
    }
}

// TODO: Make this the main Transaction item as per requirements later
data class Transaction(
    val icon: String,
    val category: String,
    val amount: Double
)