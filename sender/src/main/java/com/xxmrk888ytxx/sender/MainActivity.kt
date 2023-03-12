package com.xxmrk888ytxx.sender

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.xxmrk888ytxx.sender.ui.theme.CommunicationbetweenapplicationsTheme
import com.xxmrk888ytxx.sendexobroadcastusecase.SendExoBroadcastUseCase

class MainActivity : ComponentActivity() {

    private val sendExoBroadcastUseCase by lazy {
        SendExoBroadcastUseCase(this.applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val text = rememberSaveable { mutableStateOf("") }

            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(value = text.value, onValueChange = {
                    text.value = it
                })

                Button(onClick = { sendExoBroadcastUseCase.execute(text.value) }) {
                    Text(text = "Send Exo message in acceptor app")
                }
            }
        }
    }
}
