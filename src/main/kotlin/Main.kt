fun main() {
    try {
        val employee1 = Employee("Roberto Umarell", 5, 55.25, 1.2)
        val employee2 = Employee("Nicola Pieri", 1, 12.25, 0.2)

        val employee1StandardBonus = employee1.calculateStandardBonus()
        val employee2ExcellenceBonus = employee2.calculateExcellenceBonus()

        println(
            "---- Final Report ----\n" +
            "${employee1.name}'s standard bonus: $employee1StandardBonus €\n" +
            "${employee2.name}'s excellence bonus: $employee2ExcellenceBonus €\n" +
            "----------------------\n"
        )
    } catch(err: IllegalArgumentException) {
        println("One of the value wasn't accepted by the class.\n ${err.message}")
    } catch(err: Exception) {
        println("There was a general error while running the program.\n ${err.message}")
    }
}