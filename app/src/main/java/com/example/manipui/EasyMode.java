package com.example.manipui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

/*
Окно с упрозенным режимом управления
 */

public class EasyMode extends Activity {

    public EditText userMAC;

    private String MACaddress = "00:00:00:00:00";

    @Override
    protected void onCreate(Bundle savedInstances){
        super.onCreate(savedInstances);
        setContentView(R.layout.activity_easy_mode);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //получаем значение MAC адреса с предыдущего окна, и в случае неудачи заполняет его нулями
        try{
            MACaddress = getIntent().getExtras().getString("MACaddress", "00:00:00:00:00");
        }
        catch(NullPointerException e){
            MACaddress = "00:00:00:00:00";
        }

        userMAC = (EditText) findViewById(R.id.editMAC);
        userMAC.setText(MACaddress);
    }

    public void onClickBack(View view){
        Intent intent = new Intent(EasyMode.this, MainActivity.class);
        intent.putExtra("MACaddress", MACaddress);
        startActivity(intent);
    }

    public void onClickAccept(View view){
        MACaddress = userMAC.getText().toString();
    }
}
