package com.example.oliviamurphy.MakeMePretty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

/**
 * Created by oliviamurphy on 4/15/16.
 */
public class CalculatingResults extends Activity{
    private final int CALCULATING_DISPLAY_LENGTH = 4000;
    TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculating_results);

        final Animation in = new AlphaAnimation(0.0f, 1.0f);
        in.setDuration(2000);

        textView = (TextView) findViewById(R.id.textView3);
        textView.startAnimation(in);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent = new Intent(CalculatingResults.this,QuizResults.class);
                CalculatingResults.this.startActivity(mainIntent);
                CalculatingResults.this.finish();
            }
        }, CALCULATING_DISPLAY_LENGTH);


    }
}
