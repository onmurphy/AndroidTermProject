package com.example.oliviamurphy.MakeMePretty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by oliviamurphy on 4/15/16.
 */
public class CalculatingResults extends Activity{
    private final int CALCULATING_DISPLAY_LENGTH = 4000;
    TextView textView;
    ArrayList<String> answersChosen;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculating_results);

        Bundle myBundle = getIntent().getExtras();
        if (myBundle != null) {
            answersChosen = myBundle.getStringArrayList("answersChosen");
        } else {
            Log.i("BundleLoading", "it is null");
        }

        final Animation in = new AlphaAnimation(0.0f, 1.0f);
        in.setDuration(2000);

        textView = (TextView) findViewById(R.id.textView3);
        textView.startAnimation(in);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent = new Intent(CalculatingResults.this, QuizResults.class);
                Bundle b = new Bundle();
                b.putStringArrayList("answersChosen", answersChosen);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }
        }, CALCULATING_DISPLAY_LENGTH);
    }
}
