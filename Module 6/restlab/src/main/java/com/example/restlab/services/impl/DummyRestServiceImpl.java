package com.example.restlab.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.restlab.model.Survey;
import com.example.restlab.model.Survey.SurveyState;
import com.example.restlab.model.SurveyInstance.SurveyInstanceState;
import com.example.restlab.model.SurveyInstance;
import com.example.restlab.model.SurveyItem;
import com.example.restlab.model.SurveyItemInstance;
import com.example.restlab.model.SurveyItemInstance.SurveyItemInstanceState;
import com.example.restlab.model.exceptions.RestInternalException;
import com.example.restlab.model.exceptions.SurveyInstanceNotFoundException;
import com.example.restlab.model.exceptions.SurveyNotFoundException;
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
        List<SurveyItem> list3 = new ArrayList<SurveyItem>(); 
        list3.addAll(Arrays.asList(si3, si4));
        List<SurveyItem> list4 = new ArrayList<SurveyItem>();//empty survey item list
        
        dummySurvey.addAll(Arrays.asList (
            new Survey(0, list1, SurveyState.COMPLETED),
            new Survey(1, list2, SurveyState.COMPLETED),
            new Survey(2, list3, SurveyState.CREATED),
            new Survey(3, list4, SurveyState.CREATED)
        ));

        //add one survey instance. 
        List<SurveyItemInstance> survItemInst = new ArrayList<>();

        for (SurveyItem si : getSurvey(0).getSurveyItems()) { //for each surveyitem, create an instance
            SurveyItemInstance sii = new SurveyItemInstance(si, SurveyItemInstanceState.NOTCOMPLETED);
            survItemInst.add(sii);
        }
        
        dummySurveyInstances.add(new SurveyInstance("kevin", 0, survItemInst));
    }

    @Override
    public List<Survey> getSurveys() {
        return dummySurvey;        
    }

    @Override
    public Survey getSurvey(int id) throws SurveyNotFoundException {
        for (Survey s: dummySurvey) {
            if (s.getSurveyId() == id) return s;
        }
        throw new SurveyNotFoundException("No survey with that id found");
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
    public Survey addSurveyItem(Integer id, SurveyItemRequest surveyItemRequest) throws RestInternalException {
        try {
            int i = 0;
            for (;i < dummySurvey.size() && dummySurvey.get(i).getSurveyId() != id; i++)
            ;;;
            if (i != dummySurvey.size()) { // if id is match, then add item to a survey
                int sItemId = dummySurveyItems.size();//extract the new id first                
                for(SurveyItem si: dummySurveyItems) { //check for duplicates
                    if(si.getQuestionStem().equalsIgnoreCase(surveyItemRequest.getQuestionStem())) { //iuf the question stems match
                        throw new RestInternalException("Survey item with this question already exists.");
                    }
                }
                dummySurveyItems.add(new SurveyItem (dummySurveyItems.size(), surveyItemRequest.getQuestionStem(), surveyItemRequest.getPossibleAnswers(), surveyItemRequest.getCorrectAnswer())); //add to global pile
                List<SurveyItem> itemList = dummySurvey.get(i).getSurveyItems(); //pull survey with id                
                if(itemList.size() == 5) { //error handle full survey
                    dummySurvey.get(i).setSurveyState(SurveyState.COMPLETED);
                    throw new RestInternalException("Survey item list full.");
                } 
                //add item to the surveys list of survey items
                if(itemList.add(new SurveyItem (sItemId, surveyItemRequest.getQuestionStem(), surveyItemRequest.getPossibleAnswers(), surveyItemRequest.getCorrectAnswer()))) {                    
                    return dummySurvey.get(i);  //return 'new' Survey
                } else {
                    throw new RestInternalException("Internal service error, unable to add survey item to survey");
                }                
            } else {
                throw new RestInternalException("Internal service error, unable to add survey item to survey");
            }
        } catch (Throwable t) {
            throw new RestInternalException();
        }
       
    }

    @Override
    public boolean deleteSurvey(int id) throws SurveyNotFoundException {
        int i = 0;
        for (;i < dummySurvey.size() && dummySurvey.get(i).getSurveyId() != id; i++)
        ;;;
        if (i != dummySurvey.size()) {
            dummySurvey.get(i).setSurveyState(SurveyState.DELETED);
            return true;
        } else {
            throw new SurveyNotFoundException("No survey with that id exists");
        }        
    }

    @Override
    public List<SurveyItem> getSurveyItems() {
        return dummySurveyItems;        
    }

    public SurveyItem getSurveyItemById(int id) throws RestInternalException {
        for(SurveyItem si: dummySurveyItems) {
            if (si.getItemId() == id) return si;            
        }
        throw new RestInternalException("Survey item with that id does not exist");
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
    public List<SurveyInstance> getSurveyInstancesByState(String state) {
        List<SurveyInstance> stateList = new ArrayList<SurveyInstance>();
        if(state != null) {
            if (state.equalsIgnoreCase("created")) {
                SurveyInstanceState siState = SurveyInstanceState.CREATED;                
                for (SurveyInstance s: dummySurveyInstances) {
                    if (s.getSurveyInstanceState() == siState) {
                        stateList.add(s);
                    }
                }
            } else if (state.equalsIgnoreCase("inprogress")) {
                SurveyInstanceState siState = SurveyInstanceState.INPROGRESS;
                for (SurveyInstance s: dummySurveyInstances) {
                    if (s.getSurveyInstanceState() == siState) {
                        stateList.add(s);
                    }
                }
            } else if (state.equalsIgnoreCase("completed")) {
                SurveyInstanceState siState = SurveyInstanceState.COMPLETED;
                for (SurveyInstance s: dummySurveyInstances) {
                    if (s.getSurveyInstanceState() == siState) {
                        stateList.add(s);
                    }
                }                
            }
            return stateList;
        } else {
            return dummySurveyInstances;
        }       
    }

    @Override
    public SurveyInstance createSurveyInstance(Integer id, String user, List<SurveyItem> list) {
        try {
            //check for survey to actually exist by id, else throw exception 
            List<SurveyItemInstance> surveyItemInstanceList = new ArrayList<>();

            if (getSurvey(id).getSurveyState() == SurveyState.DELETED) {
                throw new RestInternalException("Unable to create new survey instance, survey marked for deletion");
            }

            for (SurveyItem si : list) { //for each surveyitem, create an instance
                SurveyItemInstance sii = new SurveyItemInstance(si, SurveyItemInstanceState.NOTCOMPLETED); 
                surveyItemInstanceList.add(sii);
            }
            SurveyInstance rval = new SurveyInstance(user, id, surveyItemInstanceList); //if it exist, create a new instance

            if(dummySurveyInstances.add(rval)) { //add the survey instance to the dummysurvinstances
                return rval;
            } else {
                throw new RestInternalException("Internal service error, unable to create new survey instance");
            }
        } catch (Throwable t) {
            throw new RestInternalException();
        }
    }

    @Override
    public SurveyItemInstance addSurveyAnswer(String user, Integer id, Integer surveyItemId, String answer) throws SurveyInstanceNotFoundException {
        try {            
            for(SurveyInstance sIns : dummySurveyInstances) {  //hunt through list of dummySurveyInstances and 
                System.out.println(sIns.getUser()); //-----------DEBUG

                if (sIns.getUser().equalsIgnoreCase(user)) {   //get survey instances with their name attached
                    if (sIns.getSurveyId() == id) {            //check if that instance is from the right survey id
                        for (SurveyItemInstance sIInst : sIns.getSurveyItemInstances()) { //check every survItemInst inside surveyInst
                            if (sIInst.getSurveyItemId() == surveyItemId) { //if the item ids are the same                             
                                 //---------answerSurveyItemInstance(String answer)
                                 if(sIInst.getSurveyItemInstanceState() == SurveyItemInstanceState.COMPLETED) {
                                    throw new SurveyInstanceNotFoundException("This survey item instance has already been completed");
                                 }
                                sIInst.setAnswer(answer);
                                if(answer.equals(getSurveyItemById(surveyItemId).getCorrectAnswer())) {
                                    sIInst.setCorrect();
                                    sIInst.setSurveyItemInstanceState(SurveyItemInstanceState.COMPLETED);
                                } else {
                                    sIInst.setIncorrect();
                                    sIInst.setSurveyItemInstanceState(SurveyItemInstanceState.COMPLETED);
                                }
                                int comp = 0;
                                for(SurveyItemInstance sItemInst : sIns.getSurveyItemInstances()) {
                                    if(sItemInst.getSurveyItemInstanceState() == SurveyItemInstanceState.COMPLETED) {
                                        comp++;
                                    }
                                    if(comp == sIns.getSurveyItemInstances().size()){
                                        sIns.setSurveyInstanceStateToCompleted();
                                    }
                                }
                                SurveyItemInstance rval = sIInst;                            
                                return rval;
                            }
                        }
                    }
                }
            } 
            throw new SurveyInstanceNotFoundException("User, Survey Id, or Survey Item Id does not exist"); 
        } catch (Throwable t) {
            throw new SurveyInstanceNotFoundException();
        }
    }

    @Override
    public List<SurveyInstance> getSurveyInstances() {
        return dummySurveyInstances;
    }

    @Override
    public SurveyInstance getSpecificSurveyInstance(String user, int id) throws SurveyInstanceNotFoundException {
        try {
            for (SurveyInstance si: dummySurveyInstances) {
                if (si.getUser().equalsIgnoreCase(user)) { //if the instance has a user with that name
                    if (si.getSurveyId() == id) {
                        return si;
                    }
                }
            }
            throw new SurveyInstanceNotFoundException("User does not exist or does not have a survey by that id");
        } catch (Throwable t) {
            throw new SurveyInstanceNotFoundException();
        }
    }
} //end of class
