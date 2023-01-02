import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.request.receiveText
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@OptIn(DelicateCoroutinesApi::class)
fun main() = runBlocking {
    val serverJob = launch {
        embeddedServer(
            factory = Netty,
            module = Application::bodyPrintModule,
        ).start()
    }

    delay(3000)
    serverJob.cancelAndJoin()
}

fun Application.bodyPrintModule() {
    routing {
        get("/") {
            val bodyRawData = call.receiveText()
            call.respondText(
                """
                Hello, world!
                RawData: $bodyRawData
                """.trimIndent()
            )
        }
    }
}