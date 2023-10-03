package com.example.restlab.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restlab.model.Survey;
import com.example.restlab.model.SurveyInstance;
import com.example.restlab.model.SurveyItem;
import com.example.restlab.model.Survey.SurveyState;
import com.example.restlab.model.SurveyInstance.SurveyInstanceState;
import com.example.restlab.modelhelpers.SurveyRequest;
import com.example.restlab.services.RestService;

@RequestMapping("/surveys/instances")
@RestController
public class SurveyInstanceController {
    
    private RestService __restService = RestService.getInstance();

   //first endpoint, return set of survey instances in a given state. if no state, return all
    @GetMapping("/{state}")
    public List<SurveyInstance> returnSurveysInState(@PathVariable SurveyInstanceState surveyInState) {
        return __restService.getSurveyInstancesByState(surveyInState);
    }

    @PostMapping
    public ResponseEntity<SurveyInstance> createSurveyInstance(@RequestBody SurveyInstance surveyInstance) {
        SurveyInstance rval = __restService.createSurveyInstance(surveyInstance.getSurveyId(), surveyInstance.getUser());
        if(rval != null) {
            return new ResponseEntity<>(rval, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}