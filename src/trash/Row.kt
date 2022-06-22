package trash

class Row {
    var column: Column? = null

    //other code
}

class Column {
    fun inc() {
        //some work
    }
}

fun extract(row: Row):Column? = run {
    with (row){
        column?.let {
           it.run{ inc() }
        }
}
    return null
}