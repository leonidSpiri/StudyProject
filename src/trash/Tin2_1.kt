package trash


fun main() {
    val s = readln().toInt()
    val n = readln().toInt()
    var remainingData = n
    var currentServer = s
    while (remainingData >= currentServer) {
        remainingData -= currentServer
        currentServer = if (currentServer == 1) s else currentServer - 1
    }
    println(remainingData)
}
