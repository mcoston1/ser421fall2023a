package com.example.restlab.model;
import java.util.List;


public class SurveyInstance {    

    public SurveyInstance(String user, int surveyId, List<SurveyItemInstance> surveyItemInstances) {
        __user = user;
        __state = SurveyInstanceState.CREATED;
        __surveyId = surveyId;
        __surveyItemInstances = surveyItemInstances;
    }

    public String getUser() {
        return __user;
    }
    public void setUser(String user) {
        __user = user;
    }

    public int getSurveyId() {
        return __surveyId;
    }

    public SurveyInstanceState getSurveyInstanceState() {
        return __state;
    }

    public void setSurveyInstanceStateToInProg() {
        __state = SurveyInstanceState.INPROGRESS;
    }

    public void setSurveyInstanceStateToCompleted() {
        __state = SurveyInstanceState.COMPLETED;
    }

    public void setSurveyItemInstances(List<SurveyItemInstance> surveyItemInstances) {
        __surveyItemInstances = surveyItemInstances;
    }

    public List<SurveyItemInstance> getSurveyItemInstances() {
        return __surveyItemInstances;
    }

    public void addSurveyItemInstance(SurveyItemInstance sii) {
        __surveyItemInstances.add(sii);
    }

    private String __user;
    private int __surveyId;
    private SurveyInstanceState __state;
    private List<SurveyItemInstance> __surveyItemInstances;
   
    public static enum SurveyInstanceState {
        CREATED, INPROGRESS, COMPLETED
    }

}