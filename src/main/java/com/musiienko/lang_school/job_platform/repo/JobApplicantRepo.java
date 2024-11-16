package com.musiienko.lang_school.job_platform.repo;

import com.musiienko.lang_school.job_platform.model.JobApplicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplicantRepo extends JpaRepository<JobApplicant,Integer> {
}
