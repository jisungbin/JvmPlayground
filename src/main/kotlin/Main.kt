fun main() {
    val list = listOf("안녕", "안녕녕", "안녕녕녕", "안녕녕녕녕녕녕녕녕", "안")
    val index = list.maxBy { item ->
        item.length
    }.let { item ->
        list.indexOf(item)
    }
    println(index)
    println(list[index])
}