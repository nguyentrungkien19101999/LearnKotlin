package com.example.learnkotlin.kotlin.model

class Teacher(name: String,
              age: Int,
              address: String,
              var salary: String,
              var level: String): Person(name, age, address) {
    override fun toString(): String {
        return "Teacher(salary='$salary', level='$level', ${super.toString()})"
    }
}