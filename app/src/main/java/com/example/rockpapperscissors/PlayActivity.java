package com.example.rockpapperscissors;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class PlayActivity extends AppCompatActivity {


    int rounds = SettingActivity.roundsGame;
    public static int wonRounds = 0;
    public static int loseRounds = 0;
    public static boolean win = false,lose = false;
    ImageButton rock,paper,scissor;
    TextView round;
    TextView info;
    TextView yourSroce;
    TextView IIscore;
    ImageView robot;
    TextView gosetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_play);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        rock = findViewById(R.id.Rock);
        paper = findViewById(R.id.Papper);
        scissor = findViewById(R.id.Scissors);
        round = findViewById(R.id.result);
        info = findViewById(R.id.textViewInfo);
        yourSroce = findViewById(R.id.OurScore);
        IIscore = findViewById(R.id.IIsroce);
        robot = findViewById(R.id.robot);
        gosetting = findViewById(R.id.GoSetting);
        info.setText(Integer.toString(rounds));

        if(rounds == 0)
        {
            rock.setEnabled(false);
            paper.setEnabled(false);
            scissor.setEnabled(false);
            gosetting.setText("Выберете количество раундов");
        }
        //камень - 0
        rock.setOnClickListener(v-> {
                Random random = new Random();
                switch (random.nextInt(3))
                {
                    case 0:
                        robot.setImageResource(R.drawable.rock);
                        round.setText("Ничья");
                        break;
                    case 1:
                        robot.setImageResource(R.drawable.scissors);
                        round.setText("Победа");
                        wonRounds++;
                        yourSroce.setText(Integer.toString(wonRounds));
                        //Победа
                        if (wonRounds == rounds)
                        {
                            win = true;
                            wonRounds = 0;
                            loseRounds = 0;
                            round.setText("Вы выиграли!!!");
                            round.setTextColor(Color.GREEN);
                            rock.setEnabled(false);
                            paper.setEnabled(false);
                            scissor.setEnabled(false);
                            // Intent intent = new Intent(PlayActivity.this,WinOrLoseActivity.class);
                            // startActivity(intent);
                        }
                        break;
                    case 2:
                        robot.setImageResource(R.drawable.paper);
                        round.setText("Проигрыш");
                        loseRounds++;
                        IIscore.setText(Integer.toString(loseRounds));
                        //Поражение
                        if (loseRounds == rounds)
                        {
                            lose = true;
                            wonRounds = 0;
                            loseRounds = 0;
                            round.setText("Вы проиграли");
                            round.setTextColor(Color.RED);
                            rock.setEnabled(false);
                            paper.setEnabled(false);
                            scissor.setEnabled(false);
                            // Intent intent = new Intent(PlayActivity.this, WinOrLoseActivity.class);
                           // startActivity(intent);
                        }
                        break;
                }
        });
        //Ножницы - 1
        scissor.setOnClickListener(v -> {
                Random random = new Random();
                switch (random.nextInt(3))
                {
                    case 0:
                        robot.setImageResource(R.drawable.rock);
                        round.setText("Проигрыш");
                        loseRounds++;
                        IIscore.setText(Integer.toString(loseRounds));
                        //Проигрыш
                        if (loseRounds == rounds)
                        {
                            lose = true;
                            wonRounds = 0;
                            loseRounds = 0;
                            round.setText("Вы проиграли");
                            round.setTextColor(Color.RED);
                            rock.setEnabled(false);
                            paper.setEnabled(false);
                            scissor.setEnabled(false);
                            //Intent intent = new Intent(PlayActivity.this, WinOrLoseActivity.class);
                            //startActivity(intent);
                        }
                        break;
                    case 1:
                        robot.setImageResource(R.drawable.scissors);
                        round.setText("Ничья");
                        break;
                    case 2:
                        robot.setImageResource(R.drawable.paper);
                        round.setText("Победа");
                        wonRounds++;
                        yourSroce.setText(Integer.toString(wonRounds));
                        //Победа
                        if (wonRounds == rounds)
                        {
                            win = true;
                            wonRounds = 0;
                            loseRounds = 0;
                            round.setText("Вы выиграли!!!");
                            round.setTextColor(Color.GREEN);
                            rock.setEnabled(false);
                            paper.setEnabled(false);
                            scissor.setEnabled(false);
                            //Intent intent = new Intent(PlayActivity.this, WinOrLoseActivity.class);
                            //startActivity(intent);
                        }
                        break;
                }
        });
        //Бумага - 2
        paper.setOnClickListener(v -> {
                Random random = new Random();
                switch (random.nextInt(3))
                {
                    case 0:
                        robot.setImageResource(R.drawable.rock);
                        round.setText("Победа");
                        wonRounds++;
                        yourSroce.setText(Integer.toString(wonRounds));
                        //Победа
                        if (wonRounds == rounds)
                        {
                            win = true;
                            wonRounds = 0;
                            loseRounds = 0;
                            round.setText("Вы выиграли!!!");
                            round.setTextColor(Color.GREEN);
                            rock.setEnabled(false);
                            paper.setEnabled(false);
                            scissor.setEnabled(false);
                            //Intent intent = new Intent(PlayActivity.this, WinOrLoseActivity.class);
                            //startActivity(intent);
                        }
                        break;
                    case 1:
                        robot.setImageResource(R.drawable.scissors);
                        round.setText("Проигрыш");
                        loseRounds++;
                        IIscore.setText(Integer.toString(loseRounds));
                        //Поражение
                        if (loseRounds == rounds)
                        {
                            lose = true;
                            wonRounds = 0;
                            loseRounds = 0;
                            round.setText("Вы проиграли");
                            round.setTextColor(Color.RED);
                            rock.setEnabled(false);
                            paper.setEnabled(false);
                            scissor.setEnabled(false);
                           // Intent intent = new Intent(PlayActivity.this, WinOrLoseActivity.class);
                            //startActivity(intent);
                        }
                        break;
                    case 2:
                        robot.setImageResource(R.drawable.paper);
                        round.setText("Ничья");
                        break;
                }
        });
    }

    public void onBackPressed()
    {
        wonRounds = 0;
        loseRounds = 0;
        Intent intent = new Intent(PlayActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}