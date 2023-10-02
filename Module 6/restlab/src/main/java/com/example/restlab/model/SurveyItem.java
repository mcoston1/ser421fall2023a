package com.example.restlab.model;

public class SurveyItem {

    public SurveyItem (int id, String questionStem, String[] possibleAnswers, String correctAnswer) {
        __id = id;
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

    public int getItemId() {
        return __id;
    }

    private int __id;
    private String __questionStem;
    private String[] __possibleAnswers;
    private String __correctAnswer;
}
