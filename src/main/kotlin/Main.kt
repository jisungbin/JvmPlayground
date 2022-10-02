import java.io.File

val file = File("/Users/jisungbin/AndroidStudioProjects/duckie-quack-quack/playground-version.txt")
// major=0
// minor=1
// patch=0

enum class VersionType {
    Majer,
    Minor,
    Patch;
}

fun bumpVersion(
    type: VersionType,
): String {
    val lines = file.readLines().toMutableList()
    when (type) {
        VersionType.Majer -> {
            val major = lines[0].split("=")[1].toInt()
            lines[0] = "major=${major + 1}"
        }
        VersionType.Minor -> {
            val minor = lines[1].split("=")[1].toInt()
            lines[1] = "minor=${minor + 1}"
        }
        VersionType.Patch -> {
            val patch = lines[2].split("=")[1].toInt()
            lines[2] = "patch=${patch + 1}"
        }
    }
    return lines.joinToString(
        separator = "\n",
    )
}

fun main() {
    VersionType.values().forEach {
        println(bumpVersion(it))
        println("-----------")
    }
}