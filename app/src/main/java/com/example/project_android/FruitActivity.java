package com.example.project_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FruitActivity extends AppCompatActivity {

   /* private RecyclerView fruitList;
    RecyclerView.LayoutManager layoutManager;
    RecyclerVieoAdapter recyclerVieoAdapter;

    int []arr={R.drawable.banana,R.drawable.chart,R.drawable.cherry,R.drawable.grapefruit,R.drawable.orange,R.drawable.peach,
            R.drawable.pear,R.drawable.pineapple,R.drawable.strawberry,R.drawable.watermelon};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        ImageButton retrn= (ImageButton) findViewById(R.id.return1);

        retrn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(FruitActivity.this,CategoriesActivity.class);
                startActivity(i);
            }
        });

        fruitList=findViewById(R.id.recyclervieo);
        layoutManager=new GridLayoutManager(this,2);
        fruitList.setLayoutManager(layoutManager);
        recyclerVieoAdapter=new RecyclerVieoAdapter(arr);
        fruitList.setAdapter(recyclerVieoAdapter);
        fruitList.setHasFixedSize(true);


    }*/
}
