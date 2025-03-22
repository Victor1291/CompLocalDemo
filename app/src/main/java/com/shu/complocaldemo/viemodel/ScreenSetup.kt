package com.shu.complocaldemo.viemodel

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.shu.complocaldemo.R
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme

@Composable
fun ScreenSetup(
    modifier: Modifier = Modifier,
    viewModel: DemoViewModel = viewModel()
) {
    TemperatureScreen(
        modifier,
        isFahrenheit = viewModel.isFahrenheit,
        result = viewModel.result,
        convertTemp = { viewModel.convertTemp(it) },
        switchChange = { viewModel.switchChange() }
    )
}

@Composable
fun TemperatureScreen(
    modifier: Modifier = Modifier,
    isFahrenheit: Boolean,
    result: String,
    convertTemp: (String) -> Unit,
    switchChange: () -> Unit
) {
    val scrollState = rememberScrollState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize().verticalScroll(scrollState)
    ) {
        var textState by remember { mutableStateOf("") }

        val onTextChange = { text: String ->
            textState = text
        }

        Text(
            "Temperature Converter",
            modifier = Modifier.padding(20.dp),
            style = MaterialTheme.typography.headlineSmall
        )

        InputRow(
            isFahrenheit = isFahrenheit,
            textState = textState,
            switchChange = switchChange,
            onTextChange = onTextChange
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                result,
                modifier = Modifier.padding(20.dp),
                style = MaterialTheme.typography.headlineMedium
            )

            Crossfade(
                targetState = isFahrenheit,
                animationSpec = tween(2000), label = ""
            ) { visible ->
                when (visible) {
                    true -> Text(
                        "\u2103", style = MaterialTheme.typography.headlineSmall
                    )

                    false -> Text(
                        "\u2109", style = MaterialTheme.typography.headlineSmall
                    )
                }
            }
        }
        Button(
            onClick = { convertTemp(textState) }
        ) {
            Text("Convert Temperature")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview(model: DemoViewModel = viewModel()) {

    CompLocalDemoTheme {

        TemperatureScreen(
            isFahrenheit = model.isFahrenheit,
            result = model.result,
            convertTemp = { model.convertTemp(it) },
            switchChange = { model.switchChange() }
        )
    }
}

@Composable
fun InputRow(
    isFahrenheit: Boolean,
    textState: String,
    switchChange: () -> Unit,
    onTextChange: (String) -> Unit
) {
    Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Switch(
            checked = isFahrenheit,
            modifier = Modifier.weight(1f),
            onCheckedChange = { switchChange() }
        )
        OutlinedTextField(
            value = textState,
            onValueChange = { onTextChange(it) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            singleLine = true,
            label = { Text("Enter temperature") },
            modifier = Modifier
                .padding(8.dp)
                .weight(4f),
            textStyle = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            ),
            trailingIcon = {
                Icon(
                    painter = painterResource(R.drawable.frozen),
                    contentDescription = "frost",
                    modifier = Modifier.size(40.dp)
                )
            }
        )
        Crossfade(
            modifier = Modifier.weight(1f),
            targetState = isFahrenheit,
            animationSpec = tween(2000), label = ""
        ) { visible ->
            when (visible) {
                true -> Text(
                    "\u2109", style = MaterialTheme.typography.headlineSmall
                )

                false -> Text(
                    "\u2103", style = MaterialTheme.typography.headlineSmall
                )
            }
        }
    }
}