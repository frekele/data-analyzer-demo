package org.frekele.demo.data.analyzer.config;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Getter
@Configuration
public class InputFileConfig {

    @Value("${file.data.in.path}")
    private String path;

    @Value("${file.data.in.extension}")
    private String extension;

    @Value("${file.data.in.observer.interval}")
    private Integer observerInterval;

}
