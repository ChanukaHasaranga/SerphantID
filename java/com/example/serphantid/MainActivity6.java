package com.example.serphantid;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MainActivity6 extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<userdata> userdataArrayList;
    myadapter mYadapter;
    FirebaseFirestore db;
    ProgressDialog progressDialog;
Button firstfragment1,secondfragment2,home,btn18;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

firstfragment1=findViewById(R.id.button15);
secondfragment2=findViewById(R.id.button16);
home=findViewById(R.id.button20);
btn18=findViewById(R.id.button18);
firstfragment1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        firstfragment1.setBackground(getDrawable(R.drawable.buttonclick));
        firstfragment1.setTextColor(Color.WHITE);
        secondfragment2.setBackground(getDrawable(R.drawable.scroll));
        secondfragment2.setTextColor(Color.rgb(80,101,25));
        replaceFragment(new fragment1());
        
        
    }
});
secondfragment2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        secondfragment2.setBackground(getDrawable(R.drawable.buttonclick));
        secondfragment2.setTextColor(Color.WHITE);

        firstfragment1.setBackground(getDrawable(R.drawable.scroll));
        firstfragment1.setTextColor(Color.rgb(80,101,25));
        replaceFragment(new fragment2());
        
        
    }
});
home.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent home=new Intent(MainActivity6.this,MainActivity6.class);
        MainActivity6.this.startActivity(home);


    }
});
        btn18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent back=new Intent(MainActivity6.this,MainActivity5.class);
                MainActivity6.this.startActivity(back);


            }
        });


        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();



        recyclerView=findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        db=FirebaseFirestore.getInstance();

        userdataArrayList=new ArrayList<userdata>();

        mYadapter=new myadapter(MainActivity6.this,userdataArrayList);

        recyclerView.setAdapter(mYadapter);

        EventChangeListener();


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

    private void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout,fragment);
fragmentTransaction.commit();


    }


}