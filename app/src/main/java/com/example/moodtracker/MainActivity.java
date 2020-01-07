package com.example.moodtracker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;

import static com.example.moodtracker.R.id.background_activity;
import static com.example.moodtracker.R.id.edit_text_com;

public class MainActivity extends AppCompatActivity {

    ///////////////////////////// VARIABLES /////////////////////////////

    private ImageView changeSmiley;
    private static TextView mEdit;
    private TextView mTextComSave;

    private ImageView mImgHappy;
    private ImageView mClickCom;
    private ImageView mClickHistory;

    private String stringEditTextCom = "Vous n'avez encore rien écrit";

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    public static final String STRCOLOR = "color";

    private GestureDetector mDetector;

    private float down,up;
    static final int MIN_DISTANCE = 150;
    int position = 3;
    private int[] tabSmiley = {R.drawable.smile_sad, R.drawable.smile_disappointed,
            R.drawable.smile_normal, R.drawable.smile_happy, R.drawable.smile_sup_happy};

    private String text;
    private Integer col;
    private String textComToday;

    ///////////////////////////// ON CREATE /////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //====================== findViewById ======================//

        mImgHappy = findViewById(R.id.smiley);
        mClickCom = findViewById(R.id.com);
        mClickHistory = findViewById(R.id.history);
        mEdit = findViewById(R.id.edit_text_com);
        mTextComSave = findViewById(R.id.text_com_save);
        changeSmiley = findViewById(R.id.smiley);
        // this is the view we will add the gesture detector to
        View myView = findViewById(background_activity);

        //====================== VARIABLES ======================//

        // get the gesture detector
        mDetector = new GestureDetector(this, new MyGestureListener());
        // Add a touch listener to the view
        // The touch listener passes all its events on to the gesture detector
        myView.setOnTouchListener(touchListener);

        // add com button listener
        mClickCom.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(final View view) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setMessage("Commentaire du jour");
                builder1.setView(R.layout.comment);

                builder1.setCancelable(true);
                builder1.setPositiveButton(
                        "VALIDER",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                EditText mEditTextCom = ((AlertDialog) dialog).findViewById(edit_text_com);
                                stringEditTextCom = mEditTextCom.getText().toString();

                                if(stringEditTextCom.equals("")){
                                    saveData();
                                    Toast toast = Toast.makeText(view.getContext(),"Vous n'avez rien écrit", Toast.LENGTH_SHORT);
                                    toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.BOTTOM, 0, 30);
                                    toast.show();
                                }else{
                                    saveData();
                                    Toast toast = Toast.makeText(view.getContext(),"Commentaire enregistré", Toast.LENGTH_SHORT);
                                    toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.BOTTOM, 0, 30);
                                    toast.show();
                                }
                                dialog.cancel();
                            }
                        });
                builder1.setNegativeButton(
                        "ANNULER",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        });

        // add history button listener
        mClickHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveColorData();
                Intent newGameActivityIntent = new Intent(MainActivity.this, History.class);
                startActivity(newGameActivityIntent);
            }
        });

        loadData();
        //comToday();
        onAlarmSet(20, 39);
    }



    ///////////////////////////// OTHER METHODS /////////////////////////////

    @SuppressLint("ResourceAsColor")
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TEXT, stringEditTextCom);
        editor.apply();
    }

    public void saveColorData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(STRCOLOR, position);
        editor.apply();
    }

    // This touch listener passes everything on to the gesture detector.
    // That saves us the trouble of interpreting the raw touch events
    // ourselves.
    View.OnTouchListener touchListener = new View.OnTouchListener() {
        @SuppressLint("ClickableViewAccessibility")
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            // pass the events to the gesture detector
            // a return value of true means the detector is handling it
            // a return value of false means the detector didn't
            // recognize the event
            return mDetector.onTouchEvent(event);
        }
    };

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT, "");
        col =  sharedPreferences.getInt(STRCOLOR, -1);
    }

    private void comToday() {
        loadData();
        textComToday = text;
        Log.i("TAG", textComToday);
    }



    ///////////////////////////// GESTURE CLASS /////////////////////////////

    // In the SimpleOnGestureListener subclass you should override
    // onDown and any other gesture that you want to detect.
    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent event) {
            // don't return false here or else none of the other
            // gestures will work
            return true;}

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {return false;}
        @Override
        public void onLongPress(MotionEvent e) {}
        @Override
        public boolean onDoubleTap(MotionEvent e) {return false;}
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {return false;}

        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {
            up = event1.getY();
            down = event2.getY();
            float deltaY = up - down;


            Resources res = getResources();
            RelativeLayout backgroundActivity = findViewById(R.id.background_activity);
            int[] myColorArray = res.getIntArray(R.array.colorArray);
            // 0 red - 1 grey - 2 blue - 3 green - 4 yellow

            if ((Math.abs(deltaY) > MIN_DISTANCE) && (down < up) && position > 0)
            //slide vers le haut - montre les humeurs basses
            {
                position--;
                backgroundActivity.setBackgroundColor(myColorArray[position]);
                changeSmiley.setImageResource(tabSmiley[position]);
            }

            if ((Math.abs(deltaY) > MIN_DISTANCE) && (down > up) && position < 4)
            //slide vers le bas - montre les humeurs hautes
            {
                position++;
                backgroundActivity.setBackgroundColor(myColorArray[position]);
                changeSmiley.setImageResource(tabSmiley[position]);
            }

            Log.i("TAG", "onFling: ");

            return true;
        }



    }




    ///////////////////////////// ALARM /////////////////////////////

    public void onAlarmSet(int hourOfDay, int minute) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, 0);

        startAlarm(c);
    }
    private void startAlarm(Calendar c) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

        if (c.before(Calendar.getInstance())) {
            c.add(Calendar.DATE, 1);
        }
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);
    }

}
