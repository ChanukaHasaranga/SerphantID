package com.example.serphantid;
import com.example.serphantid.userdata;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder> {

    public void setfilteredList(ArrayList<userdata> filteredList){

        this.userdataArrayList=filteredList;
        notifyDataSetChanged();



    }

Context context;
ArrayList<userdata> userdataArrayList;

    public myadapter(Context context, ArrayList<userdata> userdataArrayList) {
        this.context = context;
        this.userdataArrayList = userdataArrayList;
    }

    @NonNull
    @Override
    public myadapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View v= LayoutInflater.from(context).inflate(R.layout.activity_main9,parent,false);


        return new myviewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

        userdata user=userdataArrayList.get(position);

holder.firstname.setText(user.Firstname);
holder.sname.setText(user.Sname);
holder.bname.setText(user.Uname);
holder.lenth.setText(user.Lenth);
holder.born.setText(user.Born);

Picasso.get().load(user.Mimage).placeholder(R.drawable.ooooo88).into(holder.mainimage);
        Picasso.get().load(user.Limage).placeholder(R.drawable.poisen).into(holder.lastimage);



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent single=new Intent(context,MainActivity8.class);
                single.putExtra("name",user.Firstname);
                single.putExtra("onesname",user.Sname);
                single.putExtra("toxic",user.Toxic);
                single.putExtra("habitat",user.Habitat);
                single.putExtra("idn",user.Idn);
                single.putExtra("profilepic",user.Profilepic);
single.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
context.startActivity(single);




            }
        });




    }

    @Override
    public int getItemCount() {
        return userdataArrayList.size();
    }

 public static class myviewholder extends RecyclerView.ViewHolder{

TextView firstname,sname,bname,lenth,born;
ImageView mainimage,lastimage;





     public myviewholder(@NonNull View itemView) {
         super(itemView);

firstname=itemView.findViewById(R.id.fname);
sname=itemView.findViewById(R.id.sname);
bname=itemView.findViewById(R.id.bname);
lenth=itemView.findViewById(R.id.lenth);
born=itemView.findViewById(R.id.born);
mainimage=itemView.findViewById(R.id.bimg);
lastimage=itemView.findViewById(R.id.limg);



     }
 }




}
