package org.example.project

import kotlinx.coroutines.delay

class AppInitializer {
    suspend fun initialize(): Boolean {
        // Здесь может быть логика инициализации: загрузка данных, проверка токена и т.д.
        delay(2000) // имитация загрузки
        println("AppInitializer: инициализация завершена")
        return true
    }
}