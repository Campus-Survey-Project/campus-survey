package com.example.campus_survey_backend.controller;

import com.example.campus_survey_backend.dto.SurveyDTO;
import com.example.campus_survey_backend.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marks this class as a RESTful Controller
@RequestMapping("/api/surveys") // Base URL for this controller
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    // POST: Create a new survey
    @PostMapping
    public ResponseEntity<?> createSurvey(@RequestBody SurveyDTO surveyDTO) {
        try {
            System.out.println("Received Survey DTO: " + surveyDTO); // Logs the survey DTO
            SurveyDTO savedSurvey = surveyService.createSurvey(surveyDTO);
            return ResponseEntity.ok(savedSurvey);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // GET: Retrieve all surveys
    @GetMapping
    public ResponseEntity<?> getAllSurveys() {
        try {
            List<SurveyDTO> surveys = surveyService.getAllSurveys();
            System.out.println("Surveys retrieved: " + surveys); // Debug logging
            return ResponseEntity.ok(surveys);
        } catch (Exception e) {
            e.printStackTrace(); // Log the full error stack trace
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // GET: Retrieve a survey by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getSurveyById(@PathVariable Long id) {
        try {
            SurveyDTO survey = surveyService.getSurveyById(id);
            System.out.println("Fetched Survey DTO: " + survey); // Log the fetched survey DTO
            return ResponseEntity.ok(survey);
        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace to identify the issue
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // DELETE: Delete a survey by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSurvey(@PathVariable Long id) {
        try {
            System.out.println("Deleting Survey with ID: " + id); // Log the survey ID
            surveyService.deleteSurvey(id);
            return ResponseEntity.ok("Survey with ID " + id + " deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace to identify the issue
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
