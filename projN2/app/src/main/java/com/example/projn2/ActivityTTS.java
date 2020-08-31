package com.example.projn2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class ActivityTTS extends AppCompatActivity {
    Button btnOuvir, btnMenu;
    EditText edtTTS;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_t_s);

        getSupportActionBar().hide();

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i != TextToSpeech.ERROR){
                    tts.setLanguage(Locale.getDefault());
                }
            }
        });
        edtTTS = findViewById(R.id.edtTTS);

        btnOuvir = findViewById(R.id.btnOuvir);

        btnMenu = findViewById(R.id.btnMenu);

        btnOuvir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                narrar(edtTTS.getText().toString());
            }
        });
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    private void narrar(String texto) {
        tts.speak(texto, TextToSpeech.QUEUE_FLUSH, null);
    }
}