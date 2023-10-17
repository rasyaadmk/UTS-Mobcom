package com.example.utsmobcomtutor.Modul

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Matkul(
    @StringRes val matkul: Int,
    @StringRes val sks: Int,
    @DrawableRes val image: Int
)
