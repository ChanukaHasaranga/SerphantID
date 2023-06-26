package com.example.serphantid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity5 extends AppCompatActivity {
    Button b22;
    ImageView venom;
    Button back14;
    Button back24;
    Button seah;
    Button cam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        b22 = findViewById(R.id.button14);
        venom = findViewById(R.id.imageView24);
back14=findViewById(R.id.button14);
back24=findViewById(R.id.button24);
seah=findViewById(R.id.button25);
cam=findViewById(R.id.button26);

        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent page7 = new Intent(MainActivity5.this, MainActivity6.class);
                MainActivity5.this.startActivity(page7);

            }
        });

        venom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent venom1=new Intent(MainActivity5.this,MainActivity6.class);
                MainActivity5.this.startActivity(venom1);



            }
        });

        back14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent14=new Intent(MainActivity5.this,MainActivity4.class);
                MainActivity5.this.startActivity(intent14);

            }
        });

        back24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent15=new Intent(MainActivity5.this,MainActivity4.class);
                MainActivity5.this.startActivity(intent15);

            }
        });


        seah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent16=new Intent(MainActivity5.this,search.class);
                MainActivity5.this.startActivity(intent16);

            }
        });

        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent17=new Intent(MainActivity5.this,camera.class);
                MainActivity5.this.startActivity(intent17);

            }
        });

    }
}