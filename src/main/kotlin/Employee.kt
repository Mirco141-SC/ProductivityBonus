import java.nio.DoubleBuffer

class Employee(val name:String, hereSinceValue:Int, dailyPayValue:Double, performanceCoefficientValue:Double) {
    init {
        require(name.isNotEmpty()){"The name of the employee must not be an empty value"}
        require(name.isNotBlank()){"The name of the employee must not be a blank value"}
        require(hereSinceValue >= 0){"The here since value must be higher or equal to 0"}
        require(dailyPayValue > 0.0){"Pay your employees!! The value of the daily pay must be higher than 0!"}
        require(performanceCoefficientValue >= 0.0){"The performance coefficient must be 0 or higher"}
    }

    var hereSince:Int = hereSinceValue
        private set(value) {
            require(hereSince >= 0){"The here since value must be higher or equal to 0"}

            field = value
        }

    var dailyPay:Double = dailyPayValue
        set(value) {
            require(dailyPay > 0.0){"Pay your employees!! The value of the daily pay must be higher than 0!"}

            field = value
        }

    var performanceCoefficient:Double = performanceCoefficientValue
        private set(value){
            require(performanceCoefficient >= 0.0){"The performance coefficient must be 0 or higher"}

            field = value
        }

    fun calculateStandardBonus(): Double {
        return 10.0 * dailyPay
    }

    fun calculateExcellenceBonus(): Double {
        val standardBonus: Double = this.calculateStandardBonus()
        val excellenceBonus: Double = performanceCoefficient * hereSince
        
        return standardBonus + excellenceBonus
    }
}