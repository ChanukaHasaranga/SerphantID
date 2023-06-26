package com.example.serphantid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
float x2,x1,y1,y2;
    Button b1;
    ImageView im1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


b1=findViewById(R.id.button2);
im1=findViewById(R.id.imageView3);

b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent page1=new Intent(MainActivity.this,MainActivity2.class);
        MainActivity.this.startActivity(page1);



    }
});

im1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent page12=new Intent(MainActivity.this,MainActivity2.class);
        MainActivity.this.startActivity(page12);


    }
});

    }

    public boolean onTouchEvent(MotionEvent touchEvent){
        switch(touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if(x1<x2){

                }else if(x1> x2){
                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }



}