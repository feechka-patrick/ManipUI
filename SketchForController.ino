#include <Servo.h>

#define MAX_LEFT 270
#define MAX_RIGHT -90

Servo platform;
bool isTurningOnLeft = false;
bool isTurningOnRight = false;
int platformPos = 90;
char inputByte;

void setup() {
  Serial1.begin(9600);
  platform.attach(9); //установка поворотного стола при включении на 90 градусов
  platform.write(platformPos);
}

//считывание сигнала
void readSignal()
{
  if(Serial1.available() > 0)
  {
    inputByte = (char)Serial1.read();
    if(inputByte == '5')
    {
      isTurningOnRight = false;
      isTurningOnLeft = true;
    }
    if(inputByte == '6')
    {
      isTurningOnLeft = false;
      isTurningOnRight = true;
    }
    if(inputByte == '0')
    {
      isTurningOnLeft = false;
      isTurningOnRight = false;
    }
  }
}

void checkTurnLimits()
{
  if(platformPos > MAX_LEFT)
  {
    platformPos = MAX_LEFT;
  }
  if(platformPos < MAX_RIGHT)
  {
    platformPos = MAX_RIGHT;
  }
}

void loop() {

  readSignal();
  
  if(Serial1.available() == 0 && isTurningOnLeft && platformPos < MAX_LEFT)
  {
    platform.write(++platformPos);
    delay(10);
  }
  else if(Serial1.available() == 0 && isTurningOnRight && platformPos > MAX_RIGHT)
  {
    platform.write(--platformPos);
    delay(10);
  }

  checkTurnLimits();
}
