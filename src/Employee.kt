class Employee(
    private val firstName: String,
    private val lastName: String,
    private var age: Int,
    private var position: String,
    private var salary: Double = 0.0
) {
    fun displayEmployee() {
        println("first name: $firstName")
        println("last name: $lastName")
        println("age: $age")
        println("position: $position")
        println("salary: $salary$")
    }

    val getLastName get() = lastName
}