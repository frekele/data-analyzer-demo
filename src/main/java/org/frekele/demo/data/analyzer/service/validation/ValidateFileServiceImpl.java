package org.frekele.demo.data.analyzer.service.validation;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.frekele.demo.data.analyzer.config.InputFileConfig;
import org.springframework.stereotype.Service;

import java.io.File;

@Slf4j
@Service
class ValidateFileServiceImpl implements ValidateFileService {

    private InputFileConfig inputFileConfig;

    public ValidateFileServiceImpl(InputFileConfig inputFileConfig) {
        this.inputFileConfig = inputFileConfig;
    }

    @Override
    public boolean validateFile(File file) {
        if (!isFileExtensionAcceptable(file)) {
            log.warn(file.getAbsoluteFile() + " have a invalid extension.");
            return false;
        }

        if (!isFileReadable(file)) {
            log.warn(file.getAbsoluteFile() + " isn't readable.");
            return false;
        }
        return true;
    }

    private boolean isFileExtensionAcceptable(File file) {
        return this.inputFileConfig.getExtension().equals(FilenameUtils.getExtension(file.getName()));
    }

    private boolean isFileReadable(File file) {
        return file.canRead();
    }
}
