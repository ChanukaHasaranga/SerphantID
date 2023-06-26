package com.example.serphantid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity8 extends AppCompatActivity {

    TextView name2,onename2,toxic2,habitat2,idn2;
    ImageView profilepic2;
Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
back=findViewById(R.id.button19);

name2=findViewById(R.id.name);
onename2=findViewById(R.id.onesname);
        toxic2=findViewById(R.id.toxic);
        habitat2=findViewById(R.id.habitat);
        idn2=findViewById(R.id.idn);
        profilepic2=findViewById(R.id.profilepic);

        Picasso.get().load( getIntent().getStringExtra("profilepic"))

                .placeholder(R.drawable.snakebackground)
                .into(profilepic2);


        name2.setText(getIntent().getStringExtra("name"));
        onename2.setText(getIntent().getStringExtra("onesname"));
        toxic2.setText(getIntent().getStringExtra("toxic"));
        habitat2.setText(getIntent().getStringExtra("habitat"));
        idn2.setText(getIntent().getStringExtra("idn"));

back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent back1=new Intent(MainActivity8.this,Context.class);
        MainActivity8.this.startActivity(back1);


    }
});

    }
}