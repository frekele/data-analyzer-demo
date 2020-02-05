package org.frekele.demo.data.analyzer.listener;

import org.frekele.demo.data.analyzer.service.SalesReportService;
import org.frekele.demo.data.analyzer.service.validation.ValidateFileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class InputFileListenerTest {


    private ValidateFileService validateFileService;
    private SalesReportService salesReportService;
    private InputFileListener inputFileListener;

    @BeforeEach
    public void setUp() {
        this.validateFileService = mock(ValidateFileService.class);
        this.salesReportService = mock(SalesReportService.class);
        this.inputFileListener = new InputFileListener(this.validateFileService, this.salesReportService);
    }

    @Test
    public void onFileCreateWithSuccessTest() {
        when(this.validateFileService.validateFile(any())).thenReturn(Boolean.TRUE);
        this.inputFileListener.onFileCreate(new File(""));
    }

}