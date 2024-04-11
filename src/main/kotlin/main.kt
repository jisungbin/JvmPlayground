interface NaverMap {
  fun data(data: Any)
}

class OverlayDelegator {
  fun NaverMap.action(data: Any) {
    data(data)
  }
}

class OverlayContributer {
  private val data = Any()
  private val delegator = OverlayDelegator()

  fun Any.contribute() {
    if (this is NaverMap) with(delegator) { action(data) }
  }
}
