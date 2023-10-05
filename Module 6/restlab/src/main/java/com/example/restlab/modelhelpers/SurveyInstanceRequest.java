package com.example.restlab.modelhelpers;

public class SurveyInstanceRequest {
    public SurveyInstanceRequest(String user, int surveyId) {
        __user = user;
        __surveyId = surveyId;
    }

    public String getUser() {
        return __user;
    }

    public int getSurveyId() {
        return __surveyId;
    }

    private String __user;
    private int __surveyId;

}
