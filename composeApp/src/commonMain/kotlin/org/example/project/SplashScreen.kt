// composeApp/src/commonMain/kotlin/com/yourpackage/SplashScreen.kt
package org.example.project
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


@OptIn(ExperimentalResourceApi::class)
@Composable
fun SplashScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Логотип (если есть в ресурсах)
        // Image(
        //     painter = painterResource("ic_launcher.png"),
        //     contentDescription = "Logo",
        //     modifier = Modifier.size(128.dp)
        // )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Building Coverage",
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        CircularProgressIndicator()
    }
}