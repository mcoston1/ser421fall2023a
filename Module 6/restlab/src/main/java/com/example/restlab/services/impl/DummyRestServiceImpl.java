package com.example.restlab.services.impl;

import java.util.List;

import com.example.restlab.model.Survey;
import com.example.restlab.model.Survey.SurveyState;
import com.example.restlab.model.SurveyItem;
import com.example.restlab.model.exceptions.RestEntityNotFoundException;
import com.example.restlab.services.RestService;

public class DummyRestServiceImpl implements RestService {

    @Override
    public List<Survey> getSurveys() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSurveys'");
    }

    @Override
    public Survey getSurvey(int id) throws RestEntityNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSurvey'");
    }

    @Override
    public Survey createSurvey(List<SurveyItem> surveyItems, SurveyState surveyState) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createSurvey'");
    }

    @Override
    public Survey addSurveyItem(Survey survey) throws RestEntityNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addSurveyItem'");
    }

    @Override
    public Survey deleteSurvey(int id) throws RestEntityNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteSurvey'");
    }

    @Override
    public List<SurveyItem> getSurveyItems() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSurveyItems'");
    }

    @Override
    public SurveyItem getSurveyItem(int id) throws RestEntityNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSurveyItem'");
    }
    
}
