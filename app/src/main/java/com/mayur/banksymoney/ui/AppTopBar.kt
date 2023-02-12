package com.mayur.banksymoney.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.PopupProperties
import com.mayur.banksymoney.R
import com.mayur.banksymoney.ui.theme.MyApplicationTheme

@Preview(
    showSystemUi = true
)
@Composable
private fun PreviewAppTopBar() {
    MyApplicationTheme {
        Surface {
            AppTopBar()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    modifier: Modifier = Modifier
) {
    val itemList = listOf(
        stringResource(R.string.weekly),
        stringResource(R.string.monthly),
        stringResource(R.string.yearly)
    )
    var expanded by remember { mutableStateOf(false) }
    TopAppBar(
        modifier = modifier,
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        title = {
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(
                        id = R.string.app_name
                    ),
                    style = MaterialTheme.typography.bodyMedium
                )

                IconButton(
                    onClick = {
                        expanded = !expanded
                    }
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ArrowDropDown,
                        contentDescription = stringResource(
                            R.string.summary_period_dropdown_button
                        )
                    )
                }
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                },
                properties = PopupProperties(
                    focusable = true
                )
            ) {
                itemList.forEach { item ->
                    DropdownMenuItem(
                        onClick = {},
                        text = {
                            Text(text = item)
                        }
                    )
                }
            }
        }
    )
}