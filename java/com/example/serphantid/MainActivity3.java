package com.example.serphantid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



public class MainActivity3 extends AppCompatActivity {
    float x2,x1,y1,y2;
Button b4;
Button b5;
TextView t9;

ImageView img10,img11;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        b4=findViewById(R.id.button4);
        b5=findViewById(R.id.button5);
t9=findViewById(R.id.textView9);
img10=findViewById(R.id.imageView10);
img11=findViewById(R.id.imageView11);


        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent page4=new Intent(MainActivity3.this,MainActivity2.class);

              MainActivity3.this.startActivity(page4);

            }
        });

b5.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent page6=new Intent(MainActivity3.this,MainActivity4.class);
        MainActivity3.this.startActivity(page6);
    }
});

img11.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent page101=new Intent(MainActivity3.this,MainActivity.class);

        MainActivity3.this.startActivity(page101);




    }
});

img10.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent page102=new Intent(MainActivity3.this,MainActivity2.class);

        MainActivity3.this.startActivity(page102);




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
                    Intent i=new Intent(MainActivity3.this,MainActivity2.class);
                    startActivity(i);
                }else if (x1>x2){

                    Intent i=new Intent(MainActivity3.this,MainActivity4.class);
                    startActivity(i);


                }
                break;
        }
        return false;
    }
}