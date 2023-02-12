package com.mayur.banksymoney.ui.transactionitem.elements

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mayur.banksymoney.R
import com.mayur.banksymoney.ui.theme.MyApplicationTheme

@Preview(
    device = Devices.DEFAULT
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
    TopAppBar(
        modifier = modifier,
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        title = {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(end = 12.dp), // Needs a weird end padding because of padding on the right.
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(
                        id = R.string.app_name
                    ),
                    style = MaterialTheme.typography.titleLarge,
                )
            }
        }
    )
}