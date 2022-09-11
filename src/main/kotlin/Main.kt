fun main() {
    mutableListOf(1).apply {
        this.addAll((1..10).toList())
    }
}