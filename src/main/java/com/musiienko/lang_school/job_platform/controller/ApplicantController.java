package com.musiienko.lang_school.job_platform.controller;

import com.musiienko.lang_school.job_platform.dto.JobApplicantDTO;
import com.musiienko.lang_school.job_platform.model.JobApplicant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.musiienko.lang_school.job_platform.service.JobApplicantService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ApplicantController {
    @Autowired
    private JobApplicantService service;
    @PostMapping("/test")
    public ResponseEntity<String> test(){
        //System.out.println("Hello");
        return ResponseEntity.ok("Test passed");
    }


    @PostMapping("/apply")
    public ResponseEntity<?>addJobApplication(@ModelAttribute JobApplicantDTO applicant, @RequestPart MultipartFile coverLetter,
                                              @RequestPart MultipartFile cv, @RequestPart("certificates") MultipartFile[] certificates){
        System.out.println("Hello world!");
        try {
            JobApplicant savedJobApplicant=service.saveJobApplicant(applicant,coverLetter,cv,certificates);


            //System.out.println(savedJobApplicant.toString());
            return new ResponseEntity<>("Erfolgreich", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("problem",HttpStatus.INTERNAL_SERVER_ERROR);
        }


}}
