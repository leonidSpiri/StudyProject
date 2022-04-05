import java.util.Scanner

fun main() {
    println("Hello World!")
    val queue = MyQueue(capacity = 10)
    for (i in 0 until 10)
        queue.insert(i)
    println(queue.isFull)
    println(queue.rearPeek)
    println(queue.frontPeek)
    println(queue.remove())
    println(queue.frontPeek)
    for (i in 10 until 15) {
        println(queue.remove())
        queue.insert(i)
    }
    println(queue.rearPeek)
    println(queue.frontPeek)
}