package com.example.moodtracker;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import static com.example.moodtracker.MainActivity.STRCOLOR;
import static com.example.moodtracker.MainActivity.SHARED_PREFS;


public class History extends AppCompatActivity implements View.OnClickListener {

    ///////////////////////////// VARIABLES /////////////////////////////

    private ListView mListView;
    ImageView img;
    ImageView img1;
    TextView txt;

    public static final String TEXT = "text";
    public static final String TEXT_ONE = "text_one";
    private String text_one = "first mood";
    public static final String TEXT_TWO = "text_two";
    private String text_two = "second mood";

    private String text;
    private Integer col;
    private String textComToday;

    private String textOne;
    private String textTwo;

    // variables of comment buttons
    /**/
    private ImageView mClickComOne;
    private ImageView mClickComTwo;
    private ImageView mClickComThree;
    private ImageView mClickComFour;
    private ImageView mClickComFive;
    private ImageView mClickComSix;
    private ImageView mClickComSeven;

     /**/


    ///////////////////////////// ON CREATE /////////////////////////////

    @SuppressLint({"ResourceAsColor", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_2);

        //====================== findViewById ======================//

        RelativeLayout rel7 = (RelativeLayout)findViewById(R.id.customView7);
        TextView txt = (TextView)findViewById(R.id.message_view);
        ImageView img = (ImageView) findViewById(R.id.thumbnail_view);
        mListView = (ListView) findViewById(R.id.listView);

        // findView of comment buttons

        mClickComOne = findViewById(R.id.btn_com_one);
        mClickComTwo = findViewById(R.id.btn_com_two);
        mClickComThree = findViewById(R.id.btn_com_three);
        mClickComFour = findViewById(R.id.btn_com_four);
        mClickComFive = findViewById(R.id.btn_com_five);
        mClickComSix = findViewById(R.id.btn_com_six);
        mClickComSeven = findViewById(R.id.btn_com_seven);
        /*
        mClickComOne.setVisibility(View.INVISIBLE);
        mClickComTwo.setVisibility(View.INVISIBLE);
        mClickComThree.setVisibility(View.INVISIBLE);
        mClickComFour.setVisibility(View.INVISIBLE);
        mClickComFive.setVisibility(View.INVISIBLE);
        mClickComSix.setVisibility(View.INVISIBLE);
        mClickComSeven.setVisibility(View.INVISIBLE);
        */

        //====================== VARIABLES ======================//

        Resources ressourcesDay = getResources();
        String[] myStringDayArray = ressourcesDay.getStringArray(R.array.stringDayArray);
        //txt.setText(myStringDayArray[4]);

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

        //img.setOnClickListener(this);
        //customMargin();
        //customLayout();
        //afficherListeDays();

        // setOnClickListener of comment buttons

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

        loadData();
        customLayout();
    }

    ///////////////////////////// OTHER METHODS /////////////////////////////

    @Override
    public void onClick(View view) {

    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT, "");
        col =  sharedPreferences.getInt(STRCOLOR, -1);
    }

    //Access to ListView
    /*
    private List<Days> genererDays(){
        Resources ressourcesDay = getResources();
        String[] myStringDayArray = ressourcesDay.getStringArray(R.array.stringDayArray);

        List<Days> days = new ArrayList<Days>();
        days.add(new Days(Color.BLACK, myStringDayArray[0]));
        days.add(new Days(Color.BLUE, myStringDayArray[1]));
        days.add(new Days(Color.GREEN, myStringDayArray[2]));
        days.add(new Days(Color.RED, myStringDayArray[3]));
        days.add(new Days(Color.GRAY, myStringDayArray[4]));
        days.add(new Days(Color.YELLOW, myStringDayArray[5]));
        days.add(new Days(Color.MAGENTA, myStringDayArray[6]));
        return days;
    }

    private void afficherListeDays(){
        List<Days> days = genererDays();

        DaysAdapter adapter = new DaysAdapter(History.this, days);
        mListView.setAdapter(adapter);
    }

     */


    ///////////////////////////// CUSTOM /////////////////////////////


    private void customToast(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,(ViewGroup) findViewById(R.id.custom_toast_container));
        //String strDate = getDate();
        TextView textToast = layout.findViewById(R.id.text_toast);
        //textToast.setText(strDate);
        textToast.setText(textOne);

        Toast toast = new Toast(view.getContext());

        toast.setGravity(Gravity.BOTTOM, 0, 20);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }


    @SuppressLint("ResourceAsColor")
    private void customLayout() {


        loadDataYesterday();
        //loadData2daysAgo();

    }



    // customMargin
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



    private void loadDataYesterday() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text_one = sharedPreferences.getString(TEXT_ONE, "");
        textOne = text_one;
        if(textOne.equals("")) {
            mClickComOne.setVisibility(View.INVISIBLE);
            Log.i("TAG", "empty");
        } else {
            mClickComOne.setVisibility(View.VISIBLE);
            Log.i("TAG", "com d'hier : " + textOne);
        }
    }

    private void loadData2daysAgo() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text_two = sharedPreferences.getString(TEXT_TWO, "");
        textTwo = text_two;
        if(textTwo.equals("")) {
            mClickComTwo.setVisibility(View.INVISIBLE);
            //Log.i("TAG", "empty");
        } else {
            mClickComTwo.setVisibility(View.VISIBLE);
            //Log.i("TAG", textTwo);
        }
    }


}
