interface Vehicle {
    fun drive(): String
}

class CarImpl(val where: String) : Vehicle {
    override fun drive() = "is going to $where"
}

class AirplaneImpl(val where: String) : Vehicle {
    override fun drive() = "is flying to $where"
}

class CarOrAirplace(val model: String, impl: Vehicle) : Vehicle by impl {
    fun tellMeYourTrip() {
        println("$model ${drive()}")
    }
}

fun main(args: Array<String>) {
    val myAirbus330 = CarOrAirplace("Lamborghini", CarImpl("Seoul"))
    val myBoeing337 = CarOrAirplace("boeing 33u7", AirplaneImpl("Seoul"))


    myAirbus330.tellMeYourTrip()
    myBoeing337.tellMeYourTrip()
}