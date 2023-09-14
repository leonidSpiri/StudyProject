class DoubleLinkedList {
    private var first: Link? = null
    private var last: Link? = null

    fun isEmpty() = first == null

    fun insertFirst(d: Long) {
        val newLink = Link(d)
        if (isEmpty())
            last = newLink
        else
            first?.previous = newLink
        newLink.next = first
        first = newLink
    }

    fun insertLast(d: Long) {
        val newLink = Link(d)
        if (isEmpty())
            first = newLink
        else {
            last?.next = newLink
            newLink.previous = last
        }
        last = newLink
    }

    fun deleteFirst(): Link? {
        val temp = first
        if (first?.next == null)
            last = null
        else
            first?.next?.previous = null
        first = first?.next
        return temp
    }

    fun deleteLast(): Link? {
        val temp = last
        if (first?.next == null)
            first = null
        else
            last?.previous?.next = null
        last = last?.previous
        return temp
    }

    fun insertAfter(key: Long, d: Long): Boolean {
        var current = first
        while (current?.data != key) {
            current = current?.next
            if (current == null)
                return false
        }
        val newLink = Link(d)
        if (current == last) {
            newLink.next = null
            last = newLink
        } else {
            newLink.next = current.next
            current.next?.previous = newLink
        }
        newLink.previous = current
        current.next = newLink
        return true
    }

    fun deleteKey(key: Long): Link? {
        var current = first
        while (current?.data != key) {
            current = current?.next
            if (current == null)
                return null
        }
        if (current == first)
            first = current.next
        else
            current.previous?.next = current.next
        if (current == last)
            last = current.previous
        else
            current.next?.previous = current.previous
        return current
    }

    fun displayForward() {
        print("List (first --> last): ")
        var current = first
        while (current != null) {
            current.displayLink()
            current = current.next
        }
        println()
    }

    fun displayBackward() {
        print("List (last --> first): ")
        var current = last
        while (current != null) {
            current.displayLink()
            current = current.previous
        }
        println()
    }
}

/*
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
    */