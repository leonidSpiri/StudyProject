class Link(
    var data: Long,
    var next: Link? = null,
    var previous: Link? = null
){
    fun displayLink(){
        print("$data ")
    }
}