object CacheValue {
    var value = 1
}

fun main() {
    val value = CacheValue
    value.value = 2
    println(CacheValue.value)
}
