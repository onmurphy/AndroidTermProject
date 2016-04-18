package com.example.oliviamurphy.MakeMePretty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.view.animation.AlphaAnimation;

import java.util.List;

/**
 * Created by oliviamurphy on 4/14/16.
 */
public class Quiz extends Activity{
    Button nextButton;
    Button submitButton;
    Button hintButton;
    int currentIndex = 0;
    TextView questionTextView;
    String[] questionBank;
    TextView questionCountTextView;
    RadioGroup radioGroup;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;
    List<Question> questionList;
    int questionID = 0;
    Question currentQuestion;
    DBHelper db;

    private void setQuestionView()
    {
        questionTextView.setText(currentQuestion.getQUESTION());
        radioButton1.setText(currentQuestion.getOPTA());
        radioButton2.setText(currentQuestion.getOPTB());
        radioButton3.setText(currentQuestion.getOPTC());
        radioButton4.setText(currentQuestion.getOPTD());
        questionID++;
    }


    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //db = new DBHelper(this);
        //db.getWritableDatabase();

        //questionList = db.getAllQuestions();

        //currentQuestion = questionList.get(questionID);

        //questionBank = getResources().getStringArray(R.array.question_bank);

        final Animation in = new AlphaAnimation(0.0f, 1.0f);
        in.setDuration(2000);

        final Animation animation =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.slide_left);

        radioGroup = (RadioGroup) findViewById(R.id.answers);
        radioGroup.startAnimation(animation);

        questionTextView = (TextView) findViewById(R.id.textView);
        //questionTextView.setText(questionBank[currentIndex]);
        questionTextView.startAnimation(in);

        currentIndex++;

        questionCountTextView = (TextView) findViewById(R.id.questionCountTextView);
        questionCountTextView.setText((currentIndex) + " of 10");

        submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setVisibility(View.GONE);

        hintButton = (Button) findViewById(R.id.hintButton);
        hintButton.setVisibility(View.GONE);

        radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton) findViewById(R.id.radioButton4);

        //setQuestionView();

        nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionID<10){
                    //currentQuestion=questionList.get(questionID);
                    //setQuestionView();
                    questionTextView.startAnimation(in);
                    radioGroup.clearCheck();
                    radioGroup.startAnimation(animation);
                }else{
                    Intent intent = new Intent(Quiz.this, QuizResults.class);
                    Bundle b = new Bundle();
                    b.putInt("score", 5); //Your score
                    intent.putExtras(b); //Put your score to your next Intent
                    startActivity(intent);
                    finish();
                }
                //questionTextView.setText(questionBank[currentIndex]);
                //questionTextView.startAnimation(in);

                //radioGroup.clearCheck();
                //radioGroup.startAnimation(animation);

                currentIndex++;

                if(currentIndex==9) {
                    nextButton.setVisibility(View.GONE);
                    submitButton.setVisibility(View.VISIBLE);
                    submitButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i= new Intent(Quiz.this, CalculatingResults.class);
                            startActivity(i);
                        }
                    });
                }
                if(currentIndex==5 || currentIndex ==7) {
                    hintButton.setVisibility(View.VISIBLE);
                }
                else {
                    hintButton.setVisibility(View.GONE);
                }

                questionCountTextView.setText((currentIndex) + " of 10");
            }
        });

        hintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex == 5) {
                    startActivity(new Intent(Quiz.this, PopupUndertone.class));
                }
                if (currentIndex == 7) {
                    startActivity(new Intent(Quiz.this, PopupFaceShape.class));
                }
            }
        });
    }
}
