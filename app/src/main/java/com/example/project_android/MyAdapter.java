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

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Fruit> items;
    private Context context;

    public MyAdapter(List<Fruit> items, Context context) {
        this.items = items;
        this.context = context;
    }
    public MyAdapter(List<Fruit> items) {
        this.items = items;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_element, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = items.get(position);
        holder.imageView.setImageResource(fruit.getName());
        holder.textView.setText(fruit.getCategory());
        holder.textViewPrice.setText(String.valueOf(fruit.getPrice()));
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
        Fruit fruit = items.get(position);
        Intent intent = new Intent(context, PanierActivity.class);
        intent.putExtra("fruit", String.valueOf(fruit));
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