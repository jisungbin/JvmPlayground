import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonReader.Options
import com.squareup.moshi.JsonReader.Token
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okio.BufferedSource

private const val TOKEN = "..."
private val client = OkHttpClient()

fun main() {
  client.newCall(starredRepositories()).execute().use { response ->
    val source = response.body!!.source()
    val repositories = starredRepositoryNameDeserialization(source)
    println(repositories)
  }
}

private fun starredRepositoryNameDeserialization(source: BufferedSource): List<String> =
  buildList {
    JsonReader.of(source).use { reader ->
      reader.beginArray()
      while (reader.peek() == Token.BEGIN_OBJECT) {
        reader.beginObject()
        while (reader.hasNext()) {
          if (reader.selectName(Options.of("full_name")) == 0) {
            add(reader.nextString())
          } else {
            reader.skipValue() // can't skip this object group?
          }
        }
        reader.endObject()
      }
      reader.endArray()
    }
  }

private fun starredRepositories() =
  Request.Builder()
    .url(
      HttpUrl.Builder()
        .scheme("https")
        .host("api.github.com")
        .addPathSegments("user/starred")
        .addQueryParameter("per_page", "100")
        .build(),
    )
    .header("Accept", "application/vnd.github+json")
    .header("Authorization", "Bearer $TOKEN")
    .header("X-GitHub-Api-Version", "2022-11-28")
    .build()
