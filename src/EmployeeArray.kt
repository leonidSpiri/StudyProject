class EmployeeArray(capacity: Int) {
    private val employeeArray = arrayOfNulls<Employee?>(capacity)
    private var nextElement: Int = 0

    fun addNewElement(firstName: String, lastName: String, age: Int, position: String, salary: Double) {
        employeeArray[nextElement] =
            Employee(firstName = firstName, lastName = lastName, age = age, position = position, salary = salary)
        println("new employee added to array at [$nextElement].")
        if (nextElement != employeeArray.lastIndex) nextElement++
    }

    fun deleteElement(lastName: String) {
        val index = linearSearch(lastName)
        if (index != -1) {
            for (i in index until employeeArray.lastIndex) employeeArray[i] = employeeArray[i + 1]
            employeeArray[employeeArray.size - 1] = null
            nextElement--
            println("employee $lastName was deleted in array at [$index].")
        } else println("Nothing was found")
    }

    fun findEmployee(lastName: String) {
        val index = linearSearch(lastName)
        if (index != -1) println("Employee was found. Index = $index || " + employeeArray[index]!!.displayEmployee())
        else println("Nothing was found")
    }

    private fun linearSearch(lastName: String): Int {
        for (i in employeeArray.indices)
            if (employeeArray[i] != null && employeeArray[i]!!.getLastName == lastName)
                return i
        return -1
    }

    fun deleteOverPaid(){
        var max = 0.0
        var index = -1
        for (i in employeeArray.indices){
            if (employeeArray[i] != null && max < employeeArray[i]!!.getSalary){
                max = employeeArray[i]!!.getSalary
                index = i
            }
        }
        if (index != -1){
            println("overpaid employee was ${employeeArray[index]!!.getLastName} with salary ${employeeArray[index]!!.getSalary.toInt()}$")
            deleteElement(employeeArray[index]!!.getLastName)
        }
    }

    fun printArray() = employeeArray.forEach { if (it != null) println(it.displayEmployee()) }

    fun arraySize() = employeeArray.size
}
/*
for tests:
val employeeArray = EmployeeArray(10)
    employeeArray.addNewElement("name1", "last1", 12, "pos1", 2000000.0)
    employeeArray.addNewElement("name2", "last2", 13, "pos2", 3000000.0)
    employeeArray.addNewElement("name3", "last3", 14, "pos3", 4000000.0)
    employeeArray.findEmployee(lastName = "last3")
    employeeArray.addNewElement("name4", "last4", 12, "pos1", 2000000.0)
    employeeArray.addNewElement("name5", "last5", 13, "pos2", 3000000.0)
    employeeArray.addNewElement("name6", "last6", 14, "pos3", 45000000.0)
    employeeArray.deleteOverPaid()
    employeeArray.printArray()
*/