package com.example.projn2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnSTT, btnTTS, btnFone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verificarPermissoes();

        getSupportActionBar().hide();

        btnTTS = findViewById(R.id.btnTTS);

        btnSTT = findViewById(R.id.btnSTT);

        btnFone = findViewById(R.id.btnFone);


        btnTTS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToTTS();
            }
        });

        btnSTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSTT();
            }
        });

        btnFone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    private void goToTTS() {
        Intent janela = new Intent(this, ActivityTTS.class);
        startActivity(janela);
    }
    private void goToSTT() {
        Intent janela = new Intent(this, ActivitySTT.class);
        startActivity(janela);
    }

    private void verificarPermissoes() {
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this,
                    new String[]{
                            Manifest.permission.RECORD_AUDIO
                    }, 1);
        }
    }

}