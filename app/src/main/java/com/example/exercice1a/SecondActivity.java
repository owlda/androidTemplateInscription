package com.example.exercice1a;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final TextView nom = findViewById(R.id.textViewNom);
        final TextView prenom = findViewById(R.id.textViewPrenom);
        final TextView age = findViewById(R.id.textViewAge);
        final TextView sexe = findViewById(R.id.textViewSexe);

        //Reciving data
        Intent incomingData = getIntent();
        nom.setText(incomingData.getStringExtra("Nom"));
        prenom.setText(incomingData.getStringExtra("Prenom"));
        age.setText(incomingData.getStringExtra("Age"));
        sexe.setText(incomingData.getStringExtra("Sexe"));
    }
}
