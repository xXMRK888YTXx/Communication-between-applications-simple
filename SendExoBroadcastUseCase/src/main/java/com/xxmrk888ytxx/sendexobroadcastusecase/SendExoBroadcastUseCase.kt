package com.xxmrk888ytxx.sendexobroadcastusecase

import android.content.Context
import android.content.Intent
import com.xxmrk888ytxx.share.Const

class SendExoBroadcastUseCase(private val context: Context) {
    fun execute(exoText:String) {
        val intent = Intent()

        intent.setClassName(
            "com.xxmrk888ytxx.accepter",
            "com.xxmrk888ytxx.accepter.ExoReceiver"
        )



        intent.action = Const.EXO_ACTION

        intent.putExtra(Const.EXO_DATA_KEY,exoText)

        context.sendBroadcast(intent)
    }
}