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

public class Tela5 extends AppCompatActivity {
    private RadioGroup rgResposta5;
    private ImageView ivBandeiras4;
    private Button btResponder5;
    private int correctAnswerId = R.id.rbCorreto5;
    private int pontuacao = 0;
    private int perguntaAtual = 0;
    private List<Tela2> perguntas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela5);
        ivBandeiras4 = findViewById(R.id.ivBandeiras4);
        rgResposta5 = findViewById(R.id.rgResposta5);
        btResponder5 = findViewById(R.id.btResponder5);
        btResponder5.setEnabled(false);
        rgResposta5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                btResponder5.setEnabled(true);

            }
        });
        pontuacao = getIntent().getIntExtra("pontuacao", 0);
        btResponder5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedOptionId = rgResposta5.getCheckedRadioButtonId();

                if (selectedOptionId == correctAnswerId) {
                    pontuacao++;
                }

                Intent it = new Intent(Tela5.this, Tela6.class);
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