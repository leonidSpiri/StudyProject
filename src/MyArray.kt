import java.util.Arrays

class MyArray(capacity: Int) {
    private val array: IntArray
    private var nextElement: Int
    private var isSort: Boolean

    init {
        array = IntArray(capacity)
        nextElement = 0
        isSort = true
    }

    fun addNewElement(element: Int) {
        var loc = 0
        for (i in 0..nextElement) {
            loc = i
            if (element == array[i]) return
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
    }

    fun deleteElement(location: Int) {
        for (i in location until array.lastIndex) array[i] = array[i + 1]
        array[array.size - 1] = 0
        println("element was deleted in array at [$location].")
        isSort = false
    }

    fun deleteElement(element: Long) {
        var flag = false
        for (i in array.indices) {
            if (array[i].toLong() == element) {
                for (j in i until array.lastIndex) array[j] = array[j + 1]
                println("element ($element) was deleted in array at [$i].")
                array[array.size - 1] = 0
                flag = true
            }
        }
        if (!flag) println("Nothing was found")
        isSort = false
    }

    fun findElement(element: Int) {
        var flag = false
        for (i in array.indices) {
            if (array[i] == element) {
                println("element ($element) found in array at [$i].")
                flag = true
            }
        }
        if (!flag) println("Nothing was found")
    }

    fun sorting() {
        Arrays.sort(array)
        isSort = true
    }

    fun binarySearch(element: Int) {

    }

    fun printArray() {
        for (i in array.indices) println("array[ " + i + " ] = " + array[i])
    }

    fun arraySize() = array.size
}

/*
for tests:
val array = MyArray(10)
    array.addNewElement(1)
    array.addNewElement(2)
    array.addNewElement(3)
    array.addNewElement(4)
    array.printArray()
    array.addNewElement(3, 7)
    array.printArray()
    array.findElement(1)
    array.addNewElement(5)
    array.addNewElement(6)
    array.addNewElement(7)
    array.addNewElement(7, 10)
    array.addNewElement(8, 11)
    array.addNewElement(9, 102)
    array.printArray()
    array.deleteElement(7)
    array.printArray()
    array.deleteElement(1L)
    array.printArray()
    array.deleteElement(2L)
    array.printArray()
    println(array.arraySize())
    array.addNewElement(1)
    array.addNewElement(2)
    array.addNewElement(3)
    array.addNewElement(4)
    array.addNewElement(1)
    array.addNewElement(2)
    array.addNewElement(3)
    array.addNewElement(4)
    array.printArray()
    array.deleteElement(4L)
    array.printArray()
*/