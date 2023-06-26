package com.example.serphantid;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.EventListener;


public class fragment1 extends Fragment {
    RecyclerView recyclerView;
    ArrayList<userdata> userdataArrayList;
    myadapter mYadapter;
    FirebaseFirestore db;
    ProgressDialog progressDialog;
View view;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_fragment1, container, false);


        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.show();



        recyclerView= view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        db= FirebaseFirestore.getInstance();

        userdataArrayList=new ArrayList<userdata>();

        mYadapter = new myadapter(getActivity(), userdataArrayList);

        recyclerView.setAdapter(mYadapter);

        EventChangeListener();

        return view;






    }

    private void EventChangeListener() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference serpentIdRef = db.collection("Deadly venomous");

        serpentIdRef.addSnapshotListener(new com.google.firebase.firestore.EventListener<QuerySnapshot>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onEvent(@Nullable QuerySnapshot snapshot, @Nullable FirebaseFirestoreException error) {
                if (error != null && error.getMessage() != null) {
                    // Do something with the error message
                    if (progressDialog.isShowing())
                        progressDialog.dismiss();
                    Log.e("Firestore error", error.getMessage());
                    return;
                }

                assert snapshot != null;
                for (DocumentChange dc : snapshot.getDocumentChanges()) {
                    if (dc.getType() == DocumentChange.Type.ADDED) {
                        userdataArrayList.add(dc.getDocument().toObject(userdata.class));
                    }
                }
                mYadapter.notifyDataSetChanged();
                if (progressDialog.isShowing())
                    progressDialog.dismiss();
            }
        });
    }


}