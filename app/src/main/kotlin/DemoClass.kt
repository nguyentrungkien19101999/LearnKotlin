fun main() {
    val student = Student()

    student.showInfo()
    student.showFUllName()
    println("======================")

    val customer = Customer()
    customer.showInfo()
}

class Student: Person() {
    init {
        this.name = "KienNT"
    }

    private var age = 27
    private var address = "Ha Noi"



    fun showInfo() {
        println("Name: $name")
        println("Age: $age")
        println("Address: $address")
    }

    override fun showFUllName() {
        println("aaaaaaaaaaaaaaaaaa")
    }
}

class Customer(var name: String = "", var age: Int = 0, var address: String = "") {
    init {
        name = "KienNT"
        age = 27
        address = "Ha Noi"
    }

    fun showInfo() {
        println("Name: $name")
        println("Age: $age")
        println("Address: $address")
    }
}

abstract class Person(var name: String = "") {

    abstract fun showFUllName()
}