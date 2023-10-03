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
import com.example.restlab.model.SurveyInstance;
import com.example.restlab.model.SurveyItem;
import com.example.restlab.model.SurveyRequest;
import com.example.restlab.model.Survey.SurveyState;

@RequestMapping("/surveys/instances")
@RestController
public class SurveyInstanceController {
    


    // //first endpoint, return set of survey instances in a given state. if no state, return all
    // @GetMapping("/{state}")
    // public List<SurveyInstance> returnSurveysInState(@PathVariable String surveyState) {
        
     

}