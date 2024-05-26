package com.azamovhudstc.quizapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.azamovhudstc.quizapp.R;
import com.azamovhudstc.quizapp.local_data.QuizPref;

public class HomeActivity extends AppCompatActivity {
    TextView userNameHome;
    CardView cvStartQuiz, cvRule, cvHistory, cvLogout, cvAbout;
    QuizPref quizPref;
    ImageButton logout;



    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();

        
        userNameHome.setText("Hello " + quizPref.getName());
        cvHistory.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, HistoryActivity.class));
        });
        cvAbout.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, AboutActivity.class));
        });
        cvStartQuiz.setOnClickListener(view -> {
            startActivity(new Intent(HomeActivity.this, QuizOptionActivity.class));

        });
        cvLogout.setOnClickListener(v -> {
            Dialog dialog = new Dialog(this);
            View view =LayoutInflater.from(this).inflate(R.layout.activty_exit,findViewById(R.id.container),false);
            dialog.setContentView(view);
            view.findViewById(R.id.button_exit_no).setOnClickListener(view1->{
                dialog.cancel();
                dialog.dismiss();
            });
            view.findViewById(R.id.button_exit_yes).setOnClickListener(view2->{
                finish();
            });
            dialog.show();

            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        });
        cvRule.setOnClickListener(view -> {
            startActivity(new Intent(HomeActivity.this, RulesActivity.class));

        });
        logout.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
            builder.setTitle("Logout");
            builder.setMessage("Are you sure you want to logout?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    quizPref.clearName();
                    startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                    finish();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            builder.show();
        });
    }

    public void initView() {
        cvStartQuiz = findViewById(R.id.cvStartQuiz);
        cvRule = findViewById(R.id.cvRule);
        cvAbout = findViewById(R.id.cvEditPassword);
        cvHistory = findViewById(R.id.cvHistory);
        cvLogout = findViewById(R.id.cvLogout);
        userNameHome = (TextView) findViewById(R.id.tvUsernameHome);
        quizPref = QuizPref.getInstance();
        logout = findViewById(R.id.logout);
    }

    @Override
    public void onBackPressed() {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory(Intent.CATEGORY_HOME);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
        finish();
        super.onBackPressed();
    }
}