package com.example.rockpapperscissors;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button Play;
    Button Setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Play = (Button) findViewById(R.id.Play);
        Play.setOnClickListener(this);
        Setting = (Button) findViewById(R.id.Setting);
        Setting.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.Play:
                Intent intent = new Intent(this, PlayActivity.class);
                startActivity(intent);
                break;
            case R.id.Setting:
                Intent intent2 = new Intent(this, SettingActivity.class);
                startActivity(intent2);
                break;
            default:
                break;
        }
    }
    public void onBackPressed()
    {
        finish();
        System.exit(0);
    }

}
