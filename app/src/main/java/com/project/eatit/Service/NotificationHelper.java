package com.project.eatit.Service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.project.eatit.Common.Common;
import com.project.eatit.EatIt.OrderStatus;
import com.project.eatit.Model.Request;

public class NotificationHelper extends ContextWrapper {


    private static final String Channel_Id = "com.project.eatit.Service.Channel";
    private static final String Channel_Name= "Channel";
    private NotificationManager manager;
    ListenOrder listenOrder;


    public NotificationHelper(Context base) {
        super(base);
        createChannels();
    }

    @RequiresApi (api = Build.VERSION_CODES.O)
    private void createChannels() {
        NotificationChannel Channel = new NotificationChannel(Channel_Id, Channel_Name, NotificationManager.IMPORTANCE_DEFAULT );
        Channel.enableLights(true);
        Channel.enableVibration(true);
        Channel.setLightColor(Color.MAGENTA);
        Channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(Channel);


    }

    public NotificationManager getManager() {
       if(manager == null)
           manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        return manager;
    }

    public Notification.Builder getChannelNotification (String key, Request request) {
        Intent intent = new Intent(getBaseContext(), OrderStatus.class);
        intent.putExtra("userPhone", request.getPhone());
        PendingIntent contentIntent = PendingIntent.getActivity(getBaseContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        return new Notification.Builder(getApplicationContext(), Channel_Id)
                .setAutoCancel(true)
                .setWhen(System.currentTimeMillis())
                .setContentText("Your Order" + key + "is " + Common.convertCodeToStatus(request.getStatus()))
                .setContentTitle("Eat it")
                .setContentIntent(contentIntent);






    }


}
