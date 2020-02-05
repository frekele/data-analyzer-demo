package org.frekele.demo.data.analyzer.service.validation;

import org.frekele.demo.data.analyzer.config.InputFileConfig;
import org.frekele.demo.data.analyzer.service.BaseServiceTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ValidateFileServiceTest extends BaseServiceTest {

    private ValidateFileService validateFileService;
    private InputFileConfig inputFileConfig;

    @BeforeEach
    public void setUp() {
        this.inputFileConfig = mock(InputFileConfig.class);
        when(this.inputFileConfig.getExtension()).thenReturn("dat");
        this.validateFileService = new ValidateFileServiceImpl(this.inputFileConfig);
    }

    @Test
    public void validateFileWithSuccessTest() {
        assertTrue(this.validateFileService.validateFile(getFileByName("test.dat")));
    }

    @Test
    public void validateFileWithInvalidExtensionTest() {
        assertFalse(this.validateFileService.validateFile(getFileByName("invalid_file.txt")));
    }


}
