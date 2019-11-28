package com.example.moodtracker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import static com.example.moodtracker.R.id.edit_text_com;

public class MainActivity extends AppCompatActivity {

    private ImageView mImgHappy;
    private ImageView mClickCom;
    private ImageView mClickHistory;
    private static TextView mEdit;

    private String stringEditTextCom = "Vous n'avez encore rien écrit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImgHappy = findViewById(R.id.smiley);
        mClickCom = findViewById(R.id.com);
        mClickHistory = findViewById(R.id.history);
        mEdit = findViewById(R.id.edit_text_com);

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
                                    Toast toast = Toast.makeText(view.getContext(),"Vous n'avez rien écrit", Toast.LENGTH_SHORT);
                                    toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.BOTTOM, 0, 30);
                                    toast.show();
                                }else{
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

        // add com button listener
        mClickHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(MainActivity.this, History.class);
                startActivity(newIntent);
            }
        });
    }
}
