package com.mayur.banksymoney.ui.transactionitem.elements

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.mayur.banksymoney.R
import com.mayur.banksymoney.ui.theme.MyApplicationTheme

@Preview(
    device = Devices.DEFAULT
)
@Composable
private fun PreviewAppDropDownMenu() {
    MyApplicationTheme {
        Surface {
            AppDropDownMenu(
                itemClickedListener = {},
                expanded = true,
                dismissListener = {}
            )
        }
    }
}

@Composable
fun AppDropDownMenu(
    itemClickedListener: (item: String) -> Unit,
    expanded: Boolean,
    dismissListener: () -> Unit,
    itemList: List<String> = listOf(
        stringResource(R.string.weekly),
        stringResource(R.string.monthly),
        stringResource(R.string.yearly)
    )
) {
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = {
            dismissListener()
        }
    ) {
        itemList.forEach { item ->
            DropdownMenuItem(
                onClick = { itemClickedListener(item) },
                text = {
                    Text(text = item)
                }
            )
        }
    }
}