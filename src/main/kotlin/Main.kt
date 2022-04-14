import kotlinx.coroutines.CoroutineName

fun main() {
    val context = (CoroutineName("Name2") + CoroutineName("Name3")).minusKey(CoroutineName)
    println(context[CoroutineName]?.name)
}
