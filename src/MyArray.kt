import java.util.Arrays

class MyArray(capacity: Int) {
    private val array: IntArray
    private var nextElement: Int

    init {
        array = IntArray(capacity)
        nextElement = 0
    }

    fun addNewElement(element: Int) {
        var loc = 0
        for (i in 0..nextElement) {
            loc = i
            if (element == array[i]) {
                println("element already exists in array at [$i]")
                return
            }
            if (element < array[i])
                break
        }

        for (j in nextElement downTo (loc + 1))
            array[j] = array[j - 1]

        array[loc] = element
        println("new element ($element) added to array at [$loc].")
        if (nextElement != array.lastIndex) nextElement++
    }

    fun addNewElement(location: Int, element: Int) {
        array[location] = element
        println("new element ($element) added to array at [$location].")
        if (nextElement != array.lastIndex) nextElement++
        sorting()
    }

    fun deleteElement(location: Int) {
        for (i in location until array.lastIndex) array[i] = array[i + 1]
        array[array.size - 1] = 0
        println("element was deleted in array at [$location].")
        nextElement--
    }

    fun deleteElement(element: Long) {
        var flag = false
        for (i in array.indices) {
            if (array[i].toLong() == element) {
                for (j in i until array.lastIndex) array[j] = array[j + 1]
                println("element ($element) was deleted in array at [$i].")
                array[array.size - 1] = 0
                flag = true
                nextElement--
            }
        }
        if (!flag) println("Nothing was found")
    }

    fun linearSearch(element: Int) {

        var flag = false
        for (i in array.indices) {
            if (array[i] == element) {
                println("element ($element) found in array at [$i].")
                flag = true
            }
        }
        if (!flag) println("Nothing was found")
    }


    fun binarySearch(element: Int) {
        var lowerBound = 0
        var upperBound = array.lastIndex
        var curIn = 0

        while (true) {
            curIn = (lowerBound + upperBound) / 2
            if (array[curIn].equals(element)) {
                println("element ($element) found in array at [$curIn].")
                return
            } else if (lowerBound > upperBound) {
                println("Nothing was found")
                return
            } else if (array[curIn] < element)
                lowerBound = curIn + 1
            else
                upperBound = curIn - 1
        }
    }

    fun printArray() {
        for (i in array.indices) println("array[ " + i + " ] = " + array[i])
    }

    fun arraySize() = array.size
    fun sorting() = Arrays.sort(array)
}

/*
for tests:
val array = MyArray(50)
    for (i in 0..60)
        array.addNewElement((3..500).random())
    var start = System.currentTimeMillis()
    array.linearSearch(23)
    Thread.sleep(0)
    var end = System.currentTimeMillis()
    println("linearSearch: ${end - start} ms")
    start = System.currentTimeMillis()
    array.binarySearch(23)
    Thread.sleep(0)
    end = System.currentTimeMillis()
    println("binarySearch: ${end - start} ms")
    array.printArray()
*/