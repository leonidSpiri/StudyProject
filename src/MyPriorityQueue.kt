class MyPriorityQueue(private val capacity: Int) {
    private val array = IntArray(capacity)
    private var items = 0

    fun insert(element: Int) {
        var loc = 0
        if (isFull) println("Error: Queue overflow")
        else {
            if (isEmpty) array[items++] = element
            else{
                for (i in (items-1) downTo 0){
                    loc = i
                    if (element > array[i])
                        array[i+1] = array[i]
                    else break
                }
                array[loc] = element
                items++
            }
        }
    }

    fun remove(): Int = array[--items]
    val peekMin get() = array[items-1]
    val isEmpty get() = items == 0
    val isFull get() = items == capacity
    val realSize get() = items
}

/*
for tests:
    val queue = MyPriorityQueue(capacity = 10)
    for (i in 10 .. 50 step 10)
        queue.insert(i)
    println(queue.peekMin)
    while (!queue.isEmpty)
        println(queue.remove())
 */