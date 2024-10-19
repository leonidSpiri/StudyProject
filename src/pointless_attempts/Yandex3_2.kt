package pointless_attempts

import kotlin.coroutines.suspendCoroutine

suspend fun main() {
   print("1")
    suspendCoroutine<Unit> {cont ->
        print("2")
    }
    print("3")
}