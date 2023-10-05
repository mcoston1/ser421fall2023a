package com.example.restlab.model;

import java.util.List;

public class Survey {
    
    public Survey(int id, List<SurveyItem> surveyItems, SurveyState state) {
        __id = id;
        __surveyItems = surveyItems;
        __state = state;
    }

    public int getSurveyId() {
        return __id;
    }

    public List<SurveyItem> getSurveyItems() {
        return __surveyItems;
    }

    public SurveyState getSurveyState() {
        return __state;
    }

    public void setSurveyId(int id) {
        __id = id;
    }

    public void setSurveyItems(List<SurveyItem> surveyItems) {
        __surveyItems = surveyItems;
    }

    public void setSurveyState(SurveyState state) {
        __state = state;
    }

    private int __id;
    private List<SurveyItem> __surveyItems;
    private SurveyState __state;

    
    public static enum SurveyState {
        CREATED, COMPLETED, DELETED
    }
}
