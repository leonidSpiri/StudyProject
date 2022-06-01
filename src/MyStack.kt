class MyStack(capacity: Int) {
    private val array = CharArray(capacity)
    private var top = -1

    fun push(letter: Char) =
        if (top > array.lastIndex) throw StackOverflowError("index is more than stack capacity")
        else array[++top] = letter

    fun peekOther(n: Int): Char = array[n]
    val pop get() = array[top--]
    val peek get() = array[top]
    val isEmpty get() = top == -1
    val size get() = top + 1

    fun printArray() {
        for (i in 0..top) println("array[ " + i + " ] = " + array[i].toString())
    }
}