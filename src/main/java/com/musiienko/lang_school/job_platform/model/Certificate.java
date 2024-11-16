package com.musiienko.lang_school.job_platform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Certificate {
    @Id
    @GeneratedValue
    private Integer id;
    private String certificateFileName;
    private String certificateContentType;
    @Lob
    private byte[] certificateData;
    @ManyToOne
    @JoinColumn(name="job_applicant_id")
    private JobApplicant applicant;
}
