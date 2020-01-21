package com.example.moodtracker;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import static android.content.Context.MODE_PRIVATE;
import static com.example.moodtracker.MainActivity.SHARED_PREFS;
import static com.example.moodtracker.MainActivity.TEXT;


public class AlertReceiver extends BroadcastReceiver {


    private String text;
    private String textComToday;

    @SuppressLint("ResourceAsColor")
    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationHelper notificationHelper = new NotificationHelper(context);
        NotificationCompat.Builder nb = notificationHelper.getChannelNotification();
        notificationHelper.getManager().notify(1, nb.build());
        //décalage des sauvegardes

        comToday(context);
    }

    private void loadData(Context context) {
        SharedPreferences sharedPreferences =  context.getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT, "");


    }

    private void comToday(Context c) {
        loadData(c);
        Log.i("TAG", text);

        textComToday = text;

    }




}
