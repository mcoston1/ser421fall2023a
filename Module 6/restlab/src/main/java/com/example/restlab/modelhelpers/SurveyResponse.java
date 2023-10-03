package com.example.restlab.modelhelpers;

import java.util.List;

import com.example.restlab.model.Survey;
import com.example.restlab.model.SurveyItem;

public class SurveyResponse {
    private String __url;
    private List<SurveyItemLink> __surveyItemLinks;
    private Survey __survey;

    public SurveyResponse() {
        super();
    }

    public SurveyResponse(Survey survey) {
        __survey = survey;
       // setSurveyItemLinks(SurveyItemLink.convertToLinks(survey.getSurveyItems()));
    }

    public String getLink() {
        return __url;
    }

    public void setLink(String url) {
        this.__url = url;
    }

    public List<SurveyItemLink> getSurveyItemLinks() {
        return __surveyItemLinks;
    }

    public void setSurveyItemLinks(List<SurveyItemLink> surveyItemLinks) {
        this.__surveyItemLinks = surveyItemLinks;
    }

    //shadowed from Survey
    public int getSurveyId() {
        return __survey.getSurveyId();
    }


    
}
