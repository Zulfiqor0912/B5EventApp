package uz.gita.b5eventapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import cafe.adriel.voyager.navigator.Navigator
import uz.gita.b5eventapp.presentation.screens.home.HomeScreen
import uz.gita.b5eventapp.service.MyService
import uz.gita.b5eventapp.ui.theme.B5EventAppTheme

class MainActivity : ComponentActivity() {
    private val services = MyService()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Service start
        setContent {
            B5EventAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    mRequestPermissions()
                    Navigator(screen = HomeScreen())
                }
            }
        }
    }
//    private fun mRequestPermissions() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//            if (ContextCompat.checkSelfPermission(this@MainActivity, Manifest.permission.POST_NOTIFICATIONS)
//                == PackageManager.PERMISSION_GRANTED
//            ) {
//                services.createChannel()
//            } else {
//                myPermissionRequest.launch(Manifest.permission.POST_NOTIFICATIONS)
//            }
//        } else {
//            services.createChannel()
//        }
//    }

    private val myPermissionRequest = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
        if (isGranted) {
           services.createChannel()
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("TTT", "onResume")
        val intentService = Intent(this, MyService::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Log.d("TTT", "onResume: startForeGroundService()")
            this.startForegroundService(intentService)
        } else {
            this.startService(intentService)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    B5EventAppTheme {

    }
}