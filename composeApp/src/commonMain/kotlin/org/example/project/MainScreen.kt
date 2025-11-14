// composeApp/src/commonMain/kotlin/org/example/project/MainScreen.kt

package org.example.project

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.AppState // Импортируем AppState

// Предположим, что CameraHelper и ApiService передаются в MainScreen через DI или параметры
// Здесь мы используем фиктивные реализации для демонстрации
// actual class AndroidCameraHelper actual constructor(context: Context): CameraHelper { ... }
// actual class AndroidApiService actual constructor(): ApiService { ... }

@Composable
fun MainScreen(appState: AppState = remember { AppState() }) { // Передаём AppState
    var photoPath by remember { mutableStateOf<String?>(null) }
    var isUploading by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Оценка строительства")

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Запуск камеры - вызов через ActivityResultLauncher
                // Это требует интеграции с Android Context
                // Мы не можем вызвать Android Intent напрямую из commonMain
                // Поэтому в реальности вызов будет через ViewModel или передачу launcher
                // Пример:
                // viewModel.launchCamera()
                appState.uploadStatus = "Открываем камеру..." // Просто для UI
            },
            enabled = !isUploading
        ) {
            Text("Сделать фото")
        }

        Spacer(modifier = Modifier.height(8.dp))

        if (isUploading) {
            Text("Отправляем изображение...")
        } else {
            Button(
                onClick = {
                    // Пример отправки, если photoPath известен
                    if (photoPath != null) {
                        isUploading = true
                        appState.uploadStatus = "Отправка..."
                        // Запускаем отправку в корутине
                        // viewModel.sendImage(photoPath)
                        // Пример с фиктивным API:
                        /*
                        LaunchedEffect(photoPath) {
                            val apiService = AndroidApiService() // actual implementation
                            apiService.analyzeImage(photoPath!!).onSuccess { result ->
                                appState.analysisResult = result
                                appState.uploadStatus = "Готово"
                            }.onFailure { e ->
                                appState.uploadStatus = "Ошибка: ${e.message}"
                            }
                            isUploading = false
                        }
                        */
                        // Для демонстрации:
                        appState.analysisResult = "Прогресс: 75%, Замечания: ..."
                        appState.uploadStatus = "Готово"
                    } else {
                        appState.uploadStatus = "Сначала сделайте фото"
                    }
                },
                enabled = !isUploading && photoPath != null
            ) {
                Text("Отправить на анализ")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text("Статус: ${appState.uploadStatus}")
        Text("Результат: ${appState.analysisResult}")
    }
}