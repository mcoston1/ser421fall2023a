package com.example.restlab.model;

public class SurveyItemRequest {
    
    public SurveyItemRequest() {

    }

    public SurveyItemRequest(String questionStem, String[] possibleAnswers, String correctAnswer) {
        __questionStem = questionStem;
        __possibleAnswers = possibleAnswers;
        __correctAnswer = correctAnswer;

    }

    public String getQuestionStem() {
        return __questionStem;
    }

    public String[] getPossibleAnswers() {
        return __possibleAnswers;
    }

    public String getCorrectAnswer() {
        return __correctAnswer;
    }

    public void setQuestionStem(String questionStem) {
        __questionStem = questionStem;
    }

    public void setPossibleAnswers(String[] possibleAnswers) {
        __possibleAnswers = possibleAnswers;
    }

    public void setCorrectAnswer(String correctAnswer) {
        __correctAnswer = correctAnswer;
    }

    private String __questionStem;
    private String[] __possibleAnswers;
    private String __correctAnswer;
}
