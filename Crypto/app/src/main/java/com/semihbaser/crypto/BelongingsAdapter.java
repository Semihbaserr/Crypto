package com.semihbaser.crypto;

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

public class BelongingsAdapter extends RecyclerView.Adapter<BelongingsAdapter.BelongingsHolder> {

    private ArrayList<Belongings> belongingsArrayList;
    Context context;



    public BelongingsAdapter(ArrayList<Belongings> belongingsArrayList, Context context) {
        this.belongingsArrayList = belongingsArrayList;
        this.context=context;

    }

    @NonNull

    @Override
    public BelongingsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new BelongingsHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BelongingsAdapter.BelongingsHolder holder,int position) {


        holder.binding.recyclerViewNameText.setText(belongingsArrayList.get(position).name);
        holder.binding.recyclerViewEmailText.setText("Uploaded By: " + belongingsArrayList.get(position).email);
        holder.binding.recyclerViewPriceText.setText(belongingsArrayList.get(position).price);
        holder.binding.infoText.setText("Info: "+belongingsArrayList.get(position).info);
        Picasso.get().load(belongingsArrayList.get(position).downloadUrl).into(holder.binding.imageView);



    }

    @Override
    public int getItemCount() {
        return belongingsArrayList.size();
    }

    public class BelongingsHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {


        private RecyclerRowBinding binding;


        public BelongingsHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            binding.getRoot().setOnClickListener(this);


        }

        public void onClick(View v){
            int position =getAdapterPosition();
            Toast.makeText(context,"position : "+position,Toast.LENGTH_LONG).show();
            Intent intent =new Intent(context,SomeActivity.class);
            intent.putExtra("name",belongingsArrayList.get(position).info);
            context.startActivity(intent);
        }



    }


}