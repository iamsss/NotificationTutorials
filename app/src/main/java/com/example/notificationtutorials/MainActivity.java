package com.example.notificationtutorials;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String CHANNEL_ID = "waplocal_id";
    public static final String CHANNEL_NAME = "Waplocal";
    public static final String CHANNEL_DESC ="WapLocal Desciption";

    Button notBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            //Create Notification Channel
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);

        }

        notBtn = findViewById(R.id.not_btn);
        notBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNotification();
            }
        });
    }

    private void DisplayNotification(){
        NotificationCompat.Builder  mBuilder = new NotificationCompat.Builder(this,CHANNEL_ID)
                                                    .setSmallIcon(R.drawable.ic_launcher_background)
                                                    .setContentTitle("Hurray Its Notification")
                .setContentText("Your First Notification")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat mNotMngr = NotificationManagerCompat.from(this);
        mNotMngr.notify(1,mBuilder.build());
    }
}
