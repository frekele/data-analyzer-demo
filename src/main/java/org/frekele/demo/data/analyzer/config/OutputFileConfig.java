package org.frekele.demo.data.analyzer.config;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Slf4j
@Getter
@Configuration
public class OutputFileConfig {

    @Value("${file.data.out.path}")
    private String path;

    @Value("${file.data.out.extension}")
    private String extension;

    public String getSourceFileNameWithoutExtension(File file) {
        return FilenameUtils.removeExtension(file.getName());
    }
}
