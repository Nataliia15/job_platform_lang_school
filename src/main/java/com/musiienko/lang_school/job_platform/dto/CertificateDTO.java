package com.musiienko.lang_school.job_platform.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Data
public class CertificateDTO {
    private List<MultipartFile>certificatesDto;
}
