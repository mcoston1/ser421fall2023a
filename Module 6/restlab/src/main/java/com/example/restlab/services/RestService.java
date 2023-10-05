package com.example.restlab.services;

import java.util.List;

import com.example.restlab.model.Survey;
import com.example.restlab.model.SurveyInstance;
import com.example.restlab.model.Survey.SurveyState;
import com.example.restlab.model.SurveyItem;
import com.example.restlab.model.SurveyItemInstance;
import com.example.restlab.model.exceptions.SurveyInstanceNotFoundException;
import com.example.restlab.model.exceptions.SurveyNotFoundException;
import com.example.restlab.modelhelpers.SurveyItemRequest;
import com.example.restlab.services.impl.DummyRestServiceImpl;

public interface RestService {
    public static final int CREATE_SURVEY_ERROR = -1;

    public static RestService getInstance() {
        return new DummyRestServiceImpl();
    }

    //Survey related
    public List<Survey> getSurveys();
    public Survey getSurvey(int id) throws SurveyNotFoundException;
    public Survey createSurvey(List<SurveyItem> surveyItems, SurveyState surveyState);
    public Survey addSurveyItem(Integer id, SurveyItemRequest sIR) throws SurveyNotFoundException;
    public boolean deleteSurvey(int id) throws SurveyNotFoundException;

    //Survey Instance related
    public List<SurveyInstance> getSurveyInstancesByState(String state);
    public SurveyInstance createSurveyInstance(Integer id, String user, List<SurveyItem> list);
    public SurveyItemInstance addSurveyAnswer(String user, Integer id, Integer surveyItemId, String answer) throws SurveyInstanceNotFoundException;
   // public SurveyInstance getSurveyInstance(String user) throws RestEntityNotFoundException;
    public List<SurveyInstance> getSurveyInstances() throws SurveyInstanceNotFoundException;

    //SurveyItem related
    public List<SurveyItem> getSurveyItems();
    public SurveyItem createSurveyItem(SurveyItemRequest surveyItemRequest);

    public SurveyInstance getSpecificSurveyInstance(String user, int id) throws SurveyInstanceNotFoundException;



}
