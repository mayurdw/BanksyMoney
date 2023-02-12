/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mayur.banksymoney.ui.transactionitem

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle.State.STARTED
import androidx.lifecycle.repeatOnLifecycle
import com.mayur.banksymoney.R
import com.mayur.banksymoney.data.local.database.TransactionCategory
import com.mayur.banksymoney.data.local.database.TransactionItem
import com.mayur.banksymoney.ui.theme.MyApplicationTheme
import com.mayur.banksymoney.ui.transactionitem.elements.AppTopBar
import com.mayur.banksymoney.ui.transactionitem.elements.TransactionSummaryCard

@Composable
fun TransactionItemScreen(
    modifier: Modifier = Modifier,
    viewModel: TransactionItemViewModel = hiltViewModel()
) {
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    val items by produceState<TransactionItemUiState>(
        initialValue = TransactionItemUiState.Loading,
        key1 = lifecycle,
        key2 = viewModel
    ) {
        lifecycle.repeatOnLifecycle(state = STARTED) {
            viewModel.uiState.collect { value = it }
        }
    }

    if (items is TransactionItemUiState.Success) {
        TransactionItemScreen(
            modifier = modifier,
            items = (items as TransactionItemUiState.Success).data
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TransactionItemScreen(
    items: List<TransactionItem>,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { AppTopBar() }
    ) {
        Column(modifier.padding(it)) {
            Row(modifier = modifier.fillMaxWidth()) {
                Text(
                    text = "View By:"
                )

                Row(
                    modifier = modifier
                ) {
                    RadioButton(selected = false, onClick = {})

                    Text(
                        text = stringResource(id = R.string.yearly)
                    )
                }

                Row(
                    modifier = modifier
                ) {
                    RadioButton(selected = true, onClick = {})

                    Text(
                        text = stringResource(id = R.string.monthly)
                    )
                }
            }
            TransactionSummaryCard(
                modifier = modifier
                    .padding(bottom = it.calculateBottomPadding()),
                balanceAmount = 30.0,
                expensesAmount = 30.0,
                incomeAmount = 60.0
            )
        }
    }
}

// Previews
@Preview(
    device = Devices.DEFAULT,
    showSystemUi = true
)
@Composable
private fun PreviewTransactionItemScreen() {
    val fakeData = listOf(
        TransactionItem(category = TransactionCategory.GROCERIES, amount = 32.0),
        TransactionItem(category = TransactionCategory.RENT, amount = 330.0),
        TransactionItem(category = TransactionCategory.GROCERIES, amount = 12.2)
    )

    MyApplicationTheme {
        TransactionItemScreen(items = fakeData)
    }
}
