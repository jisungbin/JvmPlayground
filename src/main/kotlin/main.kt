import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonReader.Options
import com.squareup.moshi.JsonReader.Token
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.coroutines.executeAsync
import okio.BufferedSource

private const val TOKEN = "..."
private val client = OkHttpClient()

@OptIn(ExperimentalCoroutinesApi::class)
fun main() = runBlocking {
  repeat(50) { page ->
    launch(Dispatchers.IO) {
      client.newCall(starredRepositories(page)).executeAsync().use { response ->
        val source = response.body.source()
        val repositories = starredRepositoryNameDeserialization(source)
        println("[$page] result: $repositories")

        repositories.forEach { repository ->
          val (owner, repo) = repository.split('/')
          launch(Dispatchers.IO) {
            client.newCall(unstarringRepository(owner, repo)).executeAsync().use { response ->
              println("[$page] unstarring $repository: ${response.code}")
            }
          }
        }
      }
    }
  }
}

private fun starredRepositoryNameDeserialization(source: BufferedSource): List<String> =
  buildList {
    try {
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
    } catch (exception: Exception) {
      println("Failed to deserialize: $exception\n\n${source.buffer.snapshot().utf8()}")
    }
  }

private fun starredRepositories(page: Int): Request =
  Request.Builder()
    .url(
      HttpUrl.Builder()
        .scheme("https")
        .host("api.github.com")
        .addPathSegments("user/starred")
        .addQueryParameter("page", page.toString())
        .addQueryParameter("per_page", "100")
        .build(),
    )
    .header("Accept", "application/vnd.github+json")
    .header("Authorization", "Bearer $TOKEN")
    .header("X-GitHub-Api-Version", "2022-11-28")
    .build()

private fun unstarringRepository(owner: String, repo: String): Request =
  Request.Builder()
    .url(
      HttpUrl.Builder()
        .scheme("https")
        .host("api.github.com")
        .addPathSegments("user/starred/$owner/$repo")
        .build(),
    )
    .header("Accept", "application/vnd.github+json")
    .header("Authorization", "Bearer $TOKEN")
    .header("X-GitHub-Api-Version", "2022-11-28")
    .delete()
    .build()
