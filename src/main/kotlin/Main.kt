fun main() {
    println(Test(1, "A").hashCode())
    println(Test(1, "A").hashCode())
}

class Test(val a: Int, val b: String)