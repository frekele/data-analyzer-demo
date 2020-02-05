package org.frekele.demo.data.analyzer.service;

import org.frekele.demo.data.analyzer.factory.SalesmanFactory;
import org.frekele.demo.data.analyzer.model.Sale;
import org.frekele.demo.data.analyzer.model.SaleItem;
import org.frekele.demo.data.analyzer.model.Salesman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class SalesmanServiceTest extends BaseServiceTest {

    private SalesmanService salesmanService;
    private SalesmanFactory salesmanFactory;

    @BeforeEach
    public void setUp() {
        this.salesmanFactory = mock(SalesmanFactory.class);
        this.salesmanService = new SalesmanServiceImpl(this.salesmanFactory);
    }

    @Test
    public void buildSalesmanByMatcherWithSuccessTest() {
        when(this.salesmanFactory.create(any())).thenReturn(mockSalesmanWithAllFields(BigDecimal.ZERO, null));
        assertEquals(mockSalesmanWithAllFields(BigDecimal.ZERO, null).toString(), this.salesmanService.buildSalesmanByMatcher(any()).toString());
    }

    @Test
    public void setSalesmanSalesWithSuccessTest() {
        List<Salesman> salesmanList = new ArrayList<>();
        List<Sale> saleList = new ArrayList<>();
        saleList.add(mockSaleWithAllFields(1L, BigDecimal.valueOf(1000)));
        saleList.add(mockSaleWithAllFields(2L, BigDecimal.valueOf(5000)));
        salesmanList.add(mockSalesmanWithAllFields(BigDecimal.valueOf(6000), saleList));
        assertEquals(salesmanList.toString(), this.salesmanService.setSalesmanSales(salesmanList, saleList).toString());
    }

    @Test
    public void getTotalSalesmanWithSuccessTest() {
        List<Salesman> salesmanList = new ArrayList<>();
        salesmanList.add(mockSalesmanWithAllFields(BigDecimal.valueOf(6000), null));
        salesmanList.add(mockSalesmanWithAllFields(BigDecimal.valueOf(6000), null));
        assertEquals(Integer.valueOf(2), this.salesmanService.getTotalSalesman(salesmanList));
    }

    @Test
    public void getWorstSalesmanWithSuccessTest() {
        List<Salesman> salesmanList = new ArrayList<>();
        salesmanList.add(mockSalesmanWithAllFields(BigDecimal.valueOf(6000), null));
        salesmanList.add(mockSalesmanWithAllFields(BigDecimal.valueOf(4000), null));
        assertEquals(mockSalesmanWithAllFields(BigDecimal.valueOf(4000), null).toString(), this.salesmanService.getWorstSalesman(salesmanList).toString());
    }

    private Salesman mockSalesmanWithAllFields(BigDecimal totalSalesValue, List<Sale> saleList) {
        Salesman salesman = new Salesman();
        salesman.setLayoutId(001L);
        salesman.setCpf("1234567891234");
        salesman.setName("Pedro");
        salesman.setSalary(BigDecimal.valueOf(50000));
        salesman.setSales(saleList);
        salesman.setTotalSalesPrice(totalSalesValue);
        return salesman;
    }

    private Sale mockSaleWithAllFields(Long code, BigDecimal TotalSale) {
        Sale sale = new Sale();
        sale.setLayoutId(3L);
        sale.setId(code);
        sale.setSalesmanName("Pedro");
        sale.setSaleItems(mockSaleItemListWithAllFields());
        sale.setTotalSalePrice(TotalSale);
        return sale;
    }

    private List<SaleItem> mockSaleItemListWithAllFields() {
        List<SaleItem> saleItemList = new ArrayList<>();
        SaleItem saleItem = new SaleItem();
        saleItem.setId(1L);
        saleItem.setPrice(BigDecimal.valueOf(100));
        saleItem.setQuantity(10);
        saleItemList.add(saleItem);
        return saleItemList;
    }
}
