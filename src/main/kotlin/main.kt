import org.jetbrains.dokka.model.doc.B

interface A {
    val a: Int
    var aa: Int
}
@Suppress("VAR_OVERRIDDEN_BY_VAL_BY_DELEGATION")
class C(a: A) : A by a/*, B*/ {
    override val a = 2
}