package com.example.xnote.fragmentos


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent


var notificationID = 1
 val tituloExtra2 ="Tienes una tarea pendiente, metalhead"
const val mensajeExtra2 = "messageExtra"

class MiReceiverParaAlarma : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val notificationUtils = NotificationUtils(context)
        val notification = notificationUtils.getNotificationBuilder(tituloExtra2).build()
        notificationUtils.getManager().notify(notificationID++, notification)
    }
}