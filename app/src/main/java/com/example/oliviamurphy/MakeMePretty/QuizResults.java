package com.example.oliviamurphy.MakeMePretty;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oliviamurphy on 4/15/16.
 */
public class QuizResults extends Activity {

    ArrayList<String> answersChosen;
    ArrayList<String> textReady = new ArrayList<String>();
    DBHelper db;
    List<Question> questionList;
    Question currentQuestion;
    int questionID = 0;
    TextView textView;

    ImageButton arrowRight;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Bundle myBundle = getIntent().getExtras();
        if (myBundle != null) {
            answersChosen = myBundle.getStringArrayList("answersChosen");
        } else {
            Log.i("BundleLoading", "it is null");
        }

        db = new DBHelper(this);
        db.addQuestions();
        questionList = db.getAllQuestions();

        currentQuestion = questionList.get(questionID);

        for (String answers : answersChosen) {
            if (answers.equals("optA")) {
                textReady.add(currentQuestion.getANSWERA());
            } else  if (answers.equals("optB")) {
                textReady.add(currentQuestion.getANSWERB());
            } else if (answers.equals("optC")) {
                textReady.add(currentQuestion.getANSWERC());
            } else if (answers.equals("optD")) {
                textReady.add(currentQuestion.getANSWERD());
            }
            currentQuestion = questionList.get(++questionID);
        }

        textView = (TextView) findViewById(R.id.textView4);
        arrowRight = (ImageButton) findViewById(R.id.arrowRight);

        textView.setText(textReady.get(questionID));
        questionID++;

        arrowRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textReady.get(questionID));
                questionID++;
            }
        });
    }

}
