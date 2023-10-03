package com.example.restlab.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.restlab.model.Survey;
import com.example.restlab.model.Survey.SurveyState;
import com.example.restlab.model.SurveyInstance.SurveyInstanceState;
import com.example.restlab.model.SurveyInstance;
import com.example.restlab.model.SurveyItem;
import com.example.restlab.model.exceptions.RestEntityNotFoundException;
import com.example.restlab.model.exceptions.RestInternalException;
import com.example.restlab.modelhelpers.SurveyItemRequest;
import com.example.restlab.services.RestService;

public class DummyRestServiceImpl implements RestService {

    private List<Survey> dummySurvey = new ArrayList<Survey>();
    public static List<SurveyItem> dummySurveyItems = new ArrayList<SurveyItem>();
    public List<SurveyInstance> dummySurveyInstances = new ArrayList<SurveyInstance>();

    public DummyRestServiceImpl() {         
        String[] ans = {"0", "42", "4", "1"};
        SurveyItem si1 = new SurveyItem(0, "what is the answer to life", ans, "42");
        SurveyItem si2 = new SurveyItem(1, "what is the loneliest number", ans, "1");
        SurveyItem si3 = new SurveyItem(2, "what number is always wrong", ans, "0");
        SurveyItem si4 = new SurveyItem(3, "what is the unluckiest number", ans, "4");
        SurveyItem si5 = new SurveyItem(4, "where did disney hercules go to hero from", ans, "0");

        dummySurveyItems.addAll(Arrays.asList(si1, si2, si3, si4, si5)); //add all survey items globally

        List<SurveyItem> list1 = new ArrayList<SurveyItem>();
        list1.addAll(Arrays.asList(si1, si2, si3, si4, si5)); //survey item list with all survey items
        List<SurveyItem> list2 = new ArrayList<SurveyItem>();
        list2.addAll(Arrays.asList(si1,si3, si5)); //survey item list with only 3
        List<SurveyItem> list3 = new ArrayList<SurveyItem>(); //empty survey item list
        
        dummySurvey.addAll(Arrays.asList (
            new Survey(0, list1, SurveyState.COMPLETED),
            new Survey(1, list2, SurveyState.COMPLETED),
            new Survey(2, list3, SurveyState.CREATED)
        ));

        //add one survey instance. 
    }

    @Override
    public List<Survey> getSurveys() {
        return dummySurvey;        
    }

    @Override
    public Survey getSurvey(int id) throws RestEntityNotFoundException {
        for (Survey s: dummySurvey) {
            if (s.getSurveyId() == id) return s;
        }
        throw new RestEntityNotFoundException();
    }

    @Override
    public Survey createSurvey(List<SurveyItem> surveyItems, SurveyState surveyState) {
        try {
            Survey rval = new Survey(dummySurvey.size(), surveyItems, surveyState);
            if(dummySurvey.add(rval)) {
                return rval;
            } else {
                throw new RestInternalException("Internal service error, unable to create Survey");
            }
        } catch (Throwable t) {
            throw new RestInternalException();
        }        
    }

    @Override
    public Survey addSurveyItem(Integer id, SurveyItemRequest surveyItemRequest) throws RestEntityNotFoundException {
        try {
            int i = 0;
            for (;i < dummySurvey.size() && dummySurvey.get(i).getSurveyId() != id; i++)
            ;;;
            if (i != dummySurvey.size()) { // if id is match, then add item to a survey
                int sItemId = dummySurveyItems.size();//extract the id first
                dummySurveyItems.add(new SurveyItem (dummySurveyItems.size(), surveyItemRequest.getQuestionStem(), surveyItemRequest.getPossibleAnswers(), surveyItemRequest.getCorrectAnswer())); //add to global pile

                List<SurveyItem> itemList = dummySurvey.get(i).getSurveyItems(); //pull survey with id

                //error handle duplicate survey items in here or full survey somewhere-----------------------------------




                //add item to the surveys list of survey items
                if(itemList.add(new SurveyItem (sItemId, surveyItemRequest.getQuestionStem(), surveyItemRequest.getPossibleAnswers(), surveyItemRequest.getCorrectAnswer()))) {                    
                    return dummySurvey.get(i);  //return 'new' Survey
                } else {
                    throw new RestInternalException("Internal service error, unable to add survey item to survey");
                }                
            } else {
                return null;
            }
        } catch (Throwable t) {
            throw new RestInternalException();
        }
       
    }

    @Override
    public boolean deleteSurvey(int id) throws RestEntityNotFoundException {
        int i = 0;
        for (;i < dummySurvey.size() && dummySurvey.get(i).getSurveyId() != id; i++)
        ;;;
        if (i != dummySurvey.size()) {
            dummySurvey.remove(i);
            return true;
        } else {
            return false;
        }        
    }

    @Override
    public List<SurveyItem> getSurveyItems() {
        return dummySurveyItems;        
    }

    
    @Override
    public SurveyItem createSurveyItem(SurveyItemRequest surveyItemRequest) {
        try {
            SurveyItem rval = new SurveyItem (dummySurveyItems.size(), surveyItemRequest.getQuestionStem(), surveyItemRequest.getPossibleAnswers(), surveyItemRequest.getCorrectAnswer());
            if (dummySurveyItems.add(rval)) {
                return rval;
            } else {
               throw new RestInternalException("Internal service error, unable to create survey item"); 
            }
        } catch (Throwable t) {
            throw new RestInternalException();
        }
    }

    @Override
    public List<SurveyInstance> getSurveyInstancesByState(SurveyInstanceState state) {
        if(state != null) {
            List<SurveyInstance> stateList = new ArrayList<SurveyInstance>();
            for (SurveyInstance s: dummySurveyInstances) {
                if (s.getSurveyInstanceState() == state) {
                    stateList.add(s);
                }
            }
            return stateList;            
        } else {
            return dummySurveyInstances;
        }       
    }

    @Override
    public SurveyInstance createSurveyInstance(Integer id, String user) {
        try {
            SurveyInstance rval = new SurveyInstance(user, id);
            if(dummySurveyInstances.add(rval)) {
                return rval;
            } else {
                throw new RestInternalException("Internal service error, unable to create new survey instance");
            }
        } catch (Throwable t) {
            throw new RestInternalException();
        }
    }

    @Override
    public SurveyInstance addSurveyAnswer(Integer id, Integer surveyItemId, String answer)
            throws RestEntityNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addSurveyAnswer'");
    }

    @Override
    public SurveyInstance getSurveyInstance(String user) throws RestEntityNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSurveyInstance'");
    }
} //end of class
