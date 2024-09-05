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

public class Tela8 extends AppCompatActivity {
    private RadioGroup rgResposta8;
    private ImageView ivBandeiras7;
    private Button btResponder8;
    private int correctAnswerId = R.id.rbCorreto8;
    private int pontuacao = 0;
    private int perguntaAtual = 0;
    private List<Tela2> perguntas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela8);
        ivBandeiras7 = findViewById(R.id.ivBandeiras7);
        rgResposta8 = findViewById(R.id.rgResposta8);
        btResponder8 = findViewById(R.id.btResponder8);
        btResponder8.setEnabled(false);
        rgResposta8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                btResponder8.setEnabled(true);

            }
        });
        pontuacao = getIntent().getIntExtra("pontuacao", 0);
        btResponder8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedOptionId = rgResposta8.getCheckedRadioButtonId();

                if (selectedOptionId == correctAnswerId) {
                    pontuacao++;
                }

                Intent it = new Intent(Tela8.this, Tela9.class);
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