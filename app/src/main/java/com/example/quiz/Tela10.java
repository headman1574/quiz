package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class Tela10 extends AppCompatActivity {
    private RadioGroup rgResposta10;
    private ImageView ivBandeiras9;
    private Button btResponder10;
    private int correctAnswerId = R.id.rbCorreto10;
    private int pontuacao = 0;
    private int perguntaAtual = 0;
    private List<Tela2> perguntas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela10);
        ivBandeiras9 = findViewById(R.id.ivBandeiras9);
        rgResposta10 = findViewById(R.id.rgResposta10);
        btResponder10 = findViewById(R.id.btResponder10);
        btResponder10.setEnabled(false);
        rgResposta10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                btResponder10.setEnabled(true);

            }
        });
        pontuacao = getIntent().getIntExtra("pontuacao", 0);
        btResponder10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedOptionId = rgResposta10.getCheckedRadioButtonId();

                if (selectedOptionId == correctAnswerId) {
                    pontuacao++;
                }

                Intent it = new Intent(Tela10.this, Pontos.class);
                it.putExtra("finalScore", pontuacao);
                startActivity(it);
                finish();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}