package com.example.campus_survey_backend.service;

import com.example.campus_survey_backend.dto.SurveyDTO;
import com.example.campus_survey_backend.entity.Survey;
import com.example.campus_survey_backend.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    // Convert Entity to DTO
    private SurveyDTO convertToDTO(Survey survey) {
        SurveyDTO dto = new SurveyDTO();
        dto.setId(survey.getId());
        dto.setName(survey.getName());
        dto.setAddress(survey.getAddress());
        dto.setCity(survey.getCity());
        dto.setState(survey.getState());
        dto.setZip(survey.getZip());
        dto.setPhone(survey.getPhone());
        dto.setEmail(survey.getEmail());
        dto.setFeedback(survey.getFeedback());
        dto.setVisitDate(survey.getVisitDate());
        dto.setGradMonth(survey.getGradMonth());
        dto.setGradYear(survey.getGradYear());
        dto.setLikedCampus(survey.getLikedCampus());
        dto.setRecommendLevel(survey.getRecommendLevel());
        dto.setInterestedIn(survey.getInterestedIn());
        return dto;
    }

    // Convert DTO to Entity
    private Survey convertToEntity(SurveyDTO dto) {
        Survey survey = new Survey();
        survey.setName(dto.getName());
        survey.setAddress(dto.getAddress());
        survey.setCity(dto.getCity());
        survey.setState(dto.getState());
        survey.setZip(dto.getZip());
        survey.setPhone(dto.getPhone());
        survey.setEmail(dto.getEmail());
        survey.setFeedback(dto.getFeedback());
        survey.setVisitDate(dto.getVisitDate());
        survey.setGradMonth(dto.getGradMonth());
        survey.setGradYear(dto.getGradYear());
        survey.setLikedCampus(dto.getLikedCampus());
        survey.setRecommendLevel(dto.getRecommendLevel());
        survey.setInterestedIn(dto.getInterestedIn());
        return survey;
    }

    // Create a new survey
    public SurveyDTO createSurvey(SurveyDTO surveyDTO) {
        Survey survey = convertToEntity(surveyDTO);
        Survey savedSurvey = surveyRepository.save(survey);
        return convertToDTO(savedSurvey);
    }

    // Retrieve all surveys
    public List<SurveyDTO> getAllSurveys() {
        return surveyRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Retrieve a survey by ID
    public SurveyDTO getSurveyById(Long id) {
        Survey survey = surveyRepository.findById(id).orElseThrow(() -> new RuntimeException("Survey not found with ID: " + id));
        return convertToDTO(survey);
    }

    // Delete a survey by ID
    public void deleteSurvey(Long id) {
        surveyRepository.deleteById(id);
    }
}
