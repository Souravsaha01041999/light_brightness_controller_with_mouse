int bri;
char c;
void setup() {
  bri=0;
  pinMode(11,OUTPUT);
  analogWrite(11,bri);
  Serial.begin(9600);
}
void loop() {
  c=Serial.read();
  switch(c)
  {
    case 'i':
      bri+=10;
      if(bri<=255) analogWrite(11,bri);
      break;
     case 'd':
      bri-=10;
      if(bri>=0) analogWrite(11,bri);
      break;
     case 'y':
      if(bri>=0) analogWrite(11,bri);
      break;
     case 'n':
      analogWrite(11,0);
      break;
  }
}
