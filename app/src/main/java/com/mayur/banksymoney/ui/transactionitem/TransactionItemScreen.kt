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

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle.State.STARTED
import androidx.lifecycle.repeatOnLifecycle
import com.mayur.banksymoney.data.local.database.TransactionCategory
import com.mayur.banksymoney.data.local.database.TransactionItem
import com.mayur.banksymoney.ui.transactionitem.elements.GraphicalHistoryView
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

@Composable
internal fun TransactionItemScreen(
    items: List<TransactionItem>,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        GraphicalHistoryView(
            xAxisLabelStrings = listOf("Jan", "Feb", "Mar"),
            yAxisValueIntegers = listOf(20.0, 13.2, 18.8)
        )

        TransactionSummaryCard(
            transactionCategoryList = items, balanceAmount = 300.2
        )
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

    TransactionItemScreen(items = fakeData)
}
