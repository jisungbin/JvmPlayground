import kotlin.math.sqrt

fun main() {
    (1..30).filter(::checkPrime).forEach(::println)
}

private fun checkPrime(n: Int): Boolean {
    // Number less than or equal 1 is not prime
    if (n <= 1) {
        return false
    }

    // 2 is only even prime number
    if (n == 2) {
        return true
    }

    // Check if number (> 2) is even. If yes, it is not prime.
    if (n % 2 == 0) {
        return false
    }

    var flag = true

    val root = sqrt(n.toDouble()).toInt()

    // We need to check till square root of n only to find whether n is prime.
    for (i in 3..root step 2) {
        if ((n % i) == 0) {
            flag = false
            break
        }
    }

    return flag
}
