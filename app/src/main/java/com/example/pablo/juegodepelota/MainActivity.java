package com.example.pablo.juegodepelota;

import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends ActionBarActivity implements SensorEventListener {

    private SensorManager sensorManager;

    private boolean color = false;
    private boolean bandera = false;
    private View view;
    private long lastUpdate;
    private ImageView imageView;
    private float x = 0;
    private float y = 0;
    private float z = 0;
    int tiempo = 0;
    AbsoluteLayout.LayoutParams params2;
    // RelativeLayout layoutPadre = (RelativeLayout)findViewById(R.id.layout1);

    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(30, 40);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        AbsoluteLayout.LayoutParams params = ((AbsoluteLayout.LayoutParams) imageView.getLayoutParams());
         params2 = params;
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        lastUpdate = System.currentTimeMillis();

        //params.leftMargin = 50; params.topMargin = 60;


        //RelativeLayout layout1 = (RelativeLayout) findViewById(R.id.layout1);
        //Lienzo fondo = new Lienzo(this);
        //layout1.addView(fondo);

    }


       /* imageView.getLayoutParams().height=50;
        imageView.getLayoutParams().width=50;
        imageView.requestLayout();*/


        //imageView.layout(150, 150, 400, 400);
        /* Desde: Nivel 1 del API
 Asignar un tamaño y la posición de una vista y todos sus descendientes
 Esta es la segunda fase del mecanismo de diseño.  (El primero es la medición).
 En esta fase, cada padre llama a disposición de todos sus hijos a colocarlos.
 Esto se hace normalmente usando las medidas del niño que se almacenaron en
 el pase medida ().  Las clases derivadas no deben reemplazar este método.  Derivado
 clases con los niños deben anular OnLayout.  En ese método, deben llamar
 el diseño de cada uno de sus hijos.

 Parámetros

 l posición de izquierda, en relación con los padres
 posición t superior, en relación con los padres
 r Posición derecha, en relación con los padres
 b posición inferior, en relación con los padres*/
       /* AlertDialog alerta = new AlertDialog.Builder(this).create();
        alerta.setTitle("Se presiono el Boton" + imageView.getPivotX()+ "" + imageView.getPivotY());
        alerta.setMessage("Hola mundo");
        alerta.show();*/








    public void onSensorChanged( final SensorEvent event) {



        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
       getAccelerometer(event);

        }
    }



    private void getAccelerometer(SensorEvent event) {
        float[] values = event.values;
        // Movement

        x = Math.round(values[0]) ;
        y = Math.round(values[1]) ;
        z = Math.round(values[2]) ;


       //float iniciox = x + 230;
        //float inicioy = y + 400;

        x = x + 230;
        y = y + 400;
       // params2.x = ((int)(iniciox + x * Math.pow(x,2)));
       // params2.y = (int)(inicioy + y * Math.pow(y,2));
        if( y == 400 &&  x == 230 ){

            params2.x = 230;
            params2.y = 400;

        }


        TimerTask timerTask = new TimerTask()
        {
            public void run()
            {
                if( y == 399 ){


                    params2.y -= 1;
                }





        if( x == 229 ){

                    params2.x += 1;
                }

        if( y == 401 ){
                    params2.y += 1;
                }


        if( x == 231 ){
                    params2.x -= 1;
                }





//-----------------------------------/


        if( y == 397 ){
                    params2.y -=2;
                }




        if( x == 228 ){

                    params2.x +=2;
                }


            //params2.x +=4 ;



        if( y == 402 ){

                    params2.y +=2 ;
                }

        //params2.y +=4 ;


        if( x == 233 ){
                    params2.x -=2 ;
                }

            //params2.x -=4 ;



        //-----------------------------------/

        if( y == 396 ){
                    params2.y -=4;
                }


            //params2.y -=8 ;



        if( x == 227 ){
                    params2.x +=4 ;
                }
            //params2.x +=8 ;



        if( y == 403 ){

                    params2.y +=4;
                }

            //params2.y +=8 ;


        if( x == 234 ){
                    params2.x -=4 ;
                }

            //params2.x -=8 ;


        //-----------------------------------/

        if( y == 395 ){
                    params2.y -=8 ;
                }

            //params2.y -=16 ;


        if( x == 226 ){
                    params2.x +=8 ;
                }

            //params2.x +=16 ;



        if( y == 404 ){

                    params2.y +=8 ;
                }


          //  params2.y +=16 ;


        if( x == 235 ){

                    params2.x -=8 ;
                }


           // params2.x -=16 ;


        //-----------------------------------/

        if( y == 394 ){

                    params2.y -=16 ;
                }


           // params2.y -=32 ;


        if( x == 225 ){

                    params2.x +=16 ;
                }


           // params2.x +=32 ;



        if( y == 405 ){

                    params2.y +=16 ;
                }


          //  params2.y +=32 ;


        if( x == 236 ){

                    params2.x -=16 ;
                }



        //  params2.x -=32 ;



        //-----------------------------------/

        if( y == 393 ){

                    params2.y -= 32 ;
                }



        //  params2.y -=64 ;



        if( x == 224 ){


                    params2.x +=32 ;
                }

          //  params2.x +=64 ;



        if( y == 406 ){

                    params2.y +=32 ;
                }


          //  params2.y +=64 ;

        if( x >= 237 ){

                    params2.x -=32 ;
                }

         //   params2.x -=64 ;



        //-----------------------------------/

        if( y == 392 ){


                    params2.y -=50 ;
                }


         //   params2.y -=128 ;



        if( x == 223 ){

                    params2.x +=50 ;
                }


          //  params2.x +=128 ;



        if( y == 407 ){


                    params2.y +=50 ;
                }

          //  params2.y +=128 ;


        if( x == 238 ){


                    params2.x -=50 ;
                }


        //  params2.x -=128 ;




        //-----------------------------------/

        if( y <= 391 ){


                    params2.y -=60 ;
                }


          //  params2.y -=256 ;



        if( x <= 222 ){

                        params2.x +=60 ;
                    }

         //   params2.x +=256 ;



        if( y >= 408 ){


                    params2.y +=60 ;
                }


         //   params2.y +=256 ;


        if( x >= 239 ){


                    params2.x -=60 ;
                }


         //   params2.x -=256 ;

        //--------------------------------------/

                if ( params2.x <= 0 ){
                    params2.x= 0;
                }
                if (params2.x >= 460){
                    params2.x = 460;
                }
                if(params2.y <= 0){
                    params2.y = 0;
                }

                if (params2.y >= 800 ){
                    params2.y = 800;
                }

            }

        };


// Aquí se pone en marcha el timer cada segundo.
            Timer timer = new Timer();
            // Dentro de 0 milisegundos avísame cada 1000 milisegundos


            timer.scheduleAtFixedRate(timerTask, 0, 100000);













      displayMessage("Valor de x: "+x+""+"valor de y: "+y+"valor de z: "+z+"Pablo Avila Balderas");



       /* float accelationSquareRoot = (x * x + y * y + z * z)
                / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
        long actualTime = event.timestamp;


        if (accelationSquareRoot >= 2) //
        {
            if (actualTime - lastUpdate < 200) {
                return;
            }
            lastUpdate = actualTime;
            Toast.makeText(this, "Device was shuffed", Toast.LENGTH_SHORT)
                    .show();
            if (color) {
                view.setBackgroundColor(Color.GREEN);

            } else {
                view.setBackgroundColor(Color.RED);
            }
            color = !color;
        }*/
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.valores_text_view);
        priceTextView.setText(message);
    }



    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        // register this class as a listener for the orientation and
        // accelerometer sensors
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        // unregister listener
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    class Lienzo extends View {

        public Lienzo(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            canvas.drawRGB(0, 0, 0);
            int ancho = canvas.getWidth();
            int alto = canvas.getHeight();
            Paint pincel1 = new Paint();
            pincel1.setARGB(255, 255, 255, 255);
            pincel1.setStyle(Paint.Style.STROKE);
            for (int f = 0; f < 10; f++) {
                canvas.drawCircle(ancho / 2, alto / 2, f * 15, pincel1);
                String x1 = Float.toString(x);
                String y1 = Float.toString(y);
                String z1 = Float.toString(z);
                pincel1.reset();
                canvas.drawText("Valor de x: " + x + "" + "valor de y: " + y + "valor de z: "+z+"",0,70,pincel1);


            }
        }
    }

}
