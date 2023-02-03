package com.mayur.banksymoney.ui.transactionitem.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
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
import com.mayur.banksymoney.data.local.database.TransactionCategory
import com.mayur.banksymoney.data.local.database.TransactionItem
import com.mayur.banksymoney.ui.theme.MyApplicationTheme

@Preview(
    widthDp = 320
)
@Composable
private fun PreviewCategoryItem() {
    val transaction =
        TransactionItem(
            category = TransactionCategory.GROCERIES,
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
    transaction: TransactionItem
) {
    RightHandAmountView(
        modifier = modifier,
        balanceAmount = transaction.amount,
        leftHandContent = {
            Row(
                modifier = modifier,
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(
                        id = transaction.category.drawableRes,
                    ),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onBackground
                )

                Text(
                    modifier = modifier.padding(start = 8.dp),
                    text = transaction.category.displayName,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    )
}
