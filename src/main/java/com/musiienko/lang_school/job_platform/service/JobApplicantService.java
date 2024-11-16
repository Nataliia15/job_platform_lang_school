package com.musiienko.lang_school.job_platform.service;

import com.musiienko.lang_school.job_platform.dto.JobApplicantDTO;
import com.musiienko.lang_school.job_platform.model.Certificate;
import com.musiienko.lang_school.job_platform.model.JobApplicant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.musiienko.lang_school.job_platform.repo.JobApplicantRepo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class JobApplicantService  {
    @Autowired
    private JobApplicantRepo repo;

    public JobApplicant saveJobApplicant(JobApplicantDTO applicant, MultipartFile coverLetter,
                                         MultipartFile cv, MultipartFile[]certificates) throws IOException {

        List<Certificate>certificateList=new ArrayList<>();


            JobApplicant jobApplicant=new JobApplicant();
            jobApplicant.setSalutation(applicant.getSalutation());
            jobApplicant.setName(applicant.getName());
            jobApplicant.setSurname(applicant.getSurname());
            jobApplicant.setBirthday(applicant.getBirthday());
            jobApplicant.setEmail(applicant.getEmail());
            jobApplicant.setPhonenumber(applicant.getPhonenumber());
            jobApplicant.setPosition(applicant.getPosition());
            jobApplicant.setCoverLetterFileName(coverLetter.getOriginalFilename());
            jobApplicant.setCoverLetterContentType(coverLetter.getContentType());
            jobApplicant.setCoverLetterData(coverLetter.getBytes());
            jobApplicant.setCvFileName(cv.getOriginalFilename());
            jobApplicant.setCvContentType(cv.getContentType());
            jobApplicant.setCvData(cv.getBytes());

        for(MultipartFile oldCert: certificates){
            Certificate newCert=new Certificate();
            newCert.setCertificateFileName(oldCert.getOriginalFilename());
            newCert.setCertificateContentType(oldCert.getContentType());
            newCert.setCertificateData(oldCert.getBytes());
            newCert.setApplicant(jobApplicant);
            certificateList.add(newCert);
        }
        jobApplicant.setCertificates(certificateList);
        System.out.println(jobApplicant.getName());

      return  repo.save(jobApplicant);




    }

}
