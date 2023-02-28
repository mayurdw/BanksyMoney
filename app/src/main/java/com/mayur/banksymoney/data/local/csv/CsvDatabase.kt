package com.mayur.banksymoney.data.local.csv

import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.io.File

class CsvDatabase(fileName: String) {
    private val bufferedReader = File(fileName).bufferedReader()

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
                    date = csvRecord.get("Date"),
                    uniqueId = csvRecord.get("Unique Id"),
                    memo = csvRecord.get("Memo"),
                    amount = csvRecord.get("Amount")
                )

            listCsvTransactionItem.add(
                item
            )
        }

        return listCsvTransactionItem
    }

}