fun publishSteps() {
    val targets = listOf(
        "ReleaseTarget_LintCore" to "lint-core-publish",
        "ReleaseTarget_LintQuack" to "lint-quack-publish",
        "ReleaseTarget_LintCompose" to "lint-compose-publish",
        "ReleaseTarget_LintWriting" to "lint-writing-publish",
        "ReleaseTarget_UiComponents" to "ui-components",
    )
    val steps = mutableListOf<String>()
    targets.forEach { target ->
        val step = """
            |- name: Publish ${target.second} to MavenCentral
            |  if: contains(github.event.pull_request.labels.*.name, '${target.first}')
            |  run: ./gradlew :${target.second}:publish --scan
        """.trimMargin()
        steps.add(
            element = step,
        )
    }
    println(
        message = steps.joinToString(
            separator = "\n\n",
        ),
    )
}

fun main() {
    publishSteps()
}