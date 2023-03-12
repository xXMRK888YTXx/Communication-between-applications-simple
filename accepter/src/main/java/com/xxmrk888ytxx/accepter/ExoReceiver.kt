package com.xxmrk888ytxx.accepter

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.xxmrk888ytxx.share.Const.ACCEPTOR_LOG_TAG
import com.xxmrk888ytxx.share.Const.EXO_ACTION
import com.xxmrk888ytxx.share.Const.EXO_DATA_KEY

class ExoReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Log.d(ACCEPTOR_LOG_TAG,"onReceive")

        if(intent.action == EXO_ACTION) {
            Log.d(ACCEPTOR_LOG_TAG,"EXO_ACTION")

            val data = intent.getStringExtra(EXO_DATA_KEY)

            if(data == "pwned")
                throw Exception("pwned")

            Log.d(ACCEPTOR_LOG_TAG,"Accepted data:$data")
        }
    }
}