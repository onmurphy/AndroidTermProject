package com.example.oliviamurphy.MakeMePretty;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
/**
 * Created by oliviamurphy on 4/15/16.
 */

public class QuizResults extends Activity {
    Button results;
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        results = (Button) findViewById(R.id.results);
        results.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent i= new Intent(QuizResults.this, Quiz.class);
                    startActivity(i);
                }
            });
    }
}
