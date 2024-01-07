package com.example.project_android;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_android.Fruit;
import com.example.project_android.PanierActivity;
import com.example.project_android.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapterVeg extends RecyclerView.Adapter<MyAdapterVeg.ViewHolder> {
    private List<Veg> items;
    private Context context;

    public MyAdapterVeg(List<Veg> items, Context context) {
        this.items = items;
        this.context = context;
    }
    public MyAdapterVeg(List<Veg> items) {
        this.items = items;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_element, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Veg veg = items.get(position);
        holder.imageView.setImageResource(veg.getName());
        holder.textView.setText(veg.getCategory());
        holder.textViewPrice.setText(String.valueOf(veg.getPrice()));
        holder.bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onProductSelected(holder.getAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private void onProductSelected(int position) {
        Veg veg = items.get(position);
        Intent intent = new Intent(context, PanierActivity.class);
        intent.putExtra("veg", String.valueOf(veg));
        context.startActivity(intent);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imageView;
        public TextView textView;
        public TextView textViewPrice;
        public Button bouton;

        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.imageView);
            textView = view.findViewById(R.id.textViewName);
            textViewPrice = view.findViewById(R.id.textViewPrice);
            bouton = view.findViewById(R.id.buttonCommand);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.buttonCommand) {
                onProductSelected(getAdapterPosition());
            }
        }
    }
}