package com.example.oliviamurphy.MakeMePretty;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import android.content.Intent;
/**
 * Created by oliviamurphy on 4/15/16.
 */

public class QuizResults extends Activity {

    ArrayList<String> answersChosen;
    ArrayList<String> textReady = new ArrayList<String>();
    DBHelper db;
    List<Question> questionList;
    Question currentQuestion;
    int questionID;
    TextView textView;
    ImageButton arrowRight;
    ImageButton arrowLeft;
    Button quizAgain;
    int currentIndex = 0;
    String[] titles;
    TextView title;
    public final String QUESTION_ID_QUIZRESULT = "Question_ID";
    public final String CURRENT_INDEX = "Current_Index";
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt(CURRENT_INDEX,currentIndex);

        super.onSaveInstanceState(savedInstanceState);

    }
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

        questionID = 0;
        if(savedInstanceState != null)
        {
            currentIndex = savedInstanceState.getInt(CURRENT_INDEX);
        }

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
            questionID++;


            if (questionID < answersChosen.size()) {
                currentQuestion = questionList.get(questionID);
            }
        }

        textView = (TextView) findViewById(R.id.textView4);
        arrowRight = (ImageButton) findViewById(R.id.arrowRight);
        arrowLeft = (ImageButton) findViewById(R.id.arrowLeft);
        if(currentIndex < 1) {
            arrowLeft.setVisibility(View.GONE);
        }
        quizAgain = (Button) findViewById(R.id.quizAgainButton);
        quizAgain.setVisibility(View.GONE);
        Resources res = getResources();
        titles = res.getStringArray(R.array.results_titles);
        title = (TextView) findViewById(R.id.title);
        textView.setText(textReady.get(currentIndex));
        title.setText(titles[currentIndex]);
        if(savedInstanceState == null)
        {
            currentIndex++;
        }
        arrowRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex < textReady.size()) {
                    arrowLeft.setVisibility(View.VISIBLE);
                    if(currentIndex < 0)
                    {
                        currentIndex = 0;
                        arrowLeft.setVisibility(View.GONE);
                    }
                    if(currentIndex == 0)
                    {
                        currentIndex = 1;
                    }

                    textView.setText(textReady.get(currentIndex));
                    title.setText(titles[currentIndex]);
                    currentIndex++;

                }

                if (currentIndex == 10) {
                    arrowRight.setVisibility(View.GONE);
                    quizAgain.setVisibility(View.VISIBLE);
                } else {
                    arrowRight.setVisibility(View.VISIBLE);
                }

                quizAgain.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(QuizResults.this, Quiz.class);
                        startActivity(i);
                    }
                });
            }
        });

        arrowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex == 10) {
                    currentIndex--;
                }

                currentIndex--;
                textView.setText(textReady.get(currentIndex));
                title.setText(titles[currentIndex]);

                arrowRight.setVisibility(View.VISIBLE);

                if (currentIndex == 0) {
                    arrowLeft.setVisibility(View.GONE);
                }
            }
        });
    }

}
