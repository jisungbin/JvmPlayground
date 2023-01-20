@file:Suppress("LocalVariableName")

import io.ktor.http.content.PartData
import io.ktor.http.content.forEachPart
import io.ktor.http.content.streamProvider
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.request.receiveMultipart
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.routing
import java.io.File

fun main() {
    embeddedServer(
        factory = Netty,
        port = 8080,
        module = Application::modules,
    ).start(wait = true)
}

private fun Application.modules() {
    pingPongModule()
    filePostingModule()
}

private fun Application.pingPongModule() {
    routing {
        get("/") {
            call.respondText("working!")
        }
    }
}

private fun Application.filePostingModule() {
    val FileDownloadPath = "/Users/jisungbin/Downloads/ktor-server-filebody"

    routing {
        post("/") {
            var fileDescription = ""
            var fileName = ""
            val multipartData = call.receiveMultipart()

            multipartData.forEachPart { part ->
                when (part) {
                    is PartData.FormItem -> {
                        fileDescription = part.value
                    }

                    is PartData.FileItem -> {
                        fileName = part.originalFileName as String
                        val fileBytes = part.streamProvider().readBytes()
                        File("$FileDownloadPath/$fileName").writeBytes(fileBytes)
                    }

                    else -> {}
                }
                part.dispose()
            }

            call.respondText("$fileDescription is uploaded to '$FileDownloadPath/$fileName'")
        }
    }
}
