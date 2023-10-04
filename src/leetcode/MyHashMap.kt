package leetcode

class MyHashMap {
    private val pairsList = mutableListOf<Pair<Int, Int>>()
    fun put(key: Int, value: Int) {
        val pair = pairsList.find { it.first == key }
        if (pair == null)
            pairsList.add(Pair(key, value))
        else {
            val index = pairsList.indexOf(pair)
            pairsList.removeAt(index)
            pairsList.add(index, Pair(key, value))
        }
    }

    fun get(key: Int): Int {
        val pair = pairsList.find { it.first == key } ?: return -1
        return pair.second
    }

    fun remove(key: Int) {
        pairsList.removeIf { it.first == key }
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */