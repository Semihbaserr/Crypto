package com.semihbaser.crypto;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.semihbaser.crypto.databinding.RecyclerRowBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BelongingsAdapter extends RecyclerView.Adapter<BelongingsHolder> {

    private ArrayList<Belongings> belongingsArrayList;
    Activity activity;
    Context context;


    public BelongingsAdapter(ArrayList<Belongings> belongingsArrayList, Activity activity) {
        this.belongingsArrayList = belongingsArrayList;
        this.activity = activity;
        this.context = activity.getApplicationContext();

    }

    @NonNull

    @Override
    public BelongingsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new BelongingsHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BelongingsHolder holder, int position) {


        holder.binding.recyclerViewNameText.setText(belongingsArrayList.get(position).name);
        holder.binding.recyclerViewEmailText.setText("Uploaded By: " + belongingsArrayList.get(position).email);
        holder.binding.recyclerViewPriceText.setText(belongingsArrayList.get(position).price);
        Picasso.get().load(belongingsArrayList.get(position).downloadUrl).into(holder.binding.imageView);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Intent intent = new Intent(activity, SomeActivity.class);
                intent.putExtra("name", belongingsArrayList.get(position));
                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return belongingsArrayList.size();
    }


}