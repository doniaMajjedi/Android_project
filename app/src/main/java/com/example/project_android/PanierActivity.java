package com.example.project_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PanierActivity extends AppCompatActivity {
    private ShoppingCart shoppingCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panier);

        // Récupérez les informations du fruit à partir de l'intention
        Intent intent = getIntent();
        Fruit fruit = (Fruit) intent.getSerializableExtra("fruit");

        // Ajoutez le fruit à la liste du panier
        shoppingCart = new ShoppingCart(new ArrayList<>());
        shoppingCart.addItem(fruit);

        // Calculez le total des prix
        double totalPrice = shoppingCart.getTotalPrice();

        TextView textView = findViewById(R.id.somme);
        TextView commande = findViewById(R.id.textpanier);
        textView.setText("Somme: " + totalPrice);
        commande.setText("*Name: " + fruit.getCategory() + " - " + fruit.getPrice());

        // ActionBar pour le logo et retour
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.action_bar);
        ImageButton backButton = findViewById(R.id.actionbar_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PanierActivity.this, FruitActivity.class);
                startActivity(intent);
            }
        });
    }
}