package calculator

import MyStack

class PostfixCount(private val input: String) {
    private val stack = MyStack(input.length)
    fun count(): Int {
        var result: Int

        for (i in input.indices) {
            val buffChar = input[i]
            if (buffChar in '0'..'9')
                stack.push(buffChar)
            else {
                val secondNumber = stack.pop.digitToInt()
                val firstNumber = stack.pop.digitToInt()
                result = when (buffChar) {
                    '+' -> firstNumber + secondNumber
                    '-' -> firstNumber - secondNumber
                    '*' -> firstNumber * secondNumber
                    '/' -> firstNumber / secondNumber
                    else -> 0
                }
                println(result.toString().toCharArray())
                val ch:Char = result.toString().toCharArray()[0]
                stack.push(ch)
            }
        }
        result = stack.pop.digitToInt()
        return result
    }
}