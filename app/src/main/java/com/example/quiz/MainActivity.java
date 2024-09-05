package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText edtNomeAluno;
    private Button btIniciarQuiz;
    private Button btSair;
    private TextView txtNome;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        edtNomeAluno = findViewById(R.id.edtNomealuno);
        btIniciarQuiz = findViewById(R.id.btIniciarQuiz);
        txtNome = findViewById(R.id.txtNome);
        btSair = findViewById(R.id.btSair);
        btIniciarQuiz.setEnabled(false);

        edtNomeAluno.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                txtNome.setText(s.toString());
                btIniciarQuiz.setEnabled(!s.toString().trim().isEmpty());

            }

            @Override
            public void afterTextChanged(Editable s) {
                btIniciarQuiz.setEnabled(!s.toString().isEmpty());

            }
        });

        btIniciarQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tela = new Intent(MainActivity.this, Tela2.class);
                startActivity(tela);
            }
        });

        btSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish();

            }
        });

    }


}