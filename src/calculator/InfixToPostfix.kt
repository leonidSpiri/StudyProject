package calculator

import MyStack

class InfixToPostfix(private val input: String) {
    private var output = ""
    private val stack = MyStack(input.length)

    fun trans(): String {
        for (i in input.indices) {
            when (val buffChar = input[i]) {
                '+', '-' -> gotOperand(buffChar, 1)
                '*', '/' -> gotOperand(buffChar, 2)
                '(' -> stack.push(buffChar)
                ')' -> gotBracket()
                else -> output += buffChar
            }
        }
        while (!stack.isEmpty) {
            output += stack.pop
        }
        return output
    }

    private fun gotBracket() {
        while (!stack.isEmpty){
            val newChar = stack.pop
            if (newChar == '(') break
            else output+=newChar
        }
    }

    private fun gotOperand(buffChar: Char, priority: Int) {
        while (!stack.isEmpty) {
            val topOperand = stack.pop
            if (topOperand == '(') {
                stack.push(topOperand)
                break
            } else {
                val newPriority = if (topOperand == '+' || topOperand == '-') 1
                else 2
                if (newPriority < priority) {
                    stack.push(topOperand)
                    break
                } else output += topOperand
            }
        }
        stack.push(buffChar)
    }
}