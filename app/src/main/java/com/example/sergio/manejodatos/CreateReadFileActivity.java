package com.example.sergio.manejodatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class CreateReadFileActivity extends AppCompatActivity {

    Button buttonCreate, buttonRead;
    TextView textView;
    EditText input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_read_file);

        buttonCreate= findViewById(R.id.crfactiviy_button_create);
        buttonRead= findViewById(R.id.crfactiviy_button_read);
        textView= findViewById(R.id.crfactiviy_text);
        input = findViewById(R.id.crfactiviy_input);

        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = input.getText().toString();

                try {
                    FileOutputStream fos =  openFileOutput("archivo.txt",MODE_PRIVATE);
                    fos.write(text.getBytes());
                    fos.close();
                    textView.setText("se ha creado el archivo");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fis = openFileInput("archivo.txt");
                    BufferedInputStream bis= new BufferedInputStream(fis);
                    StringBuffer sf = new StringBuffer();

                    while(bis.available()!=0){
                        char mander= (char) bis.read();
                        sf.append(mander);
                    }

                    textView.setText(sf.toString());
                    bis.close();
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        File file = getFilesDir();
        String path = file.getAbsolutePath();
        textView.setText(path);
    }
}
