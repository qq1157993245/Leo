package com.example.kotlin_application

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes var name:Int,
    var amount:Int,
    @DrawableRes var image:Int
)
