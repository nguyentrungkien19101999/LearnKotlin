/**
 * Collections: List
 */
fun main() {
    val list = listOf(1, 1, 3, 4)
    println("List co dinh: $list")

    val list1 = mutableListOf("1")
    list1.add("1")
    list1.add("3")

    println("List co the them: $list1")

    val list2 = list.map {
        it * 2
    }.filter {
        it > 2
    }

    println("Test list.map: $list2")

}