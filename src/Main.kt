import calculator.CalcApp
import java.util.*

fun main() {
    println("Hello World!")
    val scanner = Scanner(System.`in`)
    println("result = " + CalcApp(input = scanner.nextLine()).doCalculate())
}