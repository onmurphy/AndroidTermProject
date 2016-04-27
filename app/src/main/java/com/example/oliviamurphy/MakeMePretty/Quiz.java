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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oliviamurphy on 4/14/16.
 */
public class Quiz extends Activity{
    Button nextButton;
    Button submitButton;
    Button hintButton;
    int currentIndex = 1;
    TextView questionTextView;
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
    ArrayList<String> answersChosen = new ArrayList<>();
    public final String QUIZ_INDEX = "quizIndex";
    public final String QUESTION_ID = "questionID";
    public final String ANSWER_LIST = "answerList";

    private void setQuestionView()
    {
        questionTextView.setText(currentQuestion.getQUESTION());
        radioButton1.setText(currentQuestion.getOPTA());
        radioButton2.setText(currentQuestion.getOPTB());
        radioButton3.setText(currentQuestion.getOPTC());
        radioButton4.setText(currentQuestion.getOPTD());
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putStringArrayList(ANSWER_LIST, answersChosen);
        savedInstanceState.putInt(QUIZ_INDEX, currentIndex);
        savedInstanceState.putInt(QUESTION_ID, questionID);
        super.onSaveInstanceState(savedInstanceState);
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        answersChosen = savedInstanceState.getStringArrayList(ANSWER_LIST);
        questionID = savedInstanceState.getInt(QUESTION_ID);
        if(questionID == 5) {
            radioButton4.setVisibility(View.GONE);
            hintButton.setVisibility(View.VISIBLE);
        }
        else if (questionID == 7){
            hintButton.setVisibility(View.VISIBLE);
        }
    }
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        db = new DBHelper(this);
        db.addQuestions();
        questionList = db.getAllQuestions();
        if(savedInstanceState != null)
        {
            questionID = savedInstanceState.getInt(QUESTION_ID);
            currentIndex = savedInstanceState.getInt(QUIZ_INDEX);
            if(questionID == 6) {
                radioButton4.setVisibility(View.GONE);
            }

        }
        currentQuestion = questionList.get(questionID);

        final Animation in = new AlphaAnimation(0.0f, 1.0f);
        in.setDuration(2000);

        final Animation animation =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.slide_left);

        radioGroup = (RadioGroup) findViewById(R.id.answers);
        radioGroup.startAnimation(animation);

        radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton) findViewById(R.id.radioButton4);

        questionTextView = (TextView) findViewById(R.id.textView);

        setQuestionView();

        questionTextView.startAnimation(in);

        //currentIndex++;

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
                if (radioGroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Wait, you didn't choose an answer!", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (radioButton1.isChecked()) {
                        answersChosen.add(questionID, "optA");
                    }

                    if (radioButton2.isChecked()) {
                        answersChosen.add(questionID, "optB");
                    }

                    if (radioButton3.isChecked()) {
                        answersChosen.add(questionID, "optC");
                    }

                    if (radioButton4.isChecked()) {
                        answersChosen.add(questionID, "optD");
                    }
                    if (questionID < 9) {
                        questionID++;
                        currentQuestion = questionList.get(questionID);
                        setQuestionView();
                        questionTextView.startAnimation(in);
                    }

                    questionTextView.startAnimation(in);
                    radioGroup.clearCheck();
                    radioGroup.startAnimation(animation);

                    currentIndex++;

                    if (questionID == 9) {
                        nextButton.setVisibility(View.GONE);
                        submitButton.setVisibility(View.VISIBLE);
                    }

                    submitButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (radioGroup.getCheckedRadioButtonId() == -1) {
                                Toast.makeText(getApplicationContext(), "Wait, you didn't choose an answer!", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                if (radioButton1.isChecked()) {
                                    answersChosen.add(questionID, "optA");
                                }

                                if (radioButton2.isChecked()) {
                                    answersChosen.add(questionID, "optB");
                                }

                                if (radioButton3.isChecked()) {
                                    answersChosen.add(questionID, "optC");
                                }

                                if (radioButton4.isChecked()) {
                                    answersChosen.add(questionID, "optD");
                                }
                            }

                            Intent intent = new Intent(Quiz.this, CalculatingResults.class);
                            Bundle b = new Bundle();
                            b.putStringArrayList("answersChosen", answersChosen);
                            intent.putExtras(b);
                            startActivity(intent);
                            finish();
                        }
                    });
                }

                if(questionID==5 || questionID==7) {
                    hintButton.setVisibility(View.VISIBLE);
                }
                else {
                    hintButton.setVisibility(View.GONE);
                }

                if(questionID==5) {
                    radioButton4.setVisibility(View.GONE);
                }
                else if(savedInstanceState != null && questionID ==5) {
                    radioButton4.setVisibility(View.GONE);
                }
                else{
                    radioButton4.setVisibility(View.VISIBLE);
                }

                questionCountTextView.setText((currentIndex) + " of 10");
            }
        });

        hintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionID == 5) {
                    startActivity(new Intent(Quiz.this, PopupUndertone.class));
                }
                if (questionID == 7) {
                    startActivity(new Intent(Quiz.this, PopupFaceShape.class));
                }
            }
        });
    }
}
