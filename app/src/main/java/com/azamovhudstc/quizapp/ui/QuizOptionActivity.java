package com.azamovhudstc.quizapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.azamovhudstc.quizapp.R;
import com.azamovhudstc.quizapp.ui.page.GeographyOrLiteratureQuizActivity;
import com.azamovhudstc.quizapp.ui.page.MathQuizActivity;
import com.azamovhudstc.quizapp.ui.page.VocabularyActivity;
import com.azamovhudstc.quizapp.util.Constants;

public class QuizOptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_option);
        CardView cvMath = findViewById(R.id.cvMath);
        findViewById(R.id.imageViewQuizOption).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        cvMath.setOnClickListener(view -> {
            mathClick();
        });
        CardView Vocabulary = findViewById(R.id.Vocabulary);
        Vocabulary.setOnClickListener(view -> {
            VocabularyClick();
        });
        CardView cvLiterature = findViewById(R.id.cvLiterature);
        cvLiterature.setOnClickListener(view -> {
            literatureClick();
        });
    }

    public void mathClick() {
        Intent intent = new Intent(QuizOptionActivity.this, MathQuizActivity.class);
        intent.putExtra(Constants.SUBJECT, getString(R.string.geography));
        startActivity(intent);

    }

    public void VocabularyClick() {
        Intent intent = new Intent(QuizOptionActivity.this, VocabularyActivity.class);
        intent.putExtra(Constants.SUBJECT, getString(R.string.vocabulary));
        startActivity(intent);
    }

    public void literatureClick() {
        Intent intent = new Intent(QuizOptionActivity.this, GeographyOrLiteratureQuizActivity.class);
        intent.putExtra(Constants.SUBJECT, getString(R.string.literature));
        startActivity(intent);
    }
}