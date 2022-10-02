private val types = listOf(
    "bump_major" to "Major",
    "bump_minor" to "Minor",
    "bump_patch" to "Patch",
)

private val targets = listOf(
    "target_lint-core" to "LintCore",
    "target_lint-quack" to "LintQuack",
    "target_lint-compose" to "LintCompose",
    "target_ui-components" to "UiComponents",
)

// contains(github.event.pull_request.labels.*.name, '${type.first}') &&
// contains(github.event.pull_request.labels.*.name, '${target.first}')

// ./gradlew bumpVersion -Ptype="${type.second}" -Ptarget="${target.second}"

// - name: Bump artifect version (type: ${type.first}, target: ${target.first})
//   if: ${{
//     (contains(github.event.pull_request.labels.*.name, '${type.first}') &&
//       contains(github.event.pull_request.labels.*.name, '${target.first}')
//     )
//     }}
//   run: ./gradlew bumpVersion -Ptype="${type.second}" -Ptarget="${target.second}"

fun main() {
    val steps = mutableListOf<String>()
    types.forEach { type ->
        targets.forEach { target ->
            val step = """
                |- name: Bump artifect version (type: ${type.first}, target: ${target.first})
                |  if: ${"$"}{{
                |    (contains(github.event.pull_request.labels.*.name, '${type.first}') &&
                |      contains(github.event.pull_request.labels.*.name, '${target.first}')
                |    )
                |    }}
                |  run: ./gradlew bumpVersion -Ptype="${type.second}" -Ptarget="${target.second}"
            """.trimMargin()
            steps.add(step)
        }
    }
    println(steps.joinToString("\n\n"))
}