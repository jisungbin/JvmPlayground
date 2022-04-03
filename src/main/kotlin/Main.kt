sealed class SnackbarValue {
    object Invisible : SnackbarValue()
    class Visible(
        val message: String,
        val autoDismiss: Int? = 3000,
    ) : SnackbarValue() {
        override fun hashCode(): Int {
            return message.hashCode() + autoDismiss.hashCode()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is Visible) return false
            if (hashCode() == other.hashCode()) return true
            return false
        }
    }
}

fun main() {
    println(SnackbarValue.Visible("123").hashCode())
    println(SnackbarValue.Visible("123").hashCode())
}