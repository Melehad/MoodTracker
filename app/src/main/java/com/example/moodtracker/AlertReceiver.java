package com.example.moodtracker;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.ImageView;

import androidx.core.app.NotificationCompat;

import static android.content.Context.MODE_PRIVATE;

public class AlertReceiver extends BroadcastReceiver {

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT_ONE = "text_one";
    public static final String TEXT_TWO = "text_two";
    public static final String TEXT = "text";
    public static final String STRCOLOR = "color";

    private String text;
    private String text_one = "first mood";
    private String text_two = "second mood";

    private String textOne;
    private String textTwo;

    private ImageView mClickComOne;
    private ImageView mClickComTwo;

    private String[] tabCom = {text_one, text_two, "", "", "", "", ""};

    @SuppressLint("ResourceAsColor")
    @Override
    public void onReceive(Context context, Intent intent) {

        int position = 0;

        NotificationHelper notificationHelper = new NotificationHelper(context);
        NotificationCompat.Builder nb = notificationHelper.getChannelNotification();
        notificationHelper.getManager().notify(1, nb.build());
        //décalage des sauvegardes

        //comYesterday(context);
        comToday(context);
        //comYesterday(context);
        //customLayout(context);
    }

    private void loadDataToday(Context context) {
        SharedPreferences sharedPreferences =  context.getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT, "");
    }

    public void saveDataToday(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TEXT_ONE, text);
        editor.apply();
    }

    private void comToday(Context context) {
        loadDataToday(context);
        saveDataToday(context);
        //text_one = text;
        tabCom[0] = text;
        for (int i=0; i<6; i++){
            tabCom[i+1] = tabCom[i];
        }

        Log.i("TAG", tabCom[6]);
    }

    /*
    if ( position > 0)
    {
        position--;
        backgroundActivity.setBackgroundColor(myColorArray[position]);
        changeSmiley.setImageResource(tabSmiley[position]);
    }

     */


    private void loadDataYesterday(Context context) {
        SharedPreferences sharedPreferences =  context.getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text_one = sharedPreferences.getString(TEXT_ONE, "");
    }

    public void saveDataYesterday(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TEXT_TWO, text_one);
        editor.apply();
    }

    private void comYesterday(Context context) {
        loadDataYesterday(context);
        saveDataYesterday(context);
        text_two = text_one;
        //Log.i("TAG", text_two);
    }

//sauvegarde en commançant par day7 "il y a une semaine"


    /*
    @SuppressLint("ResourceAsColor")
    private void customLayout(Context context) {

        mClickComOne = context.findViewById(R.id.btn_com_one);

        textOne = text_one;

        if(textOne.equals("")) {
            //mClickComOne.setVisibility(View.INVISIBLE);
            Log.i("TAG", "empty");
        } else {
            //mClickComOne.setVisibility(View.VISIBLE);
            Log.i("TAG", textOne);
        }
    }

     */



}
