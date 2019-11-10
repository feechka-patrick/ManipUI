package com.example.manipui;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

    public TextView textStatus;
    public TextView textCurrentStatus;

    public Button buttonFirstElbowSpread;
    public Button buttonFirstElbowSlide;
    public Button buttonSecondElbowSpread;
    public Button buttonSecondElbowSlide;
    public Button buttonTurnLeft;
    public Button buttonTurnRight;
    public Button buttonOpen;
    public Button buttonClose;

    //управление первым коленом
    private boolean FirstElbowMoveUp = false;
    private boolean FirstElbowMoveDown = false;

    //управление вторым коленом
    private boolean SecondElbowMoveUp = false;
    private boolean SecondElbowMoveDown = false;

    //управление платформой
    private boolean PlatformMoveLeft = false;
    private boolean PlatformMoveRight = false;

    //управление ковшом
    private boolean ClawOpen = false;
    private boolean ClawClose = false;

    //подключение блютуз сокета
    private BluetoothSocket clientSocket;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //создание объектов пользовательского интрефейса на экране
        InterfaceObjectsCreate();

        //Включаем bluetooth. Если он уже включен, то ничего не произойдет
        String enableBlutooth = BluetoothAdapter.ACTION_REQUEST_ENABLE;
        startActivityForResult(new Intent(enableBlutooth), 0);
        //задаем блютуз адаптер по умолчанию
        BluetoothAdapter bluetooth = BluetoothAdapter.getDefaultAdapter();

        //пытаемся подключиться
        try{
            BluetoothDevice device = bluetooth.getRemoteDevice("тут должен быть " +
                    "адрес девайса к которому нужно будет подключиться, но его пока что нет");
        }catch(Exception e){
            textCurrentStatus.setText("Ошибка подключения \nк манипулятору");
        }

        /*
        ПРЕВЫЙ ЛОКОТЬ
         */
        //разгибание первого локтя
        buttonFirstElbowSpread.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event){
                switch (event.getActionMasked()){
                    case MotionEvent.ACTION_DOWN: // нажатие
                        textCurrentStatus.setText("Разгибание \nпервого локтя");
                        FirstElbowMoveUp = true;
                        break;
                    case MotionEvent.ACTION_MOVE: //движение
                        break;
                    case MotionEvent.ACTION_UP: //отпускание
                        textCurrentStatus.setText("Простаивание");
                        FirstElbowMoveUp = false;
                        break;
                }
                return true;
            }
        });

        //сгибание первого локтя
        buttonFirstElbowSlide.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event){
                switch (event.getActionMasked()){
                    case MotionEvent.ACTION_DOWN: // нажатие
                        textCurrentStatus.setText("Сгибание \nпервого локтя");
                        FirstElbowMoveDown = true;
                        break;
                    case MotionEvent.ACTION_MOVE: //движение
                        break;
                    case MotionEvent.ACTION_UP: //отпускание
                        textCurrentStatus.setText("Простаивание");
                        FirstElbowMoveDown = false;
                        break;
                }
                return true;
            }
        });


        /*
        ВТОРОЙ ЛОКОТЬ
         */
        //разгибание второго локтя
        buttonSecondElbowSpread.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event){
                switch (event.getActionMasked()){
                    case MotionEvent.ACTION_DOWN: // нажатие
                        textCurrentStatus.setText("Разгибание \nвторого локтя");
                        SecondElbowMoveUp = true;
                        break;
                    case MotionEvent.ACTION_MOVE: //движение
                        break;
                    case MotionEvent.ACTION_UP: //отпускание
                        textCurrentStatus.setText("Простаивание");
                        SecondElbowMoveUp = false;
                        break;
                }
                return true;
            }
        });

        //сгибание второго локтя
        buttonSecondElbowSlide.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event){
                switch (event.getActionMasked()){
                    case MotionEvent.ACTION_DOWN: // нажатие
                        textCurrentStatus.setText("Сгибание \nвторого локтя");
                        SecondElbowMoveDown = true;
                        break;
                    case MotionEvent.ACTION_MOVE: //движение
                        break;
                    case MotionEvent.ACTION_UP: //отпускание
                        textCurrentStatus.setText("Простаивание");
                        SecondElbowMoveDown = false;
                        break;
                }
                return true;
            }
        });


        /*
        УПРАВЛЕНИЕ ПЛАТФОРМОЙ
         */
        //поворот платформы налево
        buttonTurnLeft.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event){
                switch (event.getActionMasked()){
                    case MotionEvent.ACTION_DOWN: // нажатие
                        textCurrentStatus.setText("Поворот \nплатформы налево");
                        PlatformMoveLeft = true;
                        break;
                    case MotionEvent.ACTION_MOVE: //движение
                        break;
                    case MotionEvent.ACTION_UP: //отпускание
                        textCurrentStatus.setText("Простаивание");
                        PlatformMoveLeft = false;
                        break;
                }
                return true;
            }
        });

        //поворот платформы направо
        buttonTurnRight.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event){
                switch (event.getActionMasked()){
                    case MotionEvent.ACTION_DOWN: // нажатие
                        textCurrentStatus.setText("Поворот \nплатформы направо");
                        PlatformMoveRight = true;
                        break;
                    case MotionEvent.ACTION_MOVE: //движение
                        break;
                    case MotionEvent.ACTION_UP: //отпускание
                        textCurrentStatus.setText("Простаивание");
                        PlatformMoveRight = false;
                        break;
                }
                return true;
            }
        });


        /*
        УПРАВЛЕНИЕ КЛЕШНЁЙ
         */
        //расжатие ковша
        buttonOpen.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event){
                switch (event.getActionMasked()){
                    case MotionEvent.ACTION_DOWN: // нажатие
                        textCurrentStatus.setText("Открытие ковша");
                        ClawOpen = true;
                        break;
                    case MotionEvent.ACTION_MOVE: //движение
                        break;
                    case MotionEvent.ACTION_UP: //отпускание
                        textCurrentStatus.setText("Простаивание");
                        ClawOpen = false;
                        break;
                }
                return true;
            }
        });

        //сжатие ковша
        buttonClose.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event){
                switch (event.getActionMasked()){
                    case MotionEvent.ACTION_DOWN: // нажатие
                        textCurrentStatus.setText("Закрытие ковша");
                        ClawClose = true;
                        break;
                    case MotionEvent.ACTION_MOVE: //движение
                        break;
                    case MotionEvent.ACTION_UP: //отпускание
                        textCurrentStatus.setText("Простаивание");
                        ClawClose = false;
                        break;
                }
                return true;
            }
        });

        //Поток для прослушивания нажатия и удерживания клавиши
        //возможно не нужно
        Thread Listener = new Thread(new Runnable(){
            public void run(){
                while(true){
                    /*
                    Здесь должен подаваться сигнал о движении до тех пор, пока зажата кнопка
                    но пока что здесь заглушка
                     */

                    /*
                    ПЕРВЫЙ ЛОКОТЬ
                     */
                    if(FirstElbowMoveUp) {
                        //TODO
                    }
                    if(FirstElbowMoveDown){
                        //TODO
                    }

                    /*
                    ВТОРОЙ ЛОКОТЬ
                     */
                    if(SecondElbowMoveUp){
                        //TODO
                    }
                    if(SecondElbowMoveDown){
                        //TODO
                    }

                    /*
                    ПЛАТФОРМА
                     */
                    if(PlatformMoveLeft){
                        //TODO
                    }
                    if(PlatformMoveRight){
                        //TODO
                    }

                    /*
                    КОВШ
                     */
                    if(ClawOpen){
                        //Здесь действие
                    }
                    if(ClawClose){
                        //здесь тоже действие
                    }
                }
            }
        });
        Listener.start();
    }

    /*
   УПРАВЛЕНИЕ ПЕРВЫМ КОЛЕНОМ
    */
    //разгибает первое колено
    public void buttonFirstElbowSpreadClick(View view){ }

    //сгибает первое колено
    public void buttonFirstElbowSlideClick(View view){ }


    /*
    УПРАВЛЕНИЕ ВТОРЫМ КОЛЕНОМ
    */
    //разгибает второе колено
    public void buttonSecondElbowSpreadClick(View view){ }

    //сгибает второе колено
    public void buttonSecondElbowSlideClick(View view){ }


    /*
    УПРРАВЛЕНИЕ ПЛАТФОРМОЙ
     */
    //поворот платформы налево
    public void buttonTurnLeftClick(View view){ }

    //поворот платформы направо
    public void buttonTurnRightClick(View view){ }


    /*
    УПРАВЛЕНИЕ КОВШОМ
     */
    //открывает ковш
    public void buttonOpenClick(View view){ }

    //закрывает ковш
    public void buttonCloseClick(View view){ }


    //создание объектов интерфейса
    private void InterfaceObjectsCreate(){
        //создание надписей
        textStatus = (TextView) findViewById(R.id.textStatus);
        textCurrentStatus = (TextView) findViewById(R.id.textCurrentStatus);

        //создание кнопок
        buttonFirstElbowSpread = (Button) findViewById(R.id.buttonFirstElbowSpread);
        buttonFirstElbowSlide = (Button) findViewById(R.id.buttonFirstElbowSlide);
        buttonSecondElbowSpread = (Button) findViewById(R.id.buttonSecondElbowSpread);
        buttonSecondElbowSlide = (Button) findViewById(R.id.buttonSecondElbowSlide);
        buttonTurnLeft = (Button) findViewById(R.id.buttonTurnLeft);
        buttonTurnRight = (Button) findViewById(R.id.buttonTurnRight);
        buttonOpen = (Button) findViewById(R.id.buttonOpen);
        buttonClose = (Button) findViewById(R.id.buttonClose);
    }
}







