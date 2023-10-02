package com.example.restlab.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restlab.model.Survey;
import com.example.restlab.model.SurveyItem;
import com.example.restlab.model.SurveyRequest;
import com.example.restlab.model.Survey.SurveyState;

@RequestMapping("/surveys")
@RestController
public class SurveyController {

    private List<Survey> dummySurvey = new ArrayList<Survey>();

    public SurveyController() {
    
    //dummy data creation --- to be factored out later ------------------------------------------------        
        String[] ans = {"0", "42", "4", "1"};
        SurveyItem si1 = new SurveyItem(0, "what is the answer to life", ans, "42");
        SurveyItem si2 = new SurveyItem(1, "what is the lonliest number", ans, "1");
        SurveyItem si3 = new SurveyItem(2, "what number is always wrong", ans, "0");

        List<SurveyItem> list1 = new ArrayList<SurveyItem>();
        list1.addAll(Arrays.asList(si1, si2, si3));
        List<SurveyItem> list2 = new ArrayList<SurveyItem>();
        list2.addAll(Arrays.asList(si1,si3));
        List<SurveyItem> list3 = new ArrayList<SurveyItem>();
    //end of dummy data creation--------------------------------------------------------------------------
    
     //put in dummy data for survey (list of survey items and string state)
        dummySurvey.addAll(Arrays.asList (
          new Survey(0, list1, SurveyState.COMPLETED),
          new Survey(1, list2, SurveyState.COMPLETED),
          new Survey(2, list3, SurveyState.CREATED)
        ));
    }

    //first endpoint, return a collection of surveys
    @GetMapping
    public List<Survey> returnSurveys() {
        return dummySurvey;
    }

    //second endpoint, return a specific survey by id
    @GetMapping("/{id}")
    public Survey returnSurvey(@PathVariable Integer id) {
        for(Survey s : dummySurvey) {
            if (s.getSurveyId() == id) return s;
        }
        return null;
    }

    //third endpoint, create survey via POST
    @PostMapping
    public void createSurvey(@RequestBody SurveyRequest surveyRequest) {
        dummySurvey.add(new Survey(dummySurvey.size(), surveyRequest.getSurveyItems(), SurveyState.CREATED));
    }

}
