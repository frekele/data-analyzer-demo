package org.frekele.demo.data.analyzer.service;

import org.frekele.demo.data.analyzer.model.Sale;
import org.frekele.demo.data.analyzer.model.Salesman;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public interface OutputFileService {

    void processSalesReportFile(File sourceFile,
                                Integer totalCustomers,
                                Integer totalSalesman,
                                Sale sale,
                                Salesman salesman);
}
