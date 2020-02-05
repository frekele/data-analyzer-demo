package org.frekele.demo.data.analyzer.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.frekele.demo.data.analyzer.service.SalesReportService;
import org.frekele.demo.data.analyzer.service.validation.ValidateFileService;

import java.io.File;
import java.util.Arrays;

@Slf4j
public final class InputFileListener implements FileAlterationListener {

    private ValidateFileService validateFileService;
    private SalesReportService salesReportService;

    public InputFileListener(ValidateFileService validateFileService, SalesReportService salesReportService) {
        this.validateFileService = validateFileService;
        this.salesReportService = salesReportService;
    }

    @Override
    public void onStart(FileAlterationObserver fileAlterationObserver) {
        File directory = fileAlterationObserver.getDirectory();
        if (!directory.exists()) {
            log.warn(directory.getAbsolutePath() + " Input directory does not exist!");
            if (directory.mkdirs()) {
                log.warn("Directory structure " + directory.getAbsolutePath() + " created successfully.!");
            } else {
                log.warn("Create the directory structure manually: " + directory.getAbsolutePath());
            }
        }
        File[] files = directory.listFiles();
        Arrays.stream(files != null ? files : new File[0]).forEach(this::onFileCreate);
    }

    @Override
    public void onDirectoryCreate(File directory) {
    }

    @Override
    public void onDirectoryChange(File directory) {
    }

    @Override
    public void onDirectoryDelete(File directory) {
    }

    @Override
    public void onFileCreate(final File file) {
        if (this.validateFileService.validateFile(file)) {
            this.salesReportService.processInputFileData(file);
        }
    }

    @Override
    public void onFileChange(File file) {
    }

    @Override
    public void onFileDelete(File file) {
    }

    @Override
    public void onStop(FileAlterationObserver observer) {
    }
}