package org.frekele.demo.data.analyzer.service;

import org.frekele.demo.data.analyzer.config.OutputFileConfig;
import org.frekele.demo.data.analyzer.factory.CustomerFactory;
import org.frekele.demo.data.analyzer.model.Sale;
import org.frekele.demo.data.analyzer.model.Salesman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class OutputFileServiceImplTest extends BaseServiceTest {

    private OutputFileConfig outputFileConfig;
    private OutputFileServiceImpl outputFileService;

    @BeforeEach
    public void setUp() {
        this.outputFileConfig = mock(OutputFileConfig.class);
        this.outputFileService = new OutputFileServiceImpl(this.outputFileConfig);
    }


    @Test
    void processSalesReportFile() {
        //this.outputFileService.processSalesReportFile();
    }

    @Test
    void buildTotalCustomersReportLine() {
        this.outputFileService.buildTotalCustomersReportLine(4);
    }

    @Test
    void buildTotalSalesmansReportLine() {
        this.outputFileService.buildTotalSalesmansReportLine(6);
    }

    @Test
    void buildSalesMoreExpensiveReportLine() {
        Sale sale = new Sale();
        sale.setId(2L);
        sale.setTotalSalePrice(BigDecimal.valueOf(3003.44));
        this.outputFileService.buildSalesMoreExpensiveReportLine(sale);
    }

    @Test
    void buildWorstSalesmanReportLine() {
        Salesman salesman = new Salesman();
        salesman.setName("Joao da Silva");
        salesman.setTotalSalesPrice(BigDecimal.valueOf(4355.88));
        this.outputFileService.buildWorstSalesmanReportLine(salesman);
    }
}