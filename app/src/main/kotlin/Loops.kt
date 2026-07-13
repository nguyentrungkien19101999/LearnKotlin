/**
 * For, while, do-while
 */
fun main() {
    val n = inputNumber()
    val sum = handleNumber(n)
    println("Tong cac vong lap = $sum")
}

fun inputNumber(): Int {
    var n: Int?

    do {
        print("Vui long nhap vao so nguyen duong N: ")
        n = readlnOrNull()?.toIntOrNull()
    }while (n == null || n <= 0)

    return n
}

fun handleNumber(n: Int): Int {
    var sum = 0

    (1..n).forEach{ i ->
        println("Vong lap thu $i")
        sum += i
    }
    return sum
}