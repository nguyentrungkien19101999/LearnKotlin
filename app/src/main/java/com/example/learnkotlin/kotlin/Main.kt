package com.example.learnkotlin.kotlin

import com.example.learnkotlin.kotlin.model.Teacher

fun main() {
    val ageFather: Int = 28
    val ageSon: Int = 1

    information(ageFather)

    val age: Int = getAge(ageFather, ageSon)

    println("Con trai it hon bo $age tuoi")

    getRole("Trung Kien")

    val teacher = Teacher(
        name = "KienNT",
        age = 27,
        address = "Ha Noi",
        salary = "10.000.000 VND",
        level = "5")

    println("----> ${teacher.getStringTeacher()}")
}