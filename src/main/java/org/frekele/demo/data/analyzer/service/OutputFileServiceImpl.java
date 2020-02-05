package org.frekele.demo.data.analyzer.service;

import lombok.extern.slf4j.Slf4j;
import org.frekele.demo.data.analyzer.config.OutputFileConfig;
import org.frekele.demo.data.analyzer.enums.ConfigEnum;
import org.frekele.demo.data.analyzer.exception.DataAnalyzerException;
import org.frekele.demo.data.analyzer.model.Sale;
import org.frekele.demo.data.analyzer.model.Salesman;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

@Slf4j
@Service
class OutputFileServiceImpl implements OutputFileService {

    private OutputFileConfig outputFileConfig;

    public OutputFileServiceImpl(OutputFileConfig outputFileConfig) {
        this.outputFileConfig = outputFileConfig;
    }

    @Override
    public void processSalesReportFile(File sourceFile,
                                       Integer totalCustomers,
                                       Integer totalSalesman,
                                       Sale sale,
                                       Salesman salesman) {
        Path file = Paths.get(
                ConfigEnum.HOME_PATH.getValue()
                        .concat(this.outputFileConfig.getPath())
                        .concat(this.outputFileConfig.getSourceFileNameWithoutExtension(sourceFile))
                        .concat(this.outputFileConfig.getExtension())
        );

        try {
            Files.write(file, Arrays.asList(
                    buildTotalCustomersReportLine(totalCustomers),
                    buildTotalSalesmansReportLine(totalSalesman),
                    buildSalesMoreExpensiveReportLine(sale),
                    buildWorstSalesmanReportLine(salesman)
            ), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            throw new DataAnalyzerException(e);
        }

        sourceFile.delete();
    }

    String buildTotalCustomersReportLine(Integer totalCustomers) {
        return new StringBuilder()
                .append("Total Customers: [")
                .append(totalCustomers)
                .append("]")
                .toString();
    }

    String buildTotalSalesmansReportLine(Integer totalSalesman) {
        return new StringBuilder()
                .append("Total Salesmans: [")
                .append(totalSalesman)
                .append("]")
                .toString();
    }

    String buildSalesMoreExpensiveReportLine(Sale sale) {
        return new StringBuilder()
                .append("Sale most expensive. Sale ID: [")
                .append(sale.getId())
                .append("] Total price of sale: [")
                .append(sale.getTotalSalePrice())
                .append("]")
                .toString();
    }

    String buildWorstSalesmanReportLine(Salesman salesman) {
        return new StringBuilder()
                .append("Worst Salesman : [")
                .append(salesman.getName())
                .append("] with total sales price of: [")
                .append(salesman.getTotalSalesPrice())
                .append("]")
                .toString();
    }
}
