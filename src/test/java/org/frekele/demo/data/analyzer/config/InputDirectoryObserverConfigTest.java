package org.frekele.demo.data.analyzer.config;

import org.frekele.demo.data.analyzer.service.SalesReportService;
import org.frekele.demo.data.analyzer.service.validation.ValidateFileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class InputDirectoryObserverConfigTest {

    private InputFileConfig inputFileConfig;
    private ValidateFileService validateFileService;
    private SalesReportService salesReportService;
    private InputDirectoryObserverConfig inputDirectoryObserverConfig;

    @BeforeEach
    public void setUp() {
        this.inputFileConfig = mock(InputFileConfig.class);
        this.validateFileService = mock(ValidateFileService.class);
        this.salesReportService = mock(SalesReportService.class);
        this.inputDirectoryObserverConfig = new InputDirectoryObserverConfig(
                this.inputFileConfig, this.validateFileService, this.salesReportService);
    }

    @Test
    public void initializeMonitorWithSuccessTest() throws Exception {
        //this.inputDirectoryObserverConfig.initializeMonitor();
    }
}