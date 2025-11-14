

interface CameraHelper {
    suspend fun takePicture(): Result<String> // Возвращает путь к сохранённому файлу
}