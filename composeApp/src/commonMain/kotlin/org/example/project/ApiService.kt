

interface ApiService {
    suspend fun analyzeImage(imagePath: String): Result<String> // Возвращает результат анализа
}