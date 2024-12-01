package com.example.campus_survey_backend.controller;

import com.example.campus_survey_backend.entity.Survey;
import com.example.campus_survey_backend.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marks this class as a RESTful Controller
@RequestMapping("/api/surveys") // Base URL for this controller
public class SurveyController {

    @Autowired
    private SurveyRepository surveyRepository;

    // GET: Retrieve all surveys
    @GetMapping
    public ResponseEntity<List<Survey>> getAllSurveys() {
        List<Survey> surveys = surveyRepository.findAll();
        return ResponseEntity.ok(surveys);
    }

    // POST: Create a new survey
    @PostMapping
    public ResponseEntity<Survey> createSurvey(@RequestBody Survey survey) {
        Survey savedSurvey = surveyRepository.save(survey);
        return new ResponseEntity<>(savedSurvey, HttpStatus.CREATED);
    }

    // DELETE: Delete a survey by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSurvey(@PathVariable Long id) {
        surveyRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
