package org.frekele.demo.data.analyzer.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.frekele.demo.data.analyzer.enums.ConfigEnum;
import org.frekele.demo.data.analyzer.listener.InputFileListener;
import org.frekele.demo.data.analyzer.service.SalesReportService;
import org.frekele.demo.data.analyzer.service.validation.ValidateFileService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Slf4j
@Configuration
public class InputDirectoryObserverConfig {

    private InputFileConfig inputFileConfig;
    private ValidateFileService validateFileService;
    private SalesReportService salesReportService;


    public InputDirectoryObserverConfig(InputFileConfig inputFileConfig,
                                        ValidateFileService validateFileService,
                                        SalesReportService salesReportService) {
        this.inputFileConfig = inputFileConfig;
        this.validateFileService = validateFileService;
        this.salesReportService = salesReportService;
    }

    @Bean
    public void initializeMonitor() throws Exception {
        final File directory = new File(ConfigEnum.HOME_PATH.getValue().concat(this.inputFileConfig.getPath()));
        final FileAlterationObserver fileAlterationObserver = new FileAlterationObserver(directory);
        fileAlterationObserver.addListener(new InputFileListener(this.validateFileService, this.salesReportService));
        final FileAlterationMonitor monitor = new FileAlterationMonitor(this.inputFileConfig.getObserverInterval());
        monitor.addObserver(fileAlterationObserver);
        monitor.start();
    }
}
