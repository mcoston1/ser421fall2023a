package com.example.restlab.model;

public class SurveyItemInstance {
    
    public SurveyItemInstance(SurveyItem surveyItem, SurveyItemInstanceState state) {
        __surveyItem = surveyItem;
        __state = state;
    }

    public void answerSurveyItemInstance(String answer) {
        __answerChoice = answer;

        if (answer == __surveyItem.getCorrectAnswer()) {
            __correct = true;
        } else {
            __correct = false;
        }

        __state = SurveyItemInstanceState.COMPLETED;
    }

    public static enum SurveyItemInstanceState {
        COMPLETED, NOTCOMPLETED
    }

    private String __answerChoice;
    private boolean __correct;
    private SurveyItemInstanceState __state;
    private SurveyItem __surveyItem;

}
