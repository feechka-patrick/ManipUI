package com.example.manipui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.w3c.dom.Text;
import static java.lang.Thread.sleep;

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
    public boolean FirstElbowMoveUp = false;
    public boolean FirstElbowMoveDown = false;

    //управление вторым коленом
    public boolean SecondElbowMoveUp = false;
    public boolean SecondElbowMoveDown = false;

    //управление платформой
    public boolean PlatformMoveLeft = false;
    public boolean PlatformMoveRight = false;

    //управление ковшом
    public boolean ClawOpen = false;
    public boolean ClawClose = false;


    //ПОТОМ УДАЛИТЬ
    public Position position = new Position();
    public TextView textPosX;
    public TextView textPosY;
    public TextView textPosZ;

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


        //ПОТОМ УДАЛИТЬ
        textPosX = (TextView) findViewById(R.id.textPosX);
        textPosY = (TextView) findViewById(R.id.textPosY);
        textPosZ = (TextView) findViewById(R.id.textPosZ);


        /*
        ПРЕВЫЙ ЛОКОТЬ
         */
        //разгибание первого локтя
        buttonFirstElbowSpread.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event){
                UpdatePos();
                switch (event.getActionMasked()){
                    case MotionEvent.ACTION_DOWN: // нажатие
                        textCurrentStatus.setText("Разгибание первого локтя");
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
                UpdatePos();
                switch (event.getActionMasked()){
                    case MotionEvent.ACTION_DOWN: // нажатие
                        textCurrentStatus.setText("Сгибание первого локтя");
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
                UpdatePos();
                switch (event.getActionMasked()){
                    case MotionEvent.ACTION_DOWN: // нажатие
                        textCurrentStatus.setText("Разгибание второго локтя");
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
                UpdatePos();
                switch (event.getActionMasked()){
                    case MotionEvent.ACTION_DOWN: // нажатие
                        textCurrentStatus.setText("Сгибание второго локтя");
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
                UpdatePos();
                switch (event.getActionMasked()){
                    case MotionEvent.ACTION_DOWN: // нажатие
                        textCurrentStatus.setText("Поворот платформы налево");
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
                UpdatePos();
                switch (event.getActionMasked()){
                    case MotionEvent.ACTION_DOWN: // нажатие
                        textCurrentStatus.setText("Поворот платформы направо");
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
                UpdatePos();
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
                UpdatePos();
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

        //многопоточность
        //нужно для прослушивания нажатия и удерживания клавиши
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
                        position.changeX();
                    }
                    if(FirstElbowMoveDown){
                        position.changeY();
                    }

                    /*
                    ВТОРОЙ ЛОКОТЬ
                     */
                    if(SecondElbowMoveUp){
                        position.changeX();
                    }
                    if(SecondElbowMoveDown){
                        position.changeY();
                    }

                    /*
                    ПЛАТФОРМА
                     */
                    if(PlatformMoveLeft){
                        position.changeZ();
                    }
                    if(PlatformMoveRight){
                        position.changeZ();
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


    //ПОТОМ УДАЛИТЬ
    private synchronized void UpdatePos() {
        textPosX.setText(String.valueOf(position.getX()));
        textPosY.setText(String.valueOf(position.getY()));
        textPosZ.setText(String.valueOf(position.getZ()));
    }
}


//временный класс
//УДАЛИТЬ
class Position{

    private long X;
    private long Y;
    private long Z;

    public Position(){
        X = 0;
        Y = 0;
        Z = 0;
    }

    public synchronized void changeX(){X++;}
    public synchronized void changeY(){Y++;}
    public synchronized void changeZ(){Z++;}

    public synchronized long getX(){return X;}
    public synchronized long getY(){return Y;}
    public synchronized long getZ(){return Z;}
}






