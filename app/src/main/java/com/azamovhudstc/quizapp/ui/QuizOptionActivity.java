package com.azamovhudstc.quizapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import com.azamovhudstc.quizapp.R;
import com.azamovhudstc.quizapp.ui.page.GeographyOrLiteratureQuizActivity;
import com.azamovhudstc.quizapp.ui.page.LogicalReasoningActivity;
import com.azamovhudstc.quizapp.ui.page.MathQuizActivity;
import com.azamovhudstc.quizapp.ui.page.ProgrammingActivity;
import com.azamovhudstc.quizapp.ui.page.VocabularyActivity;
import com.azamovhudstc.quizapp.util.Constants;

public class QuizOptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_option);

        findViewById(R.id.imageViewQuizOption).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        findViewById(R.id.Math).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mathClick();
            }
        });


        findViewById(R.id.Vocabulary).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VocabularyClick();
            }
        });

        findViewById(R.id.LogicalReasoning).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogicalReasoningClick();
            }
        });

        findViewById(R.id.ProgrammingConcepts).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgramingConceptsClick();
            }
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

    public void LogicalReasoningClick() {
        Intent intent = new Intent(QuizOptionActivity.this, LogicalReasoningActivity.class);
        intent.putExtra(Constants.SUBJECT, getString(R.string.logical_reasoning));
        startActivity(intent);
    }

    public void ProgramingConceptsClick(){
        Intent intent = new Intent(QuizOptionActivity.this, ProgrammingActivity.class);
        intent.putExtra(Constants.SUBJECT, getString(R.string.programming));
        startActivity(intent);

    }
}