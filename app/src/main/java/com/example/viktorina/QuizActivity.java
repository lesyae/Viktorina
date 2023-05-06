package com.example.viktorina;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class QuizActivity extends AppCompatActivity {

    private TextView questions;
    private TextView question;

    private AppCompatButton app1, app2, app3, app4;
    private AppCompatButton nextBtn;

    private Timer quizTimer;

    private int seconds = 0;
    private int totalTimeInMins = 1;

    private List<QuestionsList> questionsList;

    private int currentQuestionPosition = 0;
    private String selectedOptionByUser = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final ImageView backBtn = findViewById(R.id.backbtn);
        final TextView timer = findViewById(R.id.timer);
        final TextView selectedTopicName = findViewById(R.id.selectedTopikName);

        questions = findViewById(R.id.questions);
        question = findViewById(R.id.question);

        app1 = findViewById(R.id.app1);
        app2 = findViewById(R.id.app2);
        app3 = findViewById(R.id.app3);
        app4 = findViewById(R.id.app4);

        nextBtn = findViewById(R.id.nextbtn);

        final String getSelectedTopic = getIntent().getStringExtra("selectedTopic");

        selectedTopicName.setText(getSelectedTopic);

        questionsList = QuestionsBank.getQuestions(getSelectedTopic);

        startTimer(timer);

        questions.setText((currentQuestionPosition+1)+"/"+questionsList.size());
        question.setText(questionsList.get(0).getQuestion());
        app1.setText(questionsList.get(0).getApp1());
        app2.setText(questionsList.get(0).getApp2());
        app3.setText(questionsList.get(0).getApp3());
        app4.setText(questionsList.get(0).getApp4());

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quizTimer.purge();
                quizTimer.cancel();

                startActivity(new Intent(QuizActivity.this, MainActivity.class));
                finish();
            }
        });

        app1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (selectedOptionByUser.isEmpty()) {

                    selectedOptionByUser = app1.getText().toString();
                    app1.setBackgroundResource(R.drawable.round_back_red10);
                    app1.setTextColor(Color.WHITE);

                    revealAswer();
                    questionsList.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }

            }
        });
        app2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (selectedOptionByUser.isEmpty()) {

                    selectedOptionByUser = app2.getText().toString();
                    app2.setBackgroundResource(R.drawable.round_back_red10);
                    app2.setTextColor(Color.WHITE);

                    revealAswer();
                    questionsList.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }

            }
        });
        app3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (selectedOptionByUser.isEmpty()) {

                    selectedOptionByUser = app3.getText().toString();
                    app3.setBackgroundResource(R.drawable.round_back_red10);
                    app3.setTextColor(Color.WHITE);

                    revealAswer();
                    questionsList.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }

            }
        });
        app4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (selectedOptionByUser.isEmpty()) {

                    selectedOptionByUser = app4.getText().toString();
                    app4.setBackgroundResource(R.drawable.round_back_red10);
                    app4.setTextColor(Color.WHITE);

                    revealAswer();
                    questionsList.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }

            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (selectedOptionByUser.isEmpty()){
                    Toast.makeText(QuizActivity.this, "сделайте выбор", Toast.LENGTH_SHORT).show();
                }else {

                }

            }
        });

    }
    private void startTimer (TextView timerTextView) {

        quizTimer = new Timer();
        quizTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if( seconds  == 0){
                    totalTimeInMins--;
                    seconds = 59;
                } else if (seconds == 0 && totalTimeInMins ==0 ) {
                    quizTimer.purge();
                    quizTimer.cancel();

                    Toast.makeText(QuizActivity.this, "Время вышло", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(QuizActivity.this, QuisResults.class);
                    intent.putExtra("correct", getCorrectAnswers());
                    intent.putExtra("incorrect", getInCorrectAnswers() );

                    startActivity(intent);
                    finish();
                }
                else {
                    seconds --;
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        String finalMinutes = String.valueOf(totalTimeInMins);
                        String finalSeconds = String.valueOf(seconds);

                        if (finalMinutes.length() == 1){
                            finalMinutes = "0"+finalMinutes;
                        }
                        if (finalSeconds.length() == 1){
                            finalSeconds = "0" + finalSeconds;
                        }
                        timerTextView.setText(finalMinutes + ":" + finalSeconds);

                    }
                });

            }
        },1000,1000);

    }

    private int getCorrectAnswers () {

        int correctAnswers = 0;

        for (int i = 0; i < questionsList.size() ; i++) {

            final String getUserSelectedAnswer = questionsList.get(i).getUserSelectedAnswer();
            final String getAnswer = questionsList.get(i).getAnswer();

            if (getUserSelectedAnswer.equals(getAnswer)) {
                correctAnswers++;
            }
        }

        return correctAnswers;
    }
    private int getInCorrectAnswers () {

        int correctAnswers = 0;

        for (int i = 0; i < questionsList.size() ; i++) {

            final String getUserSelectedAnswer = questionsList.get(i).getUserSelectedAnswer();
            final String getAnswer = questionsList.get(i).getAnswer();

            if (!getUserSelectedAnswer.equals(getAnswer)) {
                correctAnswers++;
            }
        }

        return correctAnswers;
    }

    @Override
    public void onBackPressed() {
        quizTimer.purge();
        quizTimer.cancel();

        startActivity(new Intent(QuizActivity.this, MainActivity.class));
        finish();
    }

    private  void revealAswer () {

        final String getAnswer = questionsList.get(currentQuestionPosition).getAnswer();

        if (app1.getText().toString().equals(getAnswer)) {
            app1.setBackgroundResource(R.drawable.round_back_green10);
            app1.setTextColor(Color.WHITE);
        }
        else if  (app2.getText().toString().equals(getAnswer)) {
            app2.setBackgroundResource(R.drawable.round_back_green10);
            app2.setTextColor(Color.WHITE);
        }
        else if (app3.getText().toString().equals(getAnswer)) {
            app3.setBackgroundResource(R.drawable.round_back_green10);
            app3.setTextColor(Color.WHITE);
        }
        else if (app4.getText().toString().equals(getAnswer)) {
            app4.setBackgroundResource(R.drawable.round_back_green10);
            app4.setTextColor(Color.WHITE);
        }
    }
    private void changeNextQuestion (){
        currentQuestionPosition++;

        if ((currentQuestionPosition+1) == questionsList.size()){
            nextBtn.setText("готово");
        }
        if (currentQuestionPosition<questionsList.size()){
            selectedOptionByUser = "";
            app1.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            app1.setTextColor(Color.parseColor("#1F6BB8"));

            app2.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            app2.setTextColor(Color.parseColor("#1F6BB8"));

            app3.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            app3.setTextColor(Color.parseColor("#1F6BB8"));

            app4.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            app4.setTextColor(Color.parseColor("#1F6BB8"));

            questions.setText((currentQuestionPosition+1)+"/"+questionsList.size());
            question.setText(questionsList.get(currentQuestionPosition).getQuestion());
            app1.setText(questionsList.get(currentQuestionPosition).getApp1());
            app2.setText(questionsList.get(currentQuestionPosition).getApp2());
            app3.setText(questionsList.get(currentQuestionPosition).getApp3());
            app4.setText(questionsList.get(currentQuestionPosition).getApp4());
        }
        else {
            Intent intent = new Intent(QuizActivity.this,QuisResults.class);
            intent.putExtra("correct",getCorrectAnswers() );
            intent.putExtra("incorrect",getInCorrectAnswers());
            startActivity(intent);
            finish();
        }
    }
}