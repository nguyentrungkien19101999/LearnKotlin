package com.example.learnkotlin.kotlin.model

open class Person(var name: String, var age: Int, var address: String) {
    override fun toString(): String {
        return "Person(name='$name', age=$age, address='$address')"
    }
}