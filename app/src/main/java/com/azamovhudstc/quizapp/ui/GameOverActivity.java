package com.azamovhudstc.quizapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.azamovhudstc.quizapp.R;
import com.azamovhudstc.quizapp.ui.page.LogicalReasoningActivity;
import com.azamovhudstc.quizapp.ui.page.MathQuizActivity;
import com.azamovhudstc.quizapp.ui.page.ProgrammingActivity;
import com.azamovhudstc.quizapp.ui.page.VocabularyActivity;
import com.azamovhudstc.quizapp.util.Constants;

public class GameOverActivity extends AppCompatActivity {
Button playagain, exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over_dialog);

        playagain = findViewById(R.id.playagain);
        exit = findViewById(R.id.exit);

        String subject = getIntent().getStringExtra("subject");
        playagain.setOnClickListener(v -> {
            assert subject != null;
            if(subject.equals(getString(R.string.maths))) {
                Intent intent = new Intent(GameOverActivity.this, MathQuizActivity.class);
                intent.putExtra(Constants.SUBJECT, getString(R.string.maths));
                startActivity(intent);
            } else if (subject.equals(getString(R.string.logical_reasoning))) {
                Intent intent = new Intent(GameOverActivity.this, LogicalReasoningActivity.class);
                intent.putExtra(Constants.SUBJECT, getString(R.string.logical_reasoning));
                startActivity(intent);
            } else if (subject.equals(getString(R.string.vocabulary))) {
                Intent intent = new Intent(GameOverActivity.this, VocabularyActivity.class);
                intent.putExtra(Constants.SUBJECT, getString(R.string.vocabulary));
                startActivity(intent);
            } else if (subject.equals(getString(R.string.programming))) {
                Intent intent = new Intent(GameOverActivity.this, ProgrammingActivity.class);
                intent.putExtra(Constants.SUBJECT, getString(R.string.programming));
                startActivity(intent);
            }
        });

        exit.setOnClickListener(v -> {
            Intent intent = new Intent(GameOverActivity.this, HomeActivity.class);
            startActivity(intent);
        });

    }
}
