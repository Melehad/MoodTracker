package com.example.moodtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.moodtracker.MainActivity.STRCOLOR;
import static com.example.moodtracker.MainActivity.SHARED_PREFS;

public class History extends AppCompatActivity implements View.OnClickListener {

    ImageView img;
    ImageView img1;
    TextView txt;

    public static final String TEXT = "text";
    private String text;
    private Integer col;
    private ImageView mClickComOne;
    private ImageView mClickComTwo;
    private ImageView mClickComThree;
    private ImageView mClickComFour;
    private ImageView mClickComFive;
    private ImageView mClickComSix;
    private ImageView mClickComSeven;
    //private int[] reLayTab = {R.id.rel_lay_yesterday, R.id.rel_lay_day_before_yesterday, R.id.rel_lay_three_days_ago
            //, R.id.rel_lay_four_days_ago, R.id.rel_lay_five_days_ago, R.id.rel_lay_six_days_ago, R.id.rel_lay_one_week_ago};

    private String textComTest;
    private String textComToday;

    @SuppressLint({"ResourceAsColor", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        TextView txt = (TextView)findViewById(R.id.message_view);
        ImageView img = (ImageView) findViewById(R.id.thumbnail_view);

        Resources ressourcesDay = getResources();
        String[] myStringDayArray = ressourcesDay.getStringArray(R.array.stringDayArray);
        //txt.setText(myStringDayArray[4]);

        /*
        for (int nombre = 1; nombre<=100; nombre++){

        }
         */
        // 0="weekAgo">Il y a une semaine // 1="sixAgo">Il y a 6 jours // 2="fiveAgo">Il y a 5 jours
        // 3="fourAgo">Il y a 4 jours // 4="threeAgo">Il y a 3 jours // 5="twoAgo">Avant-hier // 6="oneAgo">Hier
/*
        mClickComOne = findViewById(R.id.btn_com_one);
        mClickComTwo = findViewById(R.id.btn_com_two);
        mClickComThree = findViewById(R.id.btn_com_three);
        mClickComFour = findViewById(R.id.btn_com_four);
        mClickComFive = findViewById(R.id.btn_com_five);
        mClickComSix = findViewById(R.id.btn_com_six);
        mClickComSeven = findViewById(R.id.btn_com_seven);
        mClickComOne.setVisibility(View.INVISIBLE);
        mClickComTwo.setVisibility(View.INVISIBLE);
        mClickComThree.setVisibility(View.INVISIBLE);
        mClickComFour.setVisibility(View.INVISIBLE);
        mClickComFive.setVisibility(View.INVISIBLE);
        mClickComSix.setVisibility(View.INVISIBLE);
        mClickComSeven.setVisibility(View.INVISIBLE);
 */
        Resources ressourcesColor = getResources();
        int[] myColorArray = ressourcesColor.getIntArray(R.array.colorArray);

        //RelativeLayout reLayToday = findViewById(R.id.rel_lay_today);
        //RelativeLayout reLayYesterday = findViewById(R.id.rel_lay_yesterday);
        //RelativeLayout reLayDayBeforeYesterday = findViewById(R.id.rel_lay_day_before_yesterday);
        //RelativeLayout reLayThreeDaysAgo = findViewById(R.id.rel_lay_three_days_ago);
        //RelativeLayout reLayFourDaysAgo = findViewById(R.id.rel_lay_four_days_ago);
        //RelativeLayout reLayFiveDaysAgo = findViewById(R.id.rel_lay_five_days_ago);
        //RelativeLayout reLaySixDaysAgo = findViewById(R.id.rel_lay_six_days_ago);
        //RelativeLayout reLayOneWeekAgo = findViewById(R.id.rel_lay_one_week_ago);

        comToday();
        img.setOnClickListener(this);
        //customMargin();
        //customLayout();
/*
        mClickComOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View view) {
                customToast(view);
            }
        });
        mClickComTwo.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View view) {
                customToast(view);
            }
        });
        mClickComThree.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View view) {
                customToast(view);
            }
        });
        mClickComFour.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View view) {
                customToast(view);
            }
        });
        mClickComFive.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View view) {
                customToast(view);
            }
        });
        mClickComSix.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View view) {
                customToast(view);
            }
        });
        mClickComSeven.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View view) {
                customToast(view);
            }
        });

 */
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT, "");
        col =  sharedPreferences.getInt(STRCOLOR, -1);
    }

    private void customToast(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,(ViewGroup) findViewById(R.id.custom_toast_container));
        //String strDate = getDate();
        TextView textToast = layout.findViewById(R.id.text_toast);
        //textToast.setText(strDate);
        textToast.setText(textComToday);
        Toast toast = new Toast(view.getContext());

        toast.setGravity(Gravity.BOTTOM, 0, 20);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

    /*
    @SuppressLint("ResourceAsColor")
    private void customLayout() {
        loadData();
        textComTest = text;
        if(textComTest.equals("")) {
            mClickComOne.setVisibility(View.INVISIBLE);
            mClickComTwo.setVisibility(View.INVISIBLE);
            mClickComThree.setVisibility(View.INVISIBLE);
            mClickComFour.setVisibility(View.INVISIBLE);
            mClickComFive.setVisibility(View.INVISIBLE);
            mClickComSix.setVisibility(View.INVISIBLE);
            mClickComSeven.setVisibility(View.INVISIBLE);
        } else {
            mClickComOne.setVisibility(View.VISIBLE);
            mClickComTwo.setVisibility(View.VISIBLE);
            mClickComThree.setVisibility(View.VISIBLE);
            mClickComFour.setVisibility(View.VISIBLE);
            mClickComFive.setVisibility(View.VISIBLE);
            mClickComSix.setVisibility(View.VISIBLE);
            mClickComSeven.setVisibility(View.VISIBLE);
        }
    }
     */

    /*
    private void customMargin() {
        LinearLayout linLay = findViewById(R.id.rel_lay_six_days_ago);
        // condition pour que ça règle le margin quand weight = 20
        ImageView img = (ImageView) findViewById(R.id.thumbnail_view);
        final RelativeLayout.LayoutParams mLayoutparams2 = (RelativeLayout.LayoutParams)img.getLayoutParams();
        mLayoutparams2.setMargins(0,50,15,0);
        img.setLayoutParams(mLayoutparams2);
    }
     */

    @Override
    public void onClick(View view) {

    }

    private void comToday() {
        loadData();
        textComToday = text;
        Log.i("TAG", textComToday);
    }


}
