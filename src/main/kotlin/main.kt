interface Root
interface Test<A : Root, B : Root>

fun Test<*, *>.hi() {}