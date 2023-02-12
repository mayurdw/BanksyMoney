package com.mayur.banksymoney.data.local.database

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.mayur.banksymoney.R

enum class TransactionCategory(
    @StringRes val displayNameId: Int,
    @DrawableRes val drawableRes: Int
) {
    CLOTHES(R.string.clothes, R.drawable.outline_clothes_24),
    EATING_OUT(R.string.takeout, R.drawable.outline_eating_out_24),
    ELECTRONICS(R.string.electronics, R.drawable.outline_electronics_24),
    GIFT(R.string.gifts, R.drawable.outline_gift_24),
    GROCERIES(R.string.groceries, R.drawable.outline_groceries_24),
    HOME(R.string.home_stuff, R.drawable.outline_home_24),
    INTERNET(R.string.internet, R.drawable.outline_internet_24),
    INVESTMENT(R.string.investment, R.drawable.outline_investment_24),
    IGNORED(R.string.ignore, R.drawable.outline_ignored_24),
    LOAN(R.string.loan, R.drawable.outline_loan_24),
    MISC(R.string.misc, R.drawable.outline_misc_24),
    MEDICAL(R.string.medical_insurance, R.drawable.outline_medical_24),
    POWER(R.string.power, R.drawable.outline_power_24),
    RENT(R.string.rent, R.drawable.outline_rent_24),
    SMARTPHONE(R.string.phone, R.drawable.outline_smartphone_24),
    TRAVEL(R.string.travel, R.drawable.outline_travel_24),
    WATER(R.string.water, R.drawable.outline_water_24),

    // Default
    UNKNOWN(R.string.unknown, R.drawable.outline_uncategorised_24),
}