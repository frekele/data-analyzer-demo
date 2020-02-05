package org.frekele.demo.data.analyzer.service.validation;

import org.springframework.stereotype.Service;

import java.io.File;

@Service
public interface ValidateFileService {

    boolean validateFile(File file);
}
