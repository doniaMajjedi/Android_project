package com.example.project_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class FruitActivity extends AppCompatActivity {

    //table for images
    int []arr1={R.drawable.banana,R.drawable.chart,R.drawable.cherry,R.drawable.grapefruit,R.drawable.orange,R.drawable.peach,
            R.drawable.pear,R.drawable.pineapple,R.drawable.strawberry, R.drawable.watermelon};
    //table for the fruits names
    String []arr2={"Banana","Chart","Cherry","Grapefruit","Orange","Peach",
            "Pear","Pineapple","Strawberry","Watermelon"};
    //table for prices
    double []arr3={12.0,4.5,5.0,7.5,3.8,6.5,8.0,2.5,5.5,1.5};
    private RecyclerView recyclerView;
    private List<Fruit> items;
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        //recyclervieo
        recyclerView = findViewById(R.id.recyclerView);
        //table for all(image,name,price)
        items = new ArrayList<>();
        for(int i=0;i<10;i++){
            items.add(new Fruit(arr1[i], arr2[i], arr3[i]));
        }
        //create adapter
        adapter = new MyAdapter(items);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);


        //ActionBar pour le logo, retour et panier
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.action_bar);
        // Get references to the back and cart buttons
        ImageButton backButton = findViewById(R.id.actionbar_back);
        ImageButton cartButton = findViewById(R.id.actionbar_cart);
        // Set listeners for the back and cart buttons
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle back button click here
                Intent intent = new Intent(FruitActivity.this,CategoriesActivity.class);
                startActivity(intent);
            }
        });
        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FruitActivity.this,PanierActivity.class);
                startActivity(intent);
            }
        });

    }}
