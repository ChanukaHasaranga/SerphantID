package com.example.serphantid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {
float y1,y2,x1,x2;
    Button b2,b3;
ImageView img7,img8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


b2=findViewById(R.id.button);
b3=findViewById(R.id.button3);
img7=findViewById(R.id.imageView7);
img8=findViewById(R.id.imageView8);

 b3.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {


         Intent page2=new Intent(MainActivity2.this,MainActivity.class);
         MainActivity2.this.startActivity(page2);



     }
 });

b2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent page5=new Intent(MainActivity2.this,MainActivity3.class);

        MainActivity2.this.startActivity(page5);



    }
});


img7.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent page99=new Intent(MainActivity2.this,MainActivity.class);

        MainActivity2.this.startActivity(page99);




    }
});

img8.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {


        Intent page100=new Intent(MainActivity2.this,MainActivity3.class);

        MainActivity2.this.startActivity(page100);



    }
});


    }


    public boolean onTouchEvent(MotionEvent touchEvent) {
        switch (touchEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if (x1 < x2) {
                    Intent i=new Intent(MainActivity2.this,MainActivity.class);
                    startActivity(i);
                } else if (x1 > x2) {
                    Intent i = new Intent(MainActivity2.this, MainActivity3.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }




}