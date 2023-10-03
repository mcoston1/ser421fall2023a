package com.example.restlab.model;

import java.util.ArrayList;
import java.util.List;

public class SurveyInstance {
    
    public SurveyInstance(String user, int surveyId) {
        __user = user;
        __state = SurveyInstanceState.CREATED;
        __surveyId = surveyId;
    }

    public String getUser() {
        return __user;
    }

    public int getSurveyId() {
        return __surveyId;
    }

    public SurveyInstanceState getSurveyInstanceState() {
        return __state;
    }

    public void setSurveyItemInstances(List<SurveyItemInstance> surveyItemInstances) {
        __surveyItemInstances = surveyItemInstances;
    }

    public void setSurvey(Survey s) {
        __survey = s;
    }

    private String __user;
    private Survey __survey;
    private int __surveyId;
    private SurveyInstanceState __state;
    private List<SurveyItemInstance> __surveyItemInstances = new ArrayList<SurveyItemInstance>();
   
    public static enum SurveyInstanceState {
        CREATED, INPROGRESS, COMPLETED
    }

}