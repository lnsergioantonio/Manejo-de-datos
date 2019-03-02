package com.example.sergio.manejodatos;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPreferencesActivity extends AppCompatActivity {
    TextView textView;
    Button buttonSave, buttonDelete;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        textView = findViewById(R.id.sharedActivity_textview);
        buttonSave = findViewById(R.id.sharedActivity_button_save);
        editText = findViewById(R.id.sharedActivity_input);

        SharedPreferences preferences = getSharedPreferences("preferences",MODE_PRIVATE);
        editText.setText(preferences.getString("dato","empty"));
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dato = editText.getText().toString();
                // mode preferences siempre debe ser privado
                SharedPreferences preferences = getSharedPreferences("preferences",MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("dato",dato);
                editor.apply();
                //finish();
            }
        });
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dato = editText.getText().toString();
                // mode preferences siempre debe ser privado
                SharedPreferences preferences = getSharedPreferences("preferences",MODE_PRIVATE);
                preferences.edit().remove("dato").apply();
            }
        });
    }
}
