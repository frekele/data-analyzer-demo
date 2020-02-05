package org.frekele.demo.data.analyzer.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SalesmanTest extends BaseModelTest {

    private Salesman.SalesmanBuilder salesmanBuilder;

    @BeforeEach
    public void setUp() {
        this.salesmanBuilder = Salesman.builder();
    }

    @Test
    public void salesmanWithAllFieldsWithSuccessTest() {
        Salesman salesman = salesmanBuilder
                .layoutId(1L)
                .cpf("63772221300")
                .name("Pedro")
                .salary(BigDecimal.valueOf(4000))
                .sales(mockSalesWithAllFields())
                .totalSalesPrice(BigDecimal.valueOf(5000))
                .build();
        assertEquals(mockSalesmanWithAllFields().toString(), salesman.toString());
    }

    @Test
    public void salesmanWithOnlyCpfFieldWithSuccessTest() {
        Salesman salesman = salesmanBuilder
                .cpf("63772221300")
                .build();
        assertEquals(mockSalesmanWithOnlyCpfField().toString(), salesman.toString());
    }

    private Salesman mockSalesmanWithAllFields() {
        Salesman salesman = new Salesman();
        salesman.setLayoutId(1L);
        salesman.setCpf("63772221300");
        salesman.setName("Pedro");
        salesman.setSalary(BigDecimal.valueOf(4000));
        salesman.setSales(mockSalesWithAllFields());
        salesman.setTotalSalesPrice(BigDecimal.valueOf(5000));
        return salesman;
    }

    private Salesman mockSalesmanWithOnlyCpfField() {
        Salesman salesman = new Salesman();
        salesman.setCpf("63772221300");
        return salesman;
    }

    private List<Sale> mockSalesWithAllFields() {
        List<Sale> saleList = new ArrayList<>();
        Sale sale = new Sale();
        sale.setLayoutId(1L);
        sale.setId(2L);
        sale.setSalesmanName("Pedro");
        sale.setSaleItems(mockSaleItemsWithAllFields());
        sale.setTotalSalePrice(BigDecimal.valueOf(1000));
        saleList.add(sale);
        return saleList;
    }

    private List<SaleItem> mockSaleItemsWithAllFields() {
        List<SaleItem> saleItemList = new ArrayList<>();
        SaleItem saleItem = new SaleItem();
        saleItem.setId(1L);
        saleItem.setPrice(BigDecimal.valueOf(2.22));
        saleItem.setQuantity(10);
        saleItemList.add(saleItem);
        return saleItemList;
    }
}
