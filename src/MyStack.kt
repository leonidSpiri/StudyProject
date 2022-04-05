class MyStack(capacity: Int) {
    private val array = CharArray(capacity)
    private var top = -1

    fun push(letter: Char) = if (top > array.lastIndex) println("Stack overflow") else array[++top] = letter

    fun pop(): Char = array[top--]

    fun peek(): Char = array[top]

    val isEmpty get() = top == -1
}