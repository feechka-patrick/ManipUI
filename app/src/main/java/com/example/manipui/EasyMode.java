package com.example.manipui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

/*
Окно с упрозенным режимом управления
 */

public class EasyMode extends Activity {

    @Override
    protected void onCreate(Bundle savedInstances){
        super.onCreate(savedInstances);
        setContentView(R.layout.activity_easy_mode);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void onClickBack(View view){
        Intent intent = new Intent(EasyMode.this, MainActivity.class);
        startActivity(intent);
    }
}
