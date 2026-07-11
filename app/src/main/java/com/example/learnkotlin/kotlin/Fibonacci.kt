package com.example.learnkotlin.kotlin

/**
 * Viet ham nhap vao mot so nguyen N va tra ra gia tri so Fibonacci thu n
 **/
fun main() {
    inputNumber()
}

fun inputNumber() {
    print("Nhap vao so nguyen N: ")
    val n = readLine()?.toIntOrNull()

    handleNumber(n)
}

fun handleNumber(n: Int?) {
    if (n != null && n >= 0) {
        val fibonacci = fibonacci(n)
        println("So Fibonacci thu $n la: $fibonacci ")
    } else {
        println("Vui long nhap mot so nguyen duong!")
        inputNumber()
    }
}

fun fibonacci(n: Int): Int {
    var fibonacciResult = 0

    if (n <= 1) {
        fibonacciResult = n
    } else {
        var a = 0
        var b = 1
        /**
         * a = 0
         * b = 1
         * 2 = b + a = c
         * 3 = c + b = d
         * 4 = d + c = e
         * 5 = e + d = f
         * 6 = f + e = g
         */
        for (i in 2..n) {
            fibonacciResult = b + a
            a = b
            b = fibonacciResult
        }
    }
    return fibonacciResult
}