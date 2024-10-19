package pointless_attempts

import kotlinx.coroutines.flow.flow

suspend fun main() {
    val flow = flow {
        repeat(3) { index ->
            emit(index)
        }
    }

    runCatching {
        flow.collect { value -> println(value) }
        flow.collect { value -> println(value) }
    }
}