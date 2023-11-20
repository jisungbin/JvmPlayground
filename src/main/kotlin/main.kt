@file:OptIn(ExperimentalContracts::class)

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

fun lamda(l: () -> Unit) {
  contract { callsInPlace(l, InvocationKind.EXACTLY_ONCE) }
  l()
}

fun main() {
  val a: Int
  lamda {
    a = 1
  }
}