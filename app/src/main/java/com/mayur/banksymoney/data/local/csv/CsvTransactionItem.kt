package com.mayur.banksymoney.data.local.csv

import java.util.*

data class CsvTransactionItem (
    val date: String,
    val uniqueId : String,
    val memo: String,
    val amount: String
)
