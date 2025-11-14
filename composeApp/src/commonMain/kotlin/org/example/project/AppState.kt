

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class AppState {
    var uploadStatus by mutableStateOf<String?>("Готово")
    var analysisResult by mutableStateOf<String?>("Нет результата")
}