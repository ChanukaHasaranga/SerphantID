package com.example.serphantid;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MainActivity10 extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<userdata> userdataArrayList;
myadapter mYadapter;
FirebaseFirestore db;
ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();



recyclerView=findViewById(R.id.recycleview);
recyclerView.setHasFixedSize(true);
recyclerView.setLayoutManager(new LinearLayoutManager(this));


db=FirebaseFirestore.getInstance();

userdataArrayList=new ArrayList<userdata>();

mYadapter=new myadapter(MainActivity10.this,userdataArrayList);

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
}