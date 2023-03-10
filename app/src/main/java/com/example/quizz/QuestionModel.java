package com.example.quizz;

public class QuestionModel {
    private String question, reponse1,reponse2,reponse3,reponse4;
    private int correctANSNo;

    public QuestionModel(String question, String reponse1, String reponse2, String reponse3, String reponse4, int correctANSNo) {
        this.question = question;
        this.reponse1 = reponse1;
        this.reponse2 = reponse2;
        this.reponse3 = reponse3;
        this.reponse4 = reponse4;
        this.correctANSNo = correctANSNo;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponse1() {
        return reponse1;
    }

    public void setReponse1(String reponse1) {
        this.reponse1 = reponse1;
    }

    public String getReponse2() {
        return reponse2;
    }

    public void setReponse2(String reponse2) {
        this.reponse2 = reponse2;
    }

    public String getReponse3() {
        return reponse3;
    }

    public void setReponse3(String reponse3) {
        this.reponse3 = reponse3;
    }

    public String getReponse4() {
        return reponse4;
    }

    public void setReponse4(String reponse4) {
        this.reponse4 = reponse4;
    }

    public int getCorrectANSNo() {
        return correctANSNo;
    }

    public void setCorrectANSNo(int correctANSNo) {
        this.correctANSNo = correctANSNo;
    }
}
