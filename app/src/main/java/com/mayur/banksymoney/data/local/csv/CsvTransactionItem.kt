package com.mayur.banksymoney.data.local.csv

import java.util.Date

data class CsvTransactionItem(
    val date: Date,
    val uniqueId: Int,
    val memo: String,
    val amount: Double
)
