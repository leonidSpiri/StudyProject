fun main() {
    println("Hello World!")
    val employeeArray = EmployeeArray(10)
    employeeArray.addNewElement("name3", "evans", 14, "pos3", 4000000.0)
    employeeArray.addNewElement("name4", "smith", 12, "pos1", 2000000.0)
    employeeArray.addNewElement("name5", "smith", 13, "pos2", 3000000.0)
    employeeArray.addNewElement("name6", "smith", 14, "pos3", 45000000.0)
    employeeArray.addNewElement("name3", "yee", 14, "pos3", 4000000.0)
    employeeArray.addNewElement("name4", "hashmito", 12, "pos1", 2000000.0)
    employeeArray.addNewElement("name5", "stimson", 13, "pos2", 3000000.0)
    employeeArray.addNewElement("name6", "velas", 14, "pos3", 45000000.0)
    employeeArray.addNewElement("name1", "avang", 12, "pos1", 2000000.0)
    employeeArray.addNewElement("name2", "creswell", 13, "pos2", 3000000.0)

    employeeArray.lastNameSort()
    employeeArray.printArray()
}