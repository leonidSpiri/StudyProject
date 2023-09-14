import java.util.*

fun main(){
    val scanner = Scanner(System.`in`)
    val enterNumb = scanner.nextInt()
    for (i1 in 0 .. 9){
        for (i2 in 0 .. 9){
            for (i3 in 0 .. 9){
                for (i4 in 0 .. 9){
                    for (i5 in 0 .. 9){
                        for (i6 in 0 .. 9){
                            val numbStr = "$i1$i2$i3$i4$i5$i6"
                            if ((i1+i2+i3 == i4+i5+i6) && (numbStr.toInt() > enterNumb)) {
                                println(numbStr)
                                return
                            }
                        }
                    }
                }
            }
        }
    }
}