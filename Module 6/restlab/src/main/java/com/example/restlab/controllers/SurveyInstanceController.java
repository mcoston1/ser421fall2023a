package com.example.restlab.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restlab.model.SurveyInstance;
import com.example.restlab.model.SurveyItemInstance;
import com.example.restlab.model.exceptions.RestInternalException;
import com.example.restlab.model.exceptions.SurveyNotFoundException;
import com.example.restlab.modelhelpers.SurveyInstanceRequest;
import com.example.restlab.modelhelpers.SurveyItemAnswerRequest;
import com.example.restlab.services.RestService;

@RequestMapping("/survey/instances")
@RestController
public class SurveyInstanceController {
    
    private RestService __restService = RestService.getInstance();

   //first endpoint, return set of survey instances in a given state. if no state, return all
    /**
     * @api {get} /survey/instances/state/:surveyInState Request all survey instances in a specific state
     * @apiName returnSurveyState
     * @apiGroup SurveyInstance
     *
     * @apiParam {String} surveyInState State of surveys you want to search by
     *
     * @apiSuccess {SurveyInstance[]} surveyInstance List of survey instances
     */
    @GetMapping("/state/{surveyInState}")
    public ResponseEntity<?> returnSurveysInState(@PathVariable String surveyInState) {    
        return new ResponseEntity<>(__restService.getSurveyInstancesByState(surveyInState), HttpStatus.OK);    
    }

    /**
     * @api {get} /survey/instances/state/ Returns survey instances in any state
     * @apiName returnSurveyNoState
     * @apiGroup SurveyInstance
     *
     * @apiSuccess {SurveyInstance[]} surveyInstance List of survey instances
     */

    @GetMapping("/state/")
    public ResponseEntity<?> returnSurveysNoState() {
        return new ResponseEntity<>(__restService.getSurveyInstances(), HttpStatus.OK);
    }

    /**
     * @api {get} /survey/instances Returns allsurvey instances
     * @apiName returnSurveyInstances
     * @apiGroup SurveyInstance
     *
     * @apiSuccess {SurveyInstance[]} surveyInstance List of survey instances
     */
    @GetMapping
    public ResponseEntity<?> returnSurveyInstances() {
        return new ResponseEntity<>(__restService.getSurveyInstances(), HttpStatus.OK);
    }


    /**
     * @api {get} /survey/instances/users/:user/:id Gets a specific survey instance
     * @apiName getSpecificSurveyInstance
     * @apiGroup SurveyInstance
     *
     * @apiSuccess {SurveyInstance} surveyInstance Returns a specific survey instance
     */
    @GetMapping("/users/{user}/{id}")
    public ResponseEntity<?> getSpecificSurveyInstance(@PathVariable String user, @PathVariable int id) {
        return new ResponseEntity<>(__restService.getSpecificSurveyInstance(user, id), HttpStatus.OK);
    }


    /**
     * @api {post} /survey/instances Creates a survey instance
     * @apiName createSurveyInstance
     * @apiGroup SurveyInstance
     *
     * @apiSuccess (201) {SurveyInstance} surveyInstance Newly created survey instance
     */
    @PostMapping
    public ResponseEntity<SurveyInstance> createSurveyInstance(@RequestBody SurveyInstanceRequest surveyInstanceRequest) {
        return new ResponseEntity<>(__restService.createSurveyInstance(surveyInstanceRequest.getSurveyId(), surveyInstanceRequest.getUser(), __restService.getSurvey(surveyInstanceRequest.getSurveyId()).getSurveyItems()), HttpStatus.CREATED);
    }


    /**
     * @api {put} /survey/instances/users/:user Adds an answer to a survey item instance
     * @apiName answerSurveyItem
     * @apiGroup SurveyInstance
     *
     * @apiParamExample {json} Request-example: 
     *  {
            "surveyId":0,
            "surveyItemId":0,
            "answer": "42"
        }
     * @apiSuccess {SurveyInstance} surveyInstance Survey instance with added answer
     */
    @PutMapping("/users/{user}")
    public ResponseEntity<SurveyItemInstance> answerSurveyItem(@PathVariable String user, @RequestBody SurveyItemAnswerRequest surveyItemAnswerRequest) {
        return new ResponseEntity<>(__restService.addSurveyAnswer(user, surveyItemAnswerRequest.getSurveyId(), surveyItemAnswerRequest.getSurveyItemId(), surveyItemAnswerRequest.getAnswer()), HttpStatus.OK);
    }

    @ExceptionHandler(value = org.springframework.web.method.annotation.MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleTypeMismatchException(org.springframework.web.method.annotation.MethodArgumentTypeMismatchException exc) {
        return new ResponseEntity<String>("Invalid type for id, must be an integer", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = RestInternalException.class)
    public ResponseEntity<?> handleThrowable(RestInternalException exc) {
        return new ResponseEntity<String>(exc.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = java.lang.Throwable.class)
    public ResponseEntity<?> handleThrowable(java.lang.Throwable exc) {
        return new ResponseEntity<String>(exc.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = SurveyNotFoundException.class)
    public ResponseEntity<?> handleThrowable(SurveyNotFoundException exc) {
        return new ResponseEntity<String>(exc.getMessage(), HttpStatus.NOT_FOUND);
    }
}