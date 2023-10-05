package com.example.restlab.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restlab.model.SurveyInstance;
import com.example.restlab.model.SurveyItemInstance;
import com.example.restlab.modelhelpers.SurveyInstanceRequest;
import com.example.restlab.modelhelpers.SurveyItemAnswerRequest;
import com.example.restlab.services.RestService;

@RequestMapping("/survey/instances")
@RestController
public class SurveyInstanceController {
    
    private RestService __restService = RestService.getInstance();

   //first endpoint, return set of survey instances in a given state. if no state, return all
    @GetMapping("/state/{surveyInState}")
    public List<SurveyInstance> returnSurveysInState(@PathVariable String surveyInState) {    
        return __restService.getSurveyInstancesByState(surveyInState);        
    }

    @GetMapping("/state/")
    public List<SurveyInstance> returnSurveysNoState() {
        return __restService.getSurveyInstances();
    }

    @GetMapping
    public List<SurveyInstance> returnSurveyInstances() {
        return __restService.getSurveyInstances();
    }

    @GetMapping("/users/{user}")
    public SurveyInstance getSurveyInstance(@PathVariable String user) {
        return __restService.getSurveyInstance(user);
    }

    @GetMapping("/users/{user}/{id}")
    public SurveyInstance getSpecificSurveyInstance(@PathVariable String user, @PathVariable int id) {
        return __restService.getSpecificSurveyInstance(user, id);
    }

    @PostMapping
    public ResponseEntity<SurveyInstance> createSurveyInstance(@RequestBody SurveyInstanceRequest surveyInstanceRequest) {
        SurveyInstance rval = __restService.createSurveyInstance(surveyInstanceRequest.getSurveyId(), surveyInstanceRequest.getUser(), __restService.getSurvey(surveyInstanceRequest.getSurveyId()).getSurveyItems());
        if(rval != null) {
            return new ResponseEntity<>(rval, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/users/{user}")
    public ResponseEntity<SurveyItemInstance> answerSurveyItem(@PathVariable String user, @RequestBody SurveyItemAnswerRequest surveyItemAnswerRequest) {
        SurveyItemInstance rval = __restService.addSurveyAnswer(user, surveyItemAnswerRequest.getSurveyId(), surveyItemAnswerRequest.getSurveyItemId(), surveyItemAnswerRequest.getAnswer());
        if(rval != null) {
            return new ResponseEntity<>(rval, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}