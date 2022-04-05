class ReverserStack(private var input: String) {
    fun doReverser(): String {
        var output = ""
        val stack = MyStack(capacity = input.length)
        for (element in input)
            stack.push(element)
        while (!stack.isEmpty)
            output += stack.pop()
        return output
    }
}

/*
for tests:
    val scanner = Scanner(System.`in`)
    val rev = ReverserStack(input = scanner.next())
    println(rev.doReverser())
*/