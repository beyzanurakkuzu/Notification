## Notification :star:

Notifications provide short, timely information about events in your app while it's not in use.

**Set Android Notification Properties**
---------

The properties of Android notification are set using NotificationCompat.Builder object. Some of the notification properties are mentioned below:

- **setSmallIcon()**: it sets the icon of notification.
- **setContentTitle()**: it is used to set the title of notification.
- **setContentText()**: it is used to set the text message.
- **setAutoCancel()**: it sets the cancelable property of notification.
- **setPriority()**: it sets the priority of notification.

```kotlin        
val notification= NotificationCompat.Builder(this, channel_id)
            .setContentTitle("Awesome Notification :)")
            .setContentText("This is the content text")
            .setSmallIcon(R.drawable.star)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .build()
```


**Create A Channel**
```kotlin
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
 ```
  ```kotlin
createNotificationChannel()
 // Create an explicit intent for an Activity in your app
        val intent= Intent(this,MainActivity::class.java)
        val pendingIntent= TaskStackBuilder.create(this).run{
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
 ```            
