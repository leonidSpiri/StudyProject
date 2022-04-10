
fun main() {
    println("Hello World!")
    val queue = MyPriorityQueue(capacity = 10)
    for (i in 10 .. 50 step 10)
        queue.insert(i)
    println(queue.peekMin)
    while (!queue.isEmpty)
        println(queue.remove())
}