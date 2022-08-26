import trash.ImageToBase64
import java.io.File
import java.util.*

fun main() {
    println("Hello World!")
    val scanner = Scanner(System.`in`)
    val imgByte = ImageToBase64().imageToBase64(scanner.next())
    File("/Users/admin/Downloads/mac.txt").writeText(imgByte)
    println("Done!")
    //println(ImageToBase64().readFromInputStream(scanner.next()))
    //println("result = " + CalcApp(input = scanner.nextLine()).doCalculate())

}

// /Users/admin/Downloads/Photos-001/ph_02.PNG
// /Users/admin/Downloads/mac.txt