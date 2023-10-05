package com.example.restlab.model;

public class SurveyItemInstance {
    
    public SurveyItemInstance(SurveyItem surveyItem, SurveyItemInstanceState state) {
        __questionStem = surveyItem.getQuestionStem();
        __possibleAnswers = surveyItem.getPossibleAnswers();
        __state = state;
        __surveyItemId = surveyItem.getItemId();
        __correctAnswer = surveyItem.getCorrectAnswer();
    }

    public SurveyItemInstance() {
    }

    public void answerSurveyItemInstance(String answer) {
        __answerChoice = answer;
    }

    public void setAnswer(String answer) {
        __answerChoice = answer;
    }

    public void setCorrect() {
        __correct = true;
    }

    public void setIncorrect() {
        __correct = false; 
    }

    public boolean getCorrect() {
        return __correct;
    }

    public int getSurveyItemId() {
        return __surveyItemId;
    }

    public void setSurveyItemId(int siid) {
        __surveyItemId = siid;
    }

    public String getQuestionStem() {
        return __questionStem;
    }

    public String[] getPossibleAnswers() {
        return __possibleAnswers;
    }

    public static enum SurveyItemInstanceState {
        COMPLETED, NOTCOMPLETED
    }
    
    public SurveyItemInstanceState getSurveyItemInstanceState() {
        return __state;
    }

    public void setSurveyItemInstanceState(SurveyItemInstanceState state) {
        __state = state;
    }

    public String getAnswerChoice() {
        return __answerChoice;
    }

    private String __answerChoice;
    private boolean __correct;
    private SurveyItemInstanceState __state;
    private int __surveyItemId;
    private String __questionStem;
    private String[] __possibleAnswers;
    private String __correctAnswer;

}
