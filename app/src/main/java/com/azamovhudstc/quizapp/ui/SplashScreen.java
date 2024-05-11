package com.azamovhudstc.quizapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import com.azamovhudstc.quizapp.local_data.QuizPref;

public class SplashScreen extends AppCompatActivity {
    private QuizPref quizPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        installSplashScreen();
        quizPref = QuizPref.getInstance();
        splashAndroid11();
    }

    private void installSplashScreen() {
        // This method should be implemented if you are using a custom splash screen.
        // If using the default, you can remove this method and its call in onCreate.
    }

    private void splashAndroid11() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                System.out.println(quizPref.getName() + " 123123123123123333333333333333");
                if (quizPref.getName().isEmpty()) {
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                } else {
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                }
                finish();
            }
        }, 1000);
    }
}
