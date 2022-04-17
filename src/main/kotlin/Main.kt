fun main() {
    try {
        println("Throw exception!")
        throw Exception()
    } finally {
        println("Program ended.")
    }
}