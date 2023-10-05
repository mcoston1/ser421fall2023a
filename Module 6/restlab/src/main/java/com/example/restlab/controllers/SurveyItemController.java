package com.example.restlab.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restlab.model.SurveyItem;
import com.example.restlab.model.exceptions.RestInternalException;
import com.example.restlab.modelhelpers.SurveyItemRequest;
import com.example.restlab.services.RestService;

@RequestMapping("/surveyitems")
@RestController
public class SurveyItemController {

    private RestService __restService = RestService.getInstance();

    //just extra, return the full list of survey items
    /**
     * @api {get} /surveyitems/ Return the list of all survey items
     * @apiName returnSurveyItems
     * @apiGroup SurveyItem
     *
     * @apiSuccess {SurveyItem[]} surveyItems List of all survey items.
     */
    @GetMapping
    public ResponseEntity<?> returnSurveyItems() {
            return new ResponseEntity<>(__restService.getSurveyItems(), HttpStatus.OK);
    }

    //first endpoint, create a survey item
    /**
     * @api {post} /surveyitems/ Creates a survey item
     * @apiName createSurveyItem
     * @apiGroup SurveyItem
     * @apiParamExample {json} Request-example: 
     *  {
     *      "questionStem": "what is the best number to take on a date",
            "possibleAnswers": ["0", "42", "4", "1"],
            "correctAnswer": "1"
     *  }
     * @apiSuccess (201) 
     */
    @PostMapping
    public ResponseEntity<SurveyItem> createSurveyItem(@RequestBody SurveyItemRequest surveyItemRequest) {
        return new ResponseEntity<>(__restService.createSurveyItem(surveyItemRequest), HttpStatus.CREATED);       
    }
    
    @ExceptionHandler(value = RestInternalException.class)
    public ResponseEntity<?> handleThrowable(RestInternalException exc) {
        return new ResponseEntity<String>(exc.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = java.lang.Throwable.class)
    public ResponseEntity<?> handleThrowable(java.lang.Throwable exc) {
        return new ResponseEntity<String>(exc.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}