import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Test

//         val employee = Employee("Gabibbo Giorgio", 1, 55.38, 0.1)

class EmployeeTest{
     /**** Constructor ****/

    @Test
     fun constructor_nameIsEmpty_IllegalArgumentException() {
         assertThrows<IllegalArgumentException> { Employee("", 1, 55.38, 0.1) }
     }

    @Test
    fun constructor_nameIsBlank_IllegalArgumentException() {
        assertThrows<IllegalArgumentException> { Employee("    ", 1, 55.38, 0.1) }
    }

    @Test
    fun constructor_hereSinceValueLowerThan0_IllegalArgumentException() {
        assertThrows<IllegalArgumentException> { Employee("Gabibbo Giorgio", -1, 55.38, 0.1) }
    }

    @Test
    fun constructor_dailyPayValueLowerThan0_IllegalArgumentException() {
        assertThrows<IllegalArgumentException> { Employee("Gabibbo Giorgio", 1, -1.25, 0.1) }
    }

    @Test
    fun constructor_dailyPayValueEqualTo0_IllegalArgumentException() {
        assertThrows<IllegalArgumentException> { Employee("Gabibbo Giorgio", 1, 0.0, 0.1) }
    }

    @Test
    fun constructor_performanceCoefficientValueLowerThan0_IllegalArgumentException() {
        assertThrows<IllegalArgumentException> { Employee("Gabibbo Giorgio", 1, 55.38, -1.36) }
    }

    @Test
    fun constructor_allParametersMeetRequirements_objectCreated() {
        val employee = Employee("Gabibbo Giorgio", 1, 55.38, 0.1)

        assertEquals("Gabibbo Giorgio", employee.name)
        assertEquals(1, employee.hereSince)
        assertEquals(55.38, employee.dailyPay)
        assertEquals(0.1, employee.performanceCoefficient)
    }


    /**** Setters ****/

    @Test
    fun setDailyPay_valueLowerThan0_IllegalArgumentException() {
        val employee = Employee("Gabibbo Giorgio", 1, 55.38, 0.1)

        assertThrows<IllegalArgumentException> { employee.dailyPay = -55.39 }
    }

    @Test
    fun setDailyPay_valueEqualTO0_IllegalArgumentException() {
        val employee = Employee("Gabibbo Giorgio", 1, 55.38, 0.1)

        assertThrows<IllegalArgumentException> { employee.dailyPay = 0.0 }
    }


    /**** Getters ****/
    @Test
    fun getHereSince_valueReturned() {
        val employee = Employee("Gabibbo Giorgio", 1, 55.38, 0.1)

        val result = employee.hereSince

        assertEquals(1, result)
    }

    @Test
    fun getDailyPay_valueReturned() {
        val employee = Employee("Gabibbo Giorgio", 1, 55.38, 0.1)

        val result = employee.dailyPay

        assertEquals(55.38, result)
    }

    @Test
    fun getPerformanceCoefficient_valueReturned() {
        val employee = Employee("Gabibbo Giorgio", 1, 55.38, 0.1)

        val result = employee.performanceCoefficient

        assertEquals(0.1, result)
    }

    @Test
    fun getName_valueReturned() {
        val employee = Employee("Gabibbo Giorgio", 1, 55.38, 0.1)

        val result = employee.name

        assertEquals("Gabibbo Giorgio", result)
    }

    /**** Functions ****/
    @Test
    fun calculateStandardBonus_valueReturned() {
        val employee = Employee("Gabibbo Giorgio", 1, 55.38, 0.1)

        val result = employee.calculateStandardBonus()

        assertEquals(10.0 * employee.dailyPay, result)
    }

    @Test
    fun calculateExcellenceBonus_valueReturned() {
        val employee = Employee("Gabibbo Giorgio", 1, 55.38, 0.1)

        val result = employee.calculateExcellenceBonus()

        assertEquals((employee.calculateStandardBonus()) + (employee.performanceCoefficient * employee.hereSince), result)
    }
 }