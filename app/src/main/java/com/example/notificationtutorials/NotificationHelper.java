package com.example.notificationtutorials;

import android.content.Context;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class NotificationHelper {

    public static void DisplayNotification(Context context,String title,String content){
        NotificationCompat.Builder  mBuilder = new NotificationCompat.Builder(context,MainActivity.CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(title)
                .setContentText(content)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat mNotMngr = NotificationManagerCompat.from(context);
        mNotMngr.notify(1,mBuilder.build());
    }
}
