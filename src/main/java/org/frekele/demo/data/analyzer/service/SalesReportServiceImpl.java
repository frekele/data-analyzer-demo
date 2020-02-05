package org.frekele.demo.data.analyzer.service;

import lombok.extern.slf4j.Slf4j;
import org.frekele.demo.data.analyzer.enums.LayoutMatcherRegexEnum;
import org.frekele.demo.data.analyzer.model.Customer;
import org.frekele.demo.data.analyzer.model.Sale;
import org.frekele.demo.data.analyzer.model.Salesman;
import org.frekele.demo.data.analyzer.service.validation.LayoutValidation;
import org.frekele.demo.data.analyzer.service.validation.LayoutValidationImpl;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.stream.Stream;

@Slf4j
@Service
class SalesReportServiceImpl implements SalesReportService {

    private CustomerService customerService;
    private SaleService saleService;
    private SalesmanService salesmanService;
    private OutputFileService outputFileService;

    private List<Salesman> salesmanList;
    private List<Customer> customerList;
    private List<Sale> saleList;

    public SalesReportServiceImpl(CustomerService customerService,
                                  SaleService saleService,
                                  SalesmanService salesmanService,
                                  OutputFileService outputFileService) {
        this.customerService = customerService;
        this.saleService = saleService;
        this.salesmanService = salesmanService;
        this.outputFileService = outputFileService;
    }

    @Override
    public void processInputFileData(File file) {
        try {
            this.salesmanList = new ArrayList<>();
            this.customerList = new ArrayList<>();
            this.saleList = new ArrayList<>();

            Stream<String> stream = Files.lines(Paths.get(file.getAbsolutePath()));

            stream.forEach(line -> {
                LayoutValidation layoutValidation = new LayoutValidationImpl(line);
                if (layoutValidation.checkLayout(LayoutMatcherRegexEnum.SALESMAN)) {
                    fetchSalesmanList(layoutValidation.getMatcherResult());
                } else if (layoutValidation.checkLayout(LayoutMatcherRegexEnum.CUSTOMER)) {
                    fetchCustomerList(layoutValidation.getMatcherResult());
                } else if (layoutValidation.checkLayout(LayoutMatcherRegexEnum.SALE)) {
                    fetchSaleList(layoutValidation.getMatcherResult());
                }
            });

            if (Stream.of(this.salesmanList, this.customerList, this.saleList).allMatch(List::isEmpty))
                throw new Exception("File cannot be processed,!");

            this.salesmanList = this.salesmanService.setSalesmanSales(this.salesmanList, this.saleList);

            this.outputFileService.processSalesReportFile(
                    file,
                    this.customerService.getTotalCustomer(this.customerList),
                    this.salesmanService.getTotalSalesman(this.salesmanList),
                    this.saleService.getSaleMoreExpensive(this.saleList),
                    this.salesmanService.getWorstSalesman(this.salesmanList)
            );
            log.info("########## File [" + file.getName() + "] processed with success! ##########");
        } catch (Exception ex) {
            log.error("Error to process file, please verify file content and try again. File: ["
                    .concat(file.getAbsolutePath())
                    .concat("] Error Message: [")
                    .concat(ex.getMessage())
                    .concat("]")
            );
        }
    }

    private void fetchSalesmanList(Matcher matcher) {
        this.salesmanList.add(this.salesmanService.buildSalesmanByMatcher(matcher));
    }

    private void fetchCustomerList(Matcher matcher) {
        this.customerList.add(this.customerService.buildCustomerByMatcher(matcher));
    }

    private void fetchSaleList(Matcher matcher) {
        this.saleList.add(this.saleService.buildSaleByMatcher(matcher));
    }

}
