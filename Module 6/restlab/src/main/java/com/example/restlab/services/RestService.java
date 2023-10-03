package com.example.restlab.services;

public interface RestService {
    public static final int CREATE_SURVEY_ERROR = -1;

    public static RestService getInstance() {
        return new DummyRestServiceImpl();
    }

    //Survey related
    public List<Survey> getSurveys();
    public Survey getSurvey(int id) throws RestEntityNotFoundException;
    public Survey createSurvey(List<SurveyItem> surveyItems, SurveyState surveyState);
    public Survey addSurveyItem(Survey survey) throws RestEntityNotFoundException;
    public Survey deleteSurvey(int id) throws RestEntityNotFoundException;

    //SurveyItem related
    public List<SurveyItem> getSurveyItems();
    public SurveyItem getSurveyItem(int id) throws RestEntityNotFoundException;

}
