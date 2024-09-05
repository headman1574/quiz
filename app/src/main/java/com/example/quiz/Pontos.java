package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Pontos extends AppCompatActivity {

    private TextView txtNome2, txtPontuacao;
    private EditText editTextText;
    private Button btnResponderNovamente, btnTelaInicial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontos);  // Define o layout da atividade como o XML fornecido

        // Referências aos elementos da interface
        txtNome2 = findViewById(R.id.txtNome2);
        txtPontuacao = findViewById(R.id.txtPontuacao);
        editTextText = findViewById(R.id.editTextText);
        btnResponderNovamente = findViewById(R.id.btnResponderNovamente);
        btnTelaInicial = findViewById(R.id.btnTelaInicial);

        // Recebe os dados da tela anterior
        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        int finalScore = intent.getIntExtra("finalScore",0);

        // Log para verificar os valores recebidos
        Log.d("PontosActivity", "Nome: " + userName);
        Log.d("PontosActivity", "Pontuação: " + finalScore);

        // Define os valores recebidos nos TextViews
        if (userName != null) {
            txtNome2.setText("Nome: " + userName);
        }
        txtPontuacao.setText(String.valueOf(finalScore));
        editTextText.setText("Sua pontuação foi: " + finalScore);

        // Listener para o botão "Responder Novamente"
        btnResponderNovamente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Volta para a primeira tela do quiz (supondo que seja Tela1)
                Intent retryIntent = new Intent(Pontos.this, Tela2.class);
                retryIntent.putExtra("userName", userName);  // Passa o nome do usuário novamente
                startActivity(retryIntent);
                finish();
            }
        });

        // Listener para o botão "Tela Inicial"
        btnTelaInicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Volta para a tela inicial (MainActivity)
                Intent mainMenuIntent = new Intent(Pontos.this, MainActivity.class);
                startActivity(mainMenuIntent);
                finish();
            }
        });
    }
}
