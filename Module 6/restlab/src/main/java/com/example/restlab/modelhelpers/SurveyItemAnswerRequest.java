package com.example.restlab.modelhelpers;

public class SurveyItemAnswerRequest {
    
    public SurveyItemAnswerRequest(int surveyId, int surveyItemId, String answer) {
        __surveyId = surveyId;
        __surveyItemId = surveyItemId;
        __answer = answer;
    }

    public int getSurveyId() {
        return __surveyId;
    }

    public int getSurveyItemId() {
        return __surveyItemId;
    }

    public String getAnswer() {
        return __answer;
    }

    private int __surveyId;
    private int __surveyItemId;
    private String __answer;
}
