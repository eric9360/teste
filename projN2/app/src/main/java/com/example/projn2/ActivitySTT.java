package com.example.projn2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Locale;

public class ActivitySTT extends AppCompatActivity {
    Button btnFalar, btnMenu2;
    EditText edtSTT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_t_t);

        getSupportActionBar().hide();

        btnFalar = findViewById(R.id.btnFalar);

        btnMenu2 = findViewById(R.id.btnMenu2);

        edtSTT = findViewById(R.id.edtSTT);

        edtSTT.setMovementMethod(new ScrollingMovementMethod());

        btnFalar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                falar();
            }
        });

        btnMenu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void falar(){
        Intent iSTT = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        iSTT.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        iSTT.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        iSTT.putExtra(RecognizerIntent.EXTRA_PROMPT, "Diga algo");
        startActivityForResult(iSTT, 100);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == RESULT_OK && data != null) {
                ArrayList<String> resultado =
                        data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                String textoReconhecido = resultado.get(0);

                edtSTT.setText(textoReconhecido);

                if(textoReconhecido.toUpperCase().contains("FECHAR A APLICAÇÃO")
                        ||textoReconhecido.toUpperCase().contains("FECHAR APLICAÇÃO") || textoReconhecido.toUpperCase().contains("BUGOU") || textoReconhecido.toUpperCase().contains("LIXO")){
                    finishAffinity();
                }
            }
        }
    }
}