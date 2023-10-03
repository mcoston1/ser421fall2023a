package com.example.restlab.services;

import java.util.List;

import com.example.restlab.model.Survey;
import com.example.restlab.model.SurveyInstance;
import com.example.restlab.model.Survey.SurveyState;
import com.example.restlab.model.SurveyInstance.SurveyInstanceState;
import com.example.restlab.model.SurveyItem;
import com.example.restlab.model.exceptions.RestEntityNotFoundException;
import com.example.restlab.modelhelpers.SurveyItemRequest;
import com.example.restlab.services.impl.DummyRestServiceImpl;

public interface RestService {
    public static final int CREATE_SURVEY_ERROR = -1;

    public static RestService getInstance() {
        return new DummyRestServiceImpl();
    }

    //Survey related
    public List<Survey> getSurveys();
    public Survey getSurvey(int id) throws RestEntityNotFoundException;
    public Survey createSurvey(List<SurveyItem> surveyItems, SurveyState surveyState);
    public Survey addSurveyItem(Integer id, SurveyItemRequest sIR) throws RestEntityNotFoundException;
    public boolean deleteSurvey(int id) throws RestEntityNotFoundException;

    //Survey Instance related
    public List<SurveyInstance> getSurveyInstancesByState(SurveyInstanceState state);
    public SurveyInstance createSurveyInstance(Integer id, String user);
    public SurveyInstance addSurveyAnswer(Integer id, Integer surveyItemId, String answer) throws RestEntityNotFoundException;
    public SurveyInstance getSurveyInstance(String user) throws RestEntityNotFoundException;

    //SurveyItem related
    public List<SurveyItem> getSurveyItems();
    public SurveyItem createSurveyItem(SurveyItemRequest surveyItemRequest);



}
