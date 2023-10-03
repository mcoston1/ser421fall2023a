package com.example.restlab.model;

import java.util.List;

public class SurveyRequest {
    
    public SurveyRequest() {

    }

    
    public SurveyRequest(List<SurveyItem> surveyItems) {
        __surveyItems = surveyItems;
        
    }

    public List<SurveyItem> getSurveyItems() {
        return __surveyItems;
    }

    public void setSurveyItems(List<SurveyItem> surveyItems) {
        __surveyItems = surveyItems;
    }

    private List<SurveyItem> __surveyItems;

}
