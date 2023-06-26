package com.example.serphantid;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;


public class MainActivity4 extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<userdata> userdataArrayList;
    myadapter mYadapter;
    FirebaseFirestore db;
    ProgressDialog progressDialog;
    Button btn17;
    ImageView img13;
    ImageView img15;
    ImageView img14;
    Button btn10,btn9,btn8,btn11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();



        recyclerView=findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        db=FirebaseFirestore.getInstance();

        userdataArrayList=new ArrayList<userdata>();

        mYadapter=new myadapter(MainActivity4.this,userdataArrayList);

        recyclerView.setAdapter(mYadapter);

        EventChangeListener();



        btn17=findViewById(R.id.button17);
        btn17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1=new Intent(MainActivity4.this,MainActivity5.class);
                MainActivity4.this.startActivity(intent1);






            }
        });

        btn8=findViewById(R.id.button8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent search=new Intent(MainActivity4.this,search.class);
                MainActivity4.this.startActivity(search);


            }
        });
        btn11=findViewById(R.id.button11);
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent search=new Intent(MainActivity4.this,search.class);
                MainActivity4.this.startActivity(search);


            }
        });

img13=findViewById(R.id.imageView13);
img13.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent intent13=new Intent(MainActivity4.this,MainActivity11.class);
        MainActivity4.this.startActivity(intent13);





    }
});

img15=findViewById(R.id.imageView15);
img15.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent15=new Intent(MainActivity4.this,MainActivity12.class);
        MainActivity4.this.startActivity(intent15);




    }
});
img14=findViewById(R.id.imageView14);
        img14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent13=new Intent(MainActivity4.this,MainActivity13.class);
                MainActivity4.this.startActivity(intent13);




            }
        });



        btn10=findViewById(R.id.button10);
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent10=new Intent(MainActivity4.this,imageupload.class);
                MainActivity4.this.startActivity(intent10);




            }
        });

        btn9=findViewById(R.id.button9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent9=new Intent(MainActivity4.this,camera.class);
                MainActivity4.this.startActivity(intent9);



            }
        });


    }

    private void EventChangeListener() {

        db.collection("SerphantID")


                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {






                        if (error != null && error.getMessage() != null) {
                            // Do something with the error message
                            if (progressDialog.isShowing())
                                progressDialog.dismiss();
                            Log.e("Firestore error", error.getMessage());

                            return;

                        }

                        for (DocumentChange dc: value.getDocumentChanges()){

                            if (dc.getType()==DocumentChange.Type.ADDED){

                                userdataArrayList.add(dc.getDocument().toObject(userdata.class));



                            }

                            mYadapter.notifyDataSetChanged();
                            if (progressDialog.isShowing())
                                progressDialog.dismiss();
                        }

                    }
                });



    }
}