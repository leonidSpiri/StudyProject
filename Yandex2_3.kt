package pointless_attempts

fun main() {
    val path = readln()

    var pedestrianCrossings = 0
    var leftRoad = true

    for (i in path.indices) {
        when (path[i]) {
            '1' -> {
                if (leftRoad && (i == path.length - 1 || path[i + 1] != '2')) {
                    pedestrianCrossings++
                    leftRoad = false
                }
            }
            '2' -> {
                if (!leftRoad && (i == path.length - 1 || path[i + 1] != '1')) {
                    pedestrianCrossings++
                    leftRoad = true
                }
            }
            '3' -> {
                pedestrianCrossings++
                if (i < path.length - 1) {
                    if (path[i + 1] == '1') {
                        leftRoad = false
                    } else if (path[i + 1] == '2') {
                        leftRoad = true
                    }
                }
            }
        }
    }
    if (leftRoad) pedestrianCrossings++
    println(pedestrianCrossings)
}

/*
fun main() {
    val path = readln()

    var pedestrianCrossings = 0
    var leftRoad = true

    for (char in path) {
        when (char) {
            '1' -> {
                if (leftRoad) {
                    pedestrianCrossings++
                    leftRoad = false
                }
            }
            '2' -> {
                if (!leftRoad) {
                    pedestrianCrossings++
                    leftRoad = true
                }
            }
            '3' -> {
                pedestrianCrossings++
            }
        }
    }
    if (leftRoad) pedestrianCrossings++
    println(pedestrianCrossings)
}
*/