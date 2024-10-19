package pointless_attempts

fun main() {
    // Ввод данных
    val (N, M) = readln().split(" ").map { it.toInt() }

    val idToPerson = mutableMapOf<String, String>() // словарь: идентификатор -> имя
    val nameToPeople = mutableMapOf<String, MutableList<String>>() // словарь: имя -> список идентификаторов

    // Чтение информации о жителях
    repeat(N) {
        val (name, id) = readln().split(" ")
        val lowerId = id.lowercase()
        val lowerName = name.lowercase()
        idToPerson[lowerId] = lowerName

        nameToPeople.putIfAbsent(lowerName, mutableListOf())
        nameToPeople[lowerName]!!.add(lowerId)
    }

    var idealMatches = 0
    var satisfactoryMatches = 0

    // Чтение писем и поиск совпадений
    repeat(M) {
        val (mailName, mailId) = readln().split(" ")
        val lowerMailName = mailName.lowercase()
        val lowerMailId = mailId.lowercase()

        if (lowerMailId in idToPerson) {
            // Если идентификатор совпал
            val personName = idToPerson[lowerMailId]!!
            if (personName == lowerMailName) {
                idealMatches++
            } else {
                satisfactoryMatches++
            }
        } else {
            // Если идентификатор не совпал, проверяем по имени
            if (lowerMailName in nameToPeople && nameToPeople[lowerMailName]!!.size == 1) {
                satisfactoryMatches++
            }
        }
    }

    // Вывод результата
    println("$idealMatches $satisfactoryMatches")
}
