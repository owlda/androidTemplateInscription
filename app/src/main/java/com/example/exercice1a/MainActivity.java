package com.example.exercice1a;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String selectSpinner = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialisation
        final EditText nom = findViewById(R.id.editTextNom);
        final EditText prenom = findViewById(R.id.editTextPrenom);
        final EditText age = findViewById(R.id.editTextAge);
        final Spinner sexe = findViewById(R.id.spinnerSexe);
        final Button send = findViewById(R.id.buttonAcrive);

        // Initialisation of the spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sexe_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sexe.setAdapter(adapter);
        sexe.setOnItemSelectedListener(this);


        send.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"WrongViewCast", "SetTextI18n"})
            @Override
            public void onClick(View view) {
                String _nom = String.valueOf(nom.getText());
                String _prenom = String.valueOf(prenom.getText());
                String _age = String.valueOf(age.getText());
                String _sexe = selectSpinner;
                Intent transferInscription = new Intent(MainActivity.this, SecondActivity.class);
                // Adding the data to transfer
                transferInscription.putExtra("Nom", _nom);
                transferInscription.putExtra("Prenom", _prenom);
                transferInscription.putExtra("Age", _age);
                transferInscription.putExtra("Sexe", _sexe);
                startActivity(transferInscription);
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

          selectSpinner = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
