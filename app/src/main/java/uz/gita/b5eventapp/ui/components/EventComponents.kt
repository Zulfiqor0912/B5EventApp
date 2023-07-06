package uz.gita.b5eventapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.gita.b5eventapp.data.Event
import uz.gita.b5eventapp.ui.theme.B5EventAppTheme


@Composable
fun EventComponents(
    data: Event,
    onClick: (Boolean) -> Unit
) {
    var isClicked by remember {
        mutableStateOf(data.enabled)
    }
    Card(
        modifier = Modifier
            .height(86.dp)
            .fillMaxWidth()
            .padding(6.dp),
        shape = CardDefaults.elevatedShape
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp)
                .clickable {
//                    onClick.invoke()
                    isClicked = !isClicked
                },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = data.name, fontSize = 21.sp)

            Switch(checked = isClicked, onCheckedChange = {
                isClicked = it
                onClick.invoke(it)
            }, modifier = Modifier)
        }


    }
}


@Composable
@Preview
fun EventContentPreview() {
    B5EventAppTheme {
//        EventComponents(
//            event = "AirplaneMode",
//            onClick = { /*TODO*/ }
//        )
    }
}