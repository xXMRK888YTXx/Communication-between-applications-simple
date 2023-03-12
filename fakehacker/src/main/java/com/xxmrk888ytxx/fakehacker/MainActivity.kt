package com.xxmrk888ytxx.fakehacker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.xxmrk888ytxx.fakehacker.ui.theme.CommunicationbetweenapplicationsTheme
import com.xxmrk888ytxx.sendexobroadcastusecase.SendExoBroadcastUseCase

class MainActivity : ComponentActivity() {

    private val sendExoBroadcastUseCase by lazy {
        SendExoBroadcastUseCase(this.applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(modifier = Modifier.fillMaxSize()) {
                Button(onClick = { sendExoBroadcastUseCase.execute("pwned") }) {
                    Text(text = "Hack")
                }
            }
        }
    }
}