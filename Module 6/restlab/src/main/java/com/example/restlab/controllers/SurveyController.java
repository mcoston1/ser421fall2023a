package com.example.restlab.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restlab.model.Survey;
import com.example.restlab.model.Survey.SurveyState;
import com.example.restlab.model.exceptions.RestInternalException;
import com.example.restlab.model.exceptions.SurveyNotFoundException;
import com.example.restlab.modelhelpers.SurveyItemRequest;
import com.example.restlab.modelhelpers.SurveyRequest;
import com.example.restlab.services.RestService;

@RequestMapping("/surveys")
@RestController
public class SurveyController {

    private RestService __restService = RestService.getInstance();

    //first endpoint, return a collection of surveys
    /**
     * @api {get} /surveys Request all surveys
     * @apiName returnSurveys
     * @apiGroup Survey
     * @apiSuccess {Survey[]} List of all surveys.
     */
    @GetMapping
    public ResponseEntity<?> returnSurveys() throws Throwable {
        return new ResponseEntity<>(__restService.getSurveys(), HttpStatus.OK);        
    }

    //second endpoint, return a specific survey by id
    /**
     * @api {get} /surveys/:id Return a specific survey by id
     * @apiName returnSurvey
     * @apiGroup Survey
     *
     * @apiParam {Number} id Surveys unique id
     *
     * @apiSuccess {Survey} Survey with matching Id
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> returnSurvey(@PathVariable Integer id) {
        return new ResponseEntity<>(__restService.getSurvey(id), HttpStatus.OK);        
    }

    //third endpoint, create survey via POST
    /**
     * @api {post} /surveys
     * @apiName createSurvey
     * @apiGroup Survey
     * @apiParamExample {json} Request-example: 
     *  {
     *      "surveyItems": []
     *  }
     * @apiSuccess {Survey}  survey Survey you created
     */
    @PostMapping
    public ResponseEntity<Survey> createSurvey(@RequestBody SurveyRequest surveyRequest) {
        return new ResponseEntity<>(__restService.createSurvey(surveyRequest.getSurveyItems(), SurveyState.CREATED), HttpStatus.CREATED);
    }

    //fourth endpoint, add a survey item to a survey via PUT
    /**
     * @api {put} /surveys/:id Request User information
     * @apiName insertSurveyItem
     * @apiGroup Survey
     *
     * @apiParam {Number} id Id of survey you wish to add an item to
     * @apiParamExample {json} Request-example: 
     *  {
     *      "questionStem": "what is the best number to take on a date",
            "possibleAnswers": ["0", "42", "4", "1"],
            "correctAnswer": "1"
    *  }
    *
    * @apiSuccess {SurveyItem} surveyItem Newly created survey item
    */
    @PutMapping("/{id}")
    public ResponseEntity<Survey> insertSurveyItem(@PathVariable Integer id, @RequestBody SurveyItemRequest surveyItemRequest) {
        return new ResponseEntity<>(__restService.addSurveyItem(id, surveyItemRequest), HttpStatus.OK);
    }

    //fifth endpoint, delete a survey via DELETE (though really just mark as deleted)
    /**
     * @api {delete} /surveys/:id Delete a specific survey instance
     * @apiName deleteSurvey
     * @apiGroup Survey
     *
     * @apiParam {Number} id Surveys unique Id.
     *
     * @apiSuccess (204)
     */
    @DeleteMapping("/{id}") 
    public ResponseEntity<String> deleteSurvey(@PathVariable Integer id) {  
        if(__restService.deleteSurvey(id)) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
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
