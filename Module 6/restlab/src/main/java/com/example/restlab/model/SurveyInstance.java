package com.example.restlab.model;

import java.util.ArrayList;
import java.util.List;

public class SurveyInstance {
    
    public SurveyInstance(String user, Survey survey, SurveyInstanceState state) {
        __user = user;
        __survey = survey;
        __state = state;

        
    }

    public String getUser() {
        return __user;
    }

    

    private String __user;
    private Survey __survey;
    private SurveyInstanceState __state;
    private List<SurveyItemInstance> surveyItemInstances = new ArrayList<SurveyItemInstance>();
   
    public static enum SurveyInstanceState {
        CREATED, INPROGRESS, COMPLETED
    }

}