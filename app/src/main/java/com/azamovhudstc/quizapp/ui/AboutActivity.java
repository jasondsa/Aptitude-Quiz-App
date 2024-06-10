package com.azamovhudstc.quizapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.azamovhudstc.quizapp.R;

public class AboutActivity extends AppCompatActivity {
    androidx.appcompat.widget.Toolbar toolbar;

    ImageView githubIcon,dailerIcon,linkedinIcon,gmailIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        initView();
        toolbar.setNavigationOnClickListener(v->{
            onBackPressed();
        });
        githubIcon.setOnClickListener(v->{
            String url = "https://github.com/jasondsa";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });
        dailerIcon.setOnClickListener(v->{
            String url = "tel: +917972163039";
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        });
        linkedinIcon.setOnClickListener(v->{
            String url = "https://www.linkedin.com/in/jason-dsa/";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });
        gmailIcon.setOnClickListener(v->{
            String url = "mailto:dsajason2002@gmail.com";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);

        });
    }
    private void initView(){
        toolbar=findViewById(R.id.toolbar2);
        githubIcon=findViewById(R.id.githubIcon);
        dailerIcon=findViewById(R.id.dailerIcon);
        linkedinIcon=findViewById(R.id.linkedinIcon);
        gmailIcon=findViewById(R.id.gmailIcon);
    }
}