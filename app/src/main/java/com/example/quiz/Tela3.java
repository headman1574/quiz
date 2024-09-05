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

public class Tela3 extends AppCompatActivity {
    private RadioGroup rgResposta3;
    private ImageView imageView;
    private Button btResponder3;
    private int correctAnswerId = R.id.rbCorreto3;
    private int pontuacao = 0;
    private int perguntaAtual = 0;
    private List<Tela3> perguntas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela3);
        imageView = findViewById(R.id.imageView);
        rgResposta3 = findViewById(R.id.rgResposta3);
        btResponder3 = findViewById(R.id.btResponder3);
        btResponder3.setEnabled(false);
        rgResposta3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                btResponder3.setEnabled(true);

            }
        });
        pontuacao = getIntent().getIntExtra("pontuacao", 0);
        btResponder3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedOptionId = rgResposta3.getCheckedRadioButtonId();

                if (selectedOptionId == correctAnswerId) {
                    pontuacao++;
                }

                Intent it = new Intent(Tela3.this, Tela4.class);
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