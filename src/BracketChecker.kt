class BracketChecker(private val expression:String) {

    fun check(){
        val stack = MyStack(capacity = expression.length)
        var isGood = true
        for (i in expression.indices){
            val element = expression[i]
            if ("({[".contains(element)){
                stack.push(element)
                break
            }
            if (")}]".contains(element)){
                if (!stack.isEmpty) {
                    val tempPop = stack.pop()
                    if ((element == ')' && tempPop != ')')
                        || (element == ']' && tempPop != ']')
                        || (element == '}' && tempPop != '}')
                    ) {
                        isGood = false
                        println("Error: $tempPop at $i")
                        break
                    }
                }
                else {
                    isGood = false
                    println("Error: $element at $i")
                    break
                }
            }
        }
        if (!stack.isEmpty){
                isGood = false
                println("Error: missing right delimiter")
            }
    }
}