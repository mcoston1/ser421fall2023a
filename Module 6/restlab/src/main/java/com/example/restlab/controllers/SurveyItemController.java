package com.example.restlab.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restlab.model.SurveyItem;
import com.example.restlab.modelhelpers.SurveyItemRequest;
import com.example.restlab.services.RestService;

@RequestMapping("/surveyitems")
@RestController
public class SurveyItemController {

    private RestService __restService = RestService.getInstance();

    //just extra, return the full list of survey items
    @GetMapping
    public List<SurveyItem> returnSurveyItems() {
        return __restService.getSurveyItems();
    }

    //first endpoint, create a survey item
    @PostMapping
    public ResponseEntity<SurveyItem> createSurveyItem(@RequestBody SurveyItemRequest surveyItemRequest) {
        SurveyItem rval = __restService.createSurveyItem(surveyItemRequest);
        if (rval != null) {
            return new ResponseEntity<>(rval, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}