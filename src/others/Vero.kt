package others

fun main() {
    val list = arrayOf(31, 42, 54, 74, 55, 66, 78, 82, 92)
    val resList = arrayListOf<Int>()
    var all = 0
    for (i in list.indices) {
        for (j in list.indices) {
            if (list[i] == list[j]) continue
            all++
            val buff = "${list[i]}${list[j]}".toInt()
            if (buff % 2 != 0)
                resList.add(buff)
        }
    }
    println("\nresult:\n")
    println(resList.size)
    println("--")
    println(all)
    println()
    println(resList.toString())
}