import okhttp3.OkHttpClient
import okhttp3.Request

fun main() {
    continuationNetworkCall {
        println("Network Call Finish")
    }
}

fun continuationNetworkCall(callcc: () -> Unit) {
    val client = OkHttpClient()
    val request = Request.Builder()
        .url("https://sungb.in")
        .build()
    val response = client.newCall(request).execute()
    println(response.body?.string())
    callcc()
}

fun directNetworkCall() {
    val client = OkHttpClient()
    val request = Request.Builder()
        .url("https://sungb.in")
        .build()
    val response = client.newCall(request).execute()
    println(response.body?.string())
}
