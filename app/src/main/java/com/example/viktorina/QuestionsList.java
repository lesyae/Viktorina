package com.example.viktorina;

public class QuestionsList {

    private String question, app1,app2,app3,app4, answer;
    private String userSelectedAnswer;

    public QuestionsList(String question, String app1, String app2, String app3, String app4, String answer, String userSelectedAnswer) {
        this.question = question;
        this.app1 = app1;
        this.app2 = app2;
        this.app3 = app3;
        this.app4 = app4;
        this.answer = answer;
        this.userSelectedAnswer = userSelectedAnswer;
    }

    public String getQuestion() {return question;}

    public String getApp1() {return app1;}

    public String getApp2() {return app2;}

    public String getApp3() {return app3;}

    public String getApp4() {return app4;}

    public String getAnswer() {return answer;}

    public String getUserSelectedAnswer() {return userSelectedAnswer;}

    public void setUserSelectedAnswer(String userSelectedAnswer) {
        this.userSelectedAnswer = userSelectedAnswer;
    }
}
