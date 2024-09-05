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

public class Tela4 extends AppCompatActivity {
    private RadioGroup rgResposta4;
    private ImageView ivBandeiras3;
    private Button btResponder4;
    private int correctAnswerId = R.id.rbCorreto4;
    private int pontuacao = 0;
    private int perguntaAtual = 0;
    private List<Tela2> perguntas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela4);
        ivBandeiras3 = findViewById(R.id.ivBandeiras3);
        rgResposta4 = findViewById(R.id.rgResposta4);
        btResponder4 = findViewById(R.id.btResponder4);
        btResponder4.setEnabled(false);
        rgResposta4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                btResponder4.setEnabled(true);

            }
        });
        pontuacao = getIntent().getIntExtra("pontuacao", 0);
        btResponder4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedOptionId = rgResposta4.getCheckedRadioButtonId();

                if (selectedOptionId == correctAnswerId) {
                    pontuacao++;
                }

                Intent it = new Intent(Tela4.this, Tela5.class);
                it.putExtra("pontuacao", pontuacao);
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