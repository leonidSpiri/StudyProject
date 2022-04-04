class Employee(
    private val firstName: String,
    private val lastName: String,
    private var age: Int,
    private var position: String,
    private var salary: Double = 0.0
) {
    fun displayEmployee(): String =
        "first name: $firstName || last name: $lastName || age: $age || position: $position || salary: $salary$"

    val getLastName get() = lastName
    val getSalary get() = salary
}