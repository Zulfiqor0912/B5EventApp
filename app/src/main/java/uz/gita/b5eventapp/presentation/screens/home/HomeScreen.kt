package uz.gita.b5eventapp.presentation.screens.home


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.androidx.AndroidScreen
import uz.gita.b5eventapp.data.allEvents
import uz.gita.b5eventapp.ui.components.EventComponents
import uz.gita.b5eventapp.ui.theme.B5EventAppTheme

class HomeScreen : AndroidScreen() {

    @Composable
    override fun Content() {
        HomeScreenContent()
    }
}

@Composable
fun HomeScreenContent() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn {
            items(allEvents) { data ->
                EventComponents(data = data) {
                    data.enabled = it
                }
            }
        }
    }
}


@Composable
@Preview
fun HomeScreenContentPreview() {
    B5EventAppTheme {
        HomeScreenContent()
    }
}