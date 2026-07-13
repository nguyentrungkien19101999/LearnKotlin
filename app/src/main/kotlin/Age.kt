package com.example.learnkotlin.kotlin

import android.renderscript.Int2

fun information(age: Int) {
    when(age) {
        in 1..19 -> {
            println("$age tuoi van con non va xanh lam!")
        }

        in 20..27 -> {
            println("$age tuoi roi lay vo di khong e bay gio!")
        }

        else -> {
            println("$age tuoi thi e xu no roi!")
        }
    }
}

fun getAge(age1: Int, age2: Int) : Int {
    return age1 - age2
}

internal fun getRole(name: String) {
    when (name) {
        "Nhat Minh" -> {
            println("$name la con")
        }
        "Trung Kien" -> {
            println("$name la bo")
        }
        else -> {
            println("$name la me")
        }
    }
}