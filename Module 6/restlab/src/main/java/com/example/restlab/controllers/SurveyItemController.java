package com.example.restlab.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restlab.model.SurveyItem;
import com.example.restlab.model.SurveyItemRequest;

@RequestMapping("/surveyitems")
@RestController
public class SurveyItemController {

    public static List<SurveyItem> dummySurveyItems = new ArrayList<SurveyItem>();

///populate with dummy data to start for testing-------------------------------------------
    public SurveyItemController() {    
        String[] ans = {"0", "42", "4", "1"};
        SurveyItem si1 = new SurveyItem(0, "what is the answer to life", ans, "42");
        SurveyItem si2 = new SurveyItem(1, "what is the lonliest number", ans, "1");
        SurveyItem si3 = new SurveyItem(2, "what number is always wrong", ans, "0");

    
        dummySurveyItems.addAll(Arrays.asList(si1, si2, si3));

    }

//end of dummy data -----------------------------------------------------------------------

    //just extra, return the full list of survey items
    @GetMapping
    public List<SurveyItem> returnSurveyItems() {
        return dummySurveyItems;
    }

    //first endpoint, create a survey item
    @PostMapping
    public void createSurveyItem(@RequestBody SurveyItemRequest surveyItemRequest) {
        dummySurveyItems.add(new SurveyItem (dummySurveyItems.size(), surveyItemRequest.getQuestionStem(), surveyItemRequest.getPossibleAnswers(), surveyItemRequest.getCorrectAnswer()));
    }
    
}