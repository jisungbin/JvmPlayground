private val types = listOf(
    "bump_major" to "Major",
    "bump_minor" to "Minor",
    "bump_patch" to "Patch",
)

fun artifectVersionBump() {
    val targets = listOf(
        "target_lint-core" to "LintCore",
        "target_lint-quack" to "LintQuack",
        "target_lint-compose" to "LintCompose",
        "target_ui-components" to "UiComponents",
    )
    val steps = mutableListOf<String>()
    types.forEach { type ->
        targets.forEach { target ->
            val step = """
                |- name: Bump artifect version (type_${type.second}, target_${target.second})
                |  if: ${"$"}{{
                |      contains(github.event.pull_request.labels.*.name, '${type.first}') &&
                |      contains(github.event.pull_request.labels.*.name, '${target.first}')
                |    }}
                |  run: ./gradlew bumpVersion -Ptype="${type.second}" -Ptarget="${target.second}"
            """.trimMargin()
            steps.add(step)
        }
    }
    println(steps.joinToString("\n\n"))
}

fun playgroundVersionBump() {
    val steps = mutableListOf<String>()
    types.forEach { type ->
        val step = """
            |- name: Bump playground ${type.second} version
            |  if: contains(github.event.pull_request.labels.*.name, '${type.first}')
            |  run: ./gradlew bumpVersion -Ptype="${type.second}" -Ptarget="Playground"
            """.trimMargin()
        steps.add(step)
    }
    println(steps.joinToString("\n\n"))
}

fun publishSteps() {
    val targets = listOf(
        "target_lint-core" to "lint-core-publish",
        "target_lint-quack" to "lint-quack-publish",
        "target_lint-compose" to "lint-compose-publish",
        "target_ui-components" to "ui-components",
    )
    val steps = mutableListOf<String>()
    targets.forEach { target ->
        val step = """
            |- name: Publish ${target.second} to MavenCentral
            |  if: contains(github.event.pull_request.labels.*.name, '${target.first}')
            |  run: ./gradlew :${target.second}:publish --no-paralle
            """.trimMargin()
        steps.add(step)
    }
    println(steps.joinToString("\n\n"))
}

fun main() {
    publishSteps()
}