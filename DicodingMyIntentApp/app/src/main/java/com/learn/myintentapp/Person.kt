package com.learn.myintentapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// kita menggunakan anotasi @Parcelize untuk membuat class Parcelable dengan mudah
@Parcelize
data class Person(
    // ini adalah class Parcelable yang berisi data yang akan dikirimkan
    val name: String?,
    val age: Int?,
    val email: String?,
    val city: String?
) : Parcelable