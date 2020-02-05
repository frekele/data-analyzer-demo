package org.frekele.demo.data.analyzer.service;

import org.frekele.demo.data.analyzer.model.Customer;
import org.frekele.demo.data.analyzer.model.Sale;
import org.frekele.demo.data.analyzer.model.SaleItem;
import org.frekele.demo.data.analyzer.model.Salesman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class SalesReportServiceTest extends BaseServiceTest {

    private SalesReportService salesReportService;
    private CustomerService customerService;
    private SaleService saleService;
    private SalesmanService salesmanService;
    private OutputFileService outputFileService;

    @BeforeEach
    public void setUp() {
        this.customerService = mock(CustomerService.class);
        this.saleService = mock(SaleService.class);
        this.salesmanService = mock(SalesmanService.class);
        this.outputFileService = mock(OutputFileService.class);
        this.salesReportService = new SalesReportServiceImpl(this.customerService, this.saleService, this.salesmanService, this.outputFileService);
    }

    @Test
    public void processInputFileDataWithSuccessTest() throws Exception {
        when(this.customerService.buildCustomerByMatcher(any())).thenReturn(mockCustomerWithAllFields());
        when(this.saleService.buildSaleByMatcher(any())).thenReturn(mockSaleWithAllFields());
        when(this.salesmanService.buildSalesmanByMatcher(any())).thenReturn(mockSalesmanWithAllFields(mockSalesWithAllFields()));
        when(this.salesmanService.setSalesmanSales(any(), any())).thenReturn(mockSalesmanList());
        when(this.customerService.getTotalCustomer(any())).thenReturn(1);
        when(this.salesmanService.getTotalSalesman(any())).thenReturn(1);
        when(this.saleService.getSaleMoreExpensive(any())).thenReturn(mockSaleWithAllFields());
        when(this.salesmanService.getWorstSalesman(any())).thenReturn(mockSalesmanWithAllFields(mockSalesWithAllFields()));
        doNothing().when(this.outputFileService).processSalesReportFile(any(), any(), any(), any(), any());
        salesReportService.processInputFileData(getFileByName("test.dat"));
    }

    @Test
    public void processInputFileDataWithInvalidFileTest() {
        this.salesReportService.processInputFileData(getFileByName("invalid_file.dat"));
    }

    private Salesman mockSalesmanWithAllFields(List<Sale> saleList) {
        Salesman salesman = new Salesman();
        salesman.setLayoutId(1L);
        salesman.setCpf("1234567891234");
        salesman.setName("Pedro");
        salesman.setSalary(BigDecimal.valueOf(50000));
        salesman.setSales(saleList);
        salesman.setTotalSalesPrice(BigDecimal.ZERO);
        return salesman;
    }

    private Sale mockSaleWithAllFields() {
        Sale sale = new Sale();
        sale.setLayoutId(3L);
        sale.setId(10L);
        sale.setSalesmanName("Pedro");
        sale.setSaleItems(mockSaleItemsWithAllFields());
        sale.setTotalSalePrice(BigDecimal.ZERO);
        return sale;
    }

    private List<SaleItem> mockSaleItemsWithAllFields() {
        List<SaleItem> saleItemList = new ArrayList<>();
        SaleItem saleItem = new SaleItem();
        saleItem.setId(1L);
        saleItem.setPrice(BigDecimal.valueOf(100));
        saleItem.setQuantity(10);
        saleItemList.add(saleItem);
        return saleItemList;
    }

    private Customer mockCustomerWithAllFields() {
        Customer customer = new Customer();
        customer.setLayoutId(2L);
        customer.setCnpj("2345675434544345");
        customer.setName("Jose da Silva");
        customer.setBusinessArea("Rural");
        return customer;
    }

    private List<Salesman> mockSalesmanList() {
        List<Salesman> salesmanList = new ArrayList<>();
        salesmanList.add(mockSalesmanWithAllFields(mockSalesWithAllFields()));
        return salesmanList;
    }

    private List<Sale> mockSalesWithAllFields() {
        List<Sale> saleList = new ArrayList<>();
        saleList.add(mockSaleWithAllFields());
        return saleList;
    }

}
