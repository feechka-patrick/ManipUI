package com.example.manipui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

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

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        textStatus = (TextView) findViewById(R.id.textStatus);
        textCurrentStatus = (TextView) findViewById(R.id.textCurrentStatus);

        buttonFirstElbowSpread = (Button) findViewById(R.id.buttonFirstElbowSpread);
        buttonFirstElbowSlide = (Button) findViewById(R.id.buttonFirstElbowSlide);
        buttonSecondElbowSpread = (Button) findViewById(R.id.buttonSecondElbowSpread);
        buttonSecondElbowSlide = (Button) findViewById(R.id.buttonSecondElbowSlide);
        buttonTurnLeft = (Button) findViewById(R.id.buttonTurnLeft);
        buttonTurnRight = (Button) findViewById(R.id.buttonTurnRight);
        buttonOpen = (Button) findViewById(R.id.buttonOpen);
        buttonClose = (Button) findViewById(R.id.buttonClose);


        /*
        ПРЕВЫЙ ЛОКОТЬ
         */
        //разгибание первого локтя
        buttonFirstElbowSpread.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event){
                switch (event.getActionMasked()){
                    case MotionEvent.ACTION_DOWN: // нажатие
                        //TODO: движение
                        textCurrentStatus.setText("Разгибание первого локтя");
                        break;
                    case MotionEvent.ACTION_MOVE: //движение
                        break;
                    case MotionEvent.ACTION_UP: //отпускание
                        //TODO: отпускание
                        textCurrentStatus.setText("Простаивание");
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
                        //TODO: движение
                        textCurrentStatus.setText("Сгибание первого локтя");
                        break;
                    case MotionEvent.ACTION_MOVE: //движение
                        break;
                    case MotionEvent.ACTION_UP: //отпускание
                        //TODO: отпускание
                        textCurrentStatus.setText("Простаивание");
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
                        //TODO: движение
                        textCurrentStatus.setText("Разгибание второго локтя");
                        break;
                    case MotionEvent.ACTION_MOVE: //движение
                        break;
                    case MotionEvent.ACTION_UP: //отпускание
                        //TODO: отпускание
                        textCurrentStatus.setText("Простаивание");
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
                        //TODO: движение
                        textCurrentStatus.setText("Сгибание второго локтя");
                        break;
                    case MotionEvent.ACTION_MOVE: //движение
                        break;
                    case MotionEvent.ACTION_UP: //отпускание
                        //TODO: отпускание
                        textCurrentStatus.setText("Простаивание");
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
                        //TODO: движение
                        textCurrentStatus.setText("Поворот платформы налево");
                        break;
                    case MotionEvent.ACTION_MOVE: //движение
                        break;
                    case MotionEvent.ACTION_UP: //отпускание
                        //TODO: отпускание
                        textCurrentStatus.setText("Простаивание");
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
                        //TODO: движение
                        textCurrentStatus.setText("Поворот платформы направо");
                        break;
                    case MotionEvent.ACTION_MOVE: //движение
                        break;
                    case MotionEvent.ACTION_UP: //отпускание
                        //TODO: отпускание
                        textCurrentStatus.setText("Простаивание");
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
                        //TODO: движение
                        textCurrentStatus.setText("Открытие ковша");
                        break;
                    case MotionEvent.ACTION_MOVE: //движение
                        break;
                    case MotionEvent.ACTION_UP: //отпускание
                        //TODO: отпускание
                        textCurrentStatus.setText("Простаивание");
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
                        //TODO: движение
                        textCurrentStatus.setText("Закрытие ковша");
                        break;
                    case MotionEvent.ACTION_MOVE: //движение
                        break;
                    case MotionEvent.ACTION_UP: //отпускание
                        //TODO: отпускание
                        textCurrentStatus.setText("Простаивание");
                        break;
                }
                return true;
            }
        });
    }

    /*
    УПРАВЛЕНИЕ ПЕРВЫМ КОЛЕНОМ
     */
    //разгибает первое колено
    public void buttonFirstElbowSpreadClick(View view){

    }

    //сгибает первое колено
    public void buttonFirstElbowSlideClick(View view){

    }


    /*
    УПРАВЛЕНИЕ ВТОРЫМ КОЛЕНОМ
    */
    //разгибает второе колено
    public void buttonSecondElbowSpreadClick(View view){

    }

    //сгибает второе колено
    public void buttonSecondElbowSlideClick(View view){

    }


    /*
    УПРРАВЛЕНИЕ ПЛАТФОРМОЙ
     */
    //поворот платформы налево
    public void buttonTurnLeftClick(View view){

    }

    //поворот платформы направо
    public void buttonTurnRightClick(View view){

    }


    /*
    УПРАВЛЕНИЕ КОВШОМ
     */
    //открывает ковш
    public void buttonOpenClick(View view){

    }

    //закрывает ковш
    public void buttonCloseClick(View view){

    }

}
