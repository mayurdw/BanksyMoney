package com.mayur.banksymoney.data.local.database

import androidx.annotation.DrawableRes
import com.mayur.banksymoney.R

enum class TransactionCategory(
    val displayName: String,
    @DrawableRes val drawableRes: Int
) {
    CLOTHES("Clothes", R.drawable.outline_clothes_24),
    EATING_OUT("Takeout/Eating Out", R.drawable.outline_eating_out_24),
    ELECTRONICS("Electronics", R.drawable.outline_electronics_24),
    GIFT("Gifts", R.drawable.outline_gift_24),
    GROCERIES("Groceries", R.drawable.outline_groceries_24),
    HOME("Home Stuff", R.drawable.outline_home_24),
    INTERNET("Internet", R.drawable.outline_internet_24),
    INVESTMENT("Investment", R.drawable.outline_investment_24),
    IGNORED("Ignore", R.drawable.outline_ignored_24),
    LOAN("Loan/Parents", R.drawable.outline_loan_24),
    MISC("Misc", R.drawable.outline_misc_24),
    MEDICAL("Medical/Insurance", R.drawable.outline_medical_24),
    POWER("Power", R.drawable.outline_power_24),
    RENT("Rent", R.drawable.outline_rent_24),
    SMARTPHONE("Phone", R.drawable.outline_smartphone_24),
    TRAVEL("Travel", R.drawable.outline_travel_24),
    WATER("Water", R.drawable.outline_water_24),

    // Default
    UNKNOWN("Unknown", R.drawable.outline_uncategorised_24),
}