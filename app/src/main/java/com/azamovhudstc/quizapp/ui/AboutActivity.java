package com.azamovhudstc.quizapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toolbar;

import com.azamovhudstc.quizapp.R;

public class AboutActivity extends AppCompatActivity {
    androidx.appcompat.widget.Toolbar toolbar;
    CardView github,instagram,linkedin,telegram;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        initView();
        toolbar.setNavigationOnClickListener(v->{
            onBackPressed();
        });
        github.setOnClickListener(v->{
            String url = "https://github.com/jasondsa";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });
        instagram.setOnClickListener(v->{
            String url = "https://www.instagram.com/gita.uzofficial/";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });
        linkedin.setOnClickListener(v->{
            String url = "https://www.linkedin.com/in/jason-dsa/";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });
        telegram.setOnClickListener(v->{
            String url = "https://t.me/stc_android";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });
    }
    private void initView(){
        toolbar=findViewById(R.id.toolbar2);
        github=findViewById(R.id.github);
        instagram=findViewById(R.id.instagram);
        linkedin=findViewById(R.id.linkedin);
        telegram=findViewById(R.id.cardView3);
    }
}