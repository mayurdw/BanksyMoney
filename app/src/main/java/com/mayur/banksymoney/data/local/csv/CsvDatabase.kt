package com.mayur.banksymoney.data.local.csv

import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class CsvDatabase(fileName: File) {
    private val bufferedReader = fileName.bufferedReader()

    fun getTransactionItems(): List<CsvTransactionItem> {
        val listCsvTransactionItem =
            mutableListOf<CsvTransactionItem>()
        val csvParser = CSVParser(
            bufferedReader,
            CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .withIgnoreHeaderCase()
                .withTrim()
        )

        for (csvRecord in csvParser) {
            val item =
                CsvTransactionItem(
                    date = SimpleDateFormat(
                        "yyyy/MM/dd",
                        Locale.getDefault()
                    ).parse(csvRecord.get("Date"))!!,
                    uniqueId = csvRecord.get("Unique Id").toInt(),
                    memo = csvRecord.get("Memo"),
                    amount = csvRecord.get("Amount").toDouble()
                )

            listCsvTransactionItem.add(
                item
            )
        }

        return listCsvTransactionItem
    }

}