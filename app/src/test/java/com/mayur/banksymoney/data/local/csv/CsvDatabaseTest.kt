package com.mayur.banksymoney.data.local.csv

import junit.framework.TestCase.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.File

class CsvDatabaseTest {

    private val fileName = "testFile.csv"
    private lateinit var temporaryFile: File
    private lateinit var csvDatabase: CsvDatabase

    @Before
    fun setUp() {
        temporaryFile = File.createTempFile(fileName, "")
    }

    @After
    fun tearDown() {
        temporaryFile.deleteOnExit()
    }

    @Test
    fun checkIfFileExists() {
        assertTrue(temporaryFile.exists())

        temporaryFile.writeText("Test Text")

        assertEquals("Test Text", temporaryFile.readText())
    }

    @Test
    fun extractCsvItems() {
        temporaryFile.writeText(
            "Date,Unique Id,Tran Type,Cheque Number,Payee,Memo,Amount\n\n" +
                    "2017/01/01,2017010101,DEBIT,,\"DEBIT\",\"CARD 7515 COUNTDOWN AU CKLAND AUCKLAND\",-4.88\n" +
                    "2017/01/04,2017010401,D/C,,\"D/C FROM JAYWANT,SIDDH\",\"\",105.00\n"
        )

        csvDatabase = CsvDatabase(temporaryFile)
        val csvTransactionItems = csvDatabase.getTransactionItems()

        assertNotNull(csvTransactionItems)
        assertEquals(2, csvTransactionItems.size)
    }
}