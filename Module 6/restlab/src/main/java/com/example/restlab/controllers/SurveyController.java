package com.example.restlab.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restlab.model.Survey;
import com.example.restlab.model.Survey.SurveyState;
import com.example.restlab.modelhelpers.SurveyItemRequest;
import com.example.restlab.modelhelpers.SurveyRequest;
import com.example.restlab.services.RestService;

@RequestMapping("/surveys")
@RestController
public class SurveyController {

    private RestService __restService = RestService.getInstance();

    //first endpoint, return a collection of surveys
    @GetMapping
    public List<Survey> returnSurveys() {
        return __restService.getSurveys();
    }


    //second endpoint, return a specific survey by id
    @GetMapping("/{id}")
    public Survey returnSurvey(@PathVariable Integer id) {
         return __restService.getSurvey(id);
    }

    //third endpoint, create survey via POST
    @PostMapping
    public ResponseEntity<Survey> createSurvey(@RequestBody SurveyRequest surveyRequest) {
        Survey rval = __restService.createSurvey(surveyRequest.getSurveyItems(), SurveyState.CREATED);
        if(rval != null) {
            return new ResponseEntity<>(rval, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //fourth endpoint, add a survey item to a survey via PUT
    @PutMapping("/{id}")
    public ResponseEntity<Survey> insertSurveyItem(@PathVariable Integer id, @RequestBody SurveyItemRequest surveyItemRequest) {

        Survey rval = __restService.addSurveyItem(id, surveyItemRequest);
        if(rval != null) {
            return new ResponseEntity<>(rval, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //fifth endpoint, delete a survey via DELETE (though really just mark as deleted)
    @DeleteMapping("/{id}") 
    public ResponseEntity<String> deleteSurvey(@PathVariable Integer id) {        
        if(__restService.deleteSurvey(id)) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

       
}
