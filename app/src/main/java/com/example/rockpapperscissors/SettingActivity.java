package com.example.rockpapperscissors;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SettingActivity extends AppCompatActivity {

    public static final String PREF_VAL = "PREF_VAL";
    public TextView value;
    public static int roundsGame;
    private SharedPreferences mPrefs;
    Button minusBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        value = findViewById(R.id.Count);
        minusBtn = findViewById(R.id.minus);
        updateValue(getValue());
        //gameRounds = new Intent(this,PlayActivity.class);
        findViewById(R.id.plus).setOnClickListener(v -> {
            updateValue(getValue() + 1);
        });
        findViewById(R.id.minus).setOnClickListener(v -> {
            if(roundsGame == 0){
                updateValue(getValue());
            }
            else {
                updateValue(getValue() - 1);
            }
        });

        findViewById(R.id.reset).setOnClickListener(v ->{
            updateValue(0);
        });
    }

    public void updateValue(int NewRounds){
        mPrefs.edit().putInt(PREF_VAL,NewRounds).apply();
        value.setText(String.valueOf(NewRounds));
        roundsGame = NewRounds;
    }

    private int getValue(){
        return mPrefs.getInt(PREF_VAL, 0);
    }
}
