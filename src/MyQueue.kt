class MyQueue(private val capacity: Int) {
    private val array = IntArray(capacity)
    private var front = 0
    private var rear = -1
    private var items = 0

    fun insert(element: Int) {
        if (isFull) println("Error: Queue overflow")
        else {
            if (rear == array.lastIndex)
                rear = -1
            array[++rear] = element
            items++
        }
    }

    fun remove(): Int {
        val tempElement = array[front++]
        if (front == capacity)
            front = 0
        items--
        return tempElement
    }

    val frontPeek get() = array[front]
    val rearPeek get() = array[rear]
    val isEmpty get() = items == 0
    val isFull get() = items == capacity
    val realSize get() = items
}

/*
for tests:
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
 */