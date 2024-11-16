package com.musiienko.lang_school.job_platform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;


import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JobApplicant {
    @Id
    @GeneratedValue
    private Integer id;
    private String salutation;
    private String name;
    private String surname;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String email;
    private String phonenumber;
    private String position;

    private String coverLetterFileName;
    private String coverLetterContentType;
    @Lob
    private byte[] coverLetterData;

    private String cvFileName;
    private String cvContentType;
    @Lob
    private byte[] cvData;
    @OneToMany(mappedBy = "applicant",cascade = CascadeType.ALL)
    private List<Certificate> certificates;



}