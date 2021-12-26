package com.beyzaakkuzu.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val channel_id="channelID"
    private val channel_name="channelName"
    private val notification_id=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createNotificationChannel()
        val intent= Intent(this,MainActivity::class.java)
        val pendingIntent= TaskStackBuilder.create(this).run{
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }
        val notification= NotificationCompat.Builder(this, channel_id)
            .setContentTitle("Awesome Notification :)")
            .setContentText("This is the content text")
            .setSmallIcon(R.drawable.star)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .build()

        val notificationManager = NotificationManagerCompat.from(this)


        btnShowNotification.setOnClickListener{
            notificationManager.notify(notification_id, notification)
        }
    }


    private fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel= NotificationChannel(channel_id,channel_name,
            NotificationManager.IMPORTANCE_DEFAULT).apply {
                lightColor= Color.GREEN
                enableLights(true)
            }
            val manager = getSystemService(NOTIFICATION_SERVICE)as NotificationManager
            manager.createNotificationChannel(channel)

        }
    }
}

