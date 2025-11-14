package org.example.project

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.http.*
import java.io.File

actual class PlatformApiService: ApiService { // ✅ actual class, реализующий интерфейс ApiService
    private val client = HttpClient(Android) {
        install(ContentNegotiation) {
            // configure JSON if needed
        }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
    }

    override suspend fun analyzeImage(imagePath: String): Result<String> {
        return try {
            val response: String = client.post("https://your-api-endpoint.com/analyze") {
                body = MultiPartFormDataContent(
                    formData {
                        append("image", File(imagePath).readBytes(), Headers.build {
                            append(HttpHeaders.ContentType, "image/jpeg")
                            append(HttpHeaders.ContentDisposition, "filename=image.jpg")
                        })
                    }
                )
            }.body()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}