class BracketChecker(private val expression: String) {

    fun check() {
        val stack = MyStack(capacity = expression.length)
        var isGood = true
        for (i in expression.indices) {
            val element = expression[i]

            if ("({[".contains(element)) {
                stack.push(element)
                continue
            }
            if (")}]".contains(element)) {
                if (!stack.isEmpty) {
                    val tempPop = stack.pop()
                    if ((element == ')' && tempPop != '(')
                        || (element == ']' && tempPop != '[')
                        || (element == '}' && tempPop != '{')
                    ) {
                        isGood = false
                        println("Error: $element at $i")
                        break
                    }
                } else {
                    isGood = false
                    println("Error: $element at $i")
                    break
                }
            }
        }
        if (!stack.isEmpty)
            println("Error: missing right delimiter")
        else
            println("Verification completed successfully. No errors found")
    }
}
/*
for tests:
    val scanner = Scanner(System.`in`)
    val rev = BracketChecker(expression = scanner.next())
    rev.check()
 */