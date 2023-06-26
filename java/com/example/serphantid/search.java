package com.example.serphantid;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.core.UserData;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class search extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<userdata> userdataArrayList;
    myadapter mYadapter;
    FirebaseFirestore db;
    ProgressDialog progressDialog;
    SearchView searchView;
Button home40;
Button back29;
Button btn43;
Button cmr;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
home40=findViewById(R.id.button40);
        back29=findViewById(R.id.button29);
        btn43=findViewById(R.id.button43);
        cmr=findViewById(R.id.button42);

        searchView=findViewById(R.id.searchView);
        searchView.clearFocus();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;


            }

            @Override
            public boolean onQueryTextChange(String newText) {
                fileList(newText);



                return true;
            }
        });
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();


        recyclerView = findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        db = FirebaseFirestore.getInstance();

        userdataArrayList = new ArrayList<userdata>();

        mYadapter = new myadapter(search.this, userdataArrayList);

        recyclerView.setAdapter(mYadapter);

        EventChangeListener();
    }

    private void fileList(String text) {

        ArrayList<userdata> filteredList=new ArrayList<>();



        for (userdata userdata : userdataArrayList) {


            if (userdata.getFirstname().toLowerCase().contains(text.toLowerCase())){

filteredList.add(userdata);

            }

        }

if (filteredList.isEmpty()){

    Toast.makeText(this,"No Data Found",Toast.LENGTH_SHORT).show();


}else {

mYadapter.setfilteredList(filteredList);
}


    }

    private void EventChangeListener () {

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

                            for (DocumentChange dc : value.getDocumentChanges()) {

                                if (dc.getType() == DocumentChange.Type.ADDED) {

                                    userdataArrayList.add(dc.getDocument().toObject(userdata.class));


                                }

                                mYadapter.notifyDataSetChanged();
                                if (progressDialog.isShowing())
                                    progressDialog.dismiss();
                            }

                        }
                    });


        home40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent14=new Intent(search.this,MainActivity4.class);
                search.this.startActivity(intent14);

            }
        });
        back29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent15=new Intent(search.this,MainActivity4.class);
                search.this.startActivity(intent15);

            }
        });
        btn43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent16=new Intent(search.this,MainActivity5.class);
                search.this.startActivity(intent16);

            }
        });
        cmr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent17=new Intent(search.this,camera.class);
                search.this.startActivity(intent17);

            }
        });


        }
    }
