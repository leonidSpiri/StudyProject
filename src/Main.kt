fun main() {
    println("Hello World!")
    val list = DoubleLinkedList()
    list.insertFirst(1)
    list.insertFirst(2)
    list.insertFirst(3)
    list.insertFirst(4)
    list.insertFirst(5)
    list.insertLast(6)
    list.insertLast(7)
    list.insertLast(8)
    list.insertLast(9)
    list.insertLast(10)

    list.displayForward()
    list.displayBackward()

    list.deleteFirst()
    list.deleteLast()
    list.deleteKey(9)

    list.displayForward()

    list.insertAfter(2, 11)
    list.insertAfter(7, 12)

    list.displayForward()
}