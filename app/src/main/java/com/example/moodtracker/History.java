package com.example.moodtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import static com.example.moodtracker.MainActivity.STRCOLOR;
import static com.example.moodtracker.MainActivity.SHARED_PREFS;

public class History extends AppCompatActivity {

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

    private int[] reLayTab = {R.id.rel_lay_today, R.id.rel_lay_yesterday, R.id.rel_lay_day_before_yesterday, R.id.rel_lay_three_days_ago
            , R.id.rel_lay_four_days_ago, R.id.rel_lay_five_days_ago, R.id.rel_lay_six_days_ago, R.id.rel_lay_one_week_ago};

    String textComTest;
    String textComToday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

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

        Resources res = getResources();
        int[] myColorArray = res.getIntArray(R.array.colorArray);

        RelativeLayout reLayToday = findViewById(R.id.rel_lay_today);
        RelativeLayout reLayYesterday = findViewById(R.id.rel_lay_yesterday);
        RelativeLayout reLayDayBeforeYesterday = findViewById(R.id.rel_lay_day_before_yesterday);
        RelativeLayout reLayThreeDaysAgo = findViewById(R.id.rel_lay_three_days_ago);
        RelativeLayout reLayFourDaysAgo = findViewById(R.id.rel_lay_four_days_ago);
        RelativeLayout reLayFiveDaysAgo = findViewById(R.id.rel_lay_five_days_ago);
        RelativeLayout reLaySixDaysAgo = findViewById(R.id.rel_lay_six_days_ago);
        RelativeLayout reLayOneWeekAgo = findViewById(R.id.rel_lay_one_week_ago);

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

    @SuppressLint("ResourceAsColor")
    private void customLayout() {

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


}
