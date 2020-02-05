package org.frekele.demo.data.analyzer.service;

import org.springframework.stereotype.Service;

import java.io.File;

@Service
public interface SalesReportService {

    void processInputFileData(File file);
}
