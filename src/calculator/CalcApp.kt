package calculator

class CalcApp(private val input: String) {
    fun doCalculate(): Int {
        val bracketChecker = BracketChecker(expression = input).check()
        if (bracketChecker) {
            val infixToPostfix = InfixToPostfix(input).trans()
            println("Infix To Postfix = $infixToPostfix")
            return PostfixCount(infixToPostfix).count()
        }
        return 0
    }
}