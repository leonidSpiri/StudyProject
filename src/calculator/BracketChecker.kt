package calculator

import MyStack

class BracketChecker(private val expression: String) {

    fun check(): Boolean {
        val stack = MyStack(capacity = expression.length)
        for (i in expression.indices) {
            val element = expression[i]

            if ("({[".contains(element)) {
                stack.push(element)
                continue
            }
            if (")}]".contains(element)) {
                if (!stack.isEmpty) {
                    val tempPop = stack.pop
                    if ((element == ')' && tempPop != '(')
                        || (element == ']' && tempPop != '[')
                        || (element == '}' && tempPop != '{')
                    )
                        throw java.lang.Exception("Error: element \"$element\" at $i")

                } else
                    throw java.lang.Exception("Error: element \"$element\" at $i")

            }
        }
        if (!stack.isEmpty)
            throw java.lang.Exception("Error: missing right delimiter")
        return true
    }
}
/*
for tests:
    val scanner = Scanner(System.`in`)
    val rev = calculator.BracketChecker(expression = scanner.next())
    rev.check()
 */