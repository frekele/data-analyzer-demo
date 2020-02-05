package org.frekele.demo.data.analyzer.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest extends BaseModelTest {

    private Sale.SaleBuilder saleBuilder;

    @BeforeEach
    public void setUp() {
        this.saleBuilder = Sale.builder();
    }

    @Test
    public void saleWithAllFieldsWithSuccessTest() {
        Sale sale = saleBuilder
                .layoutId(1L)
                .id(2L)
                .salesmanName("Pedro")
                .saleItems(mockSaleItemsWithAllFields())
                .totalSalePrice(BigDecimal.valueOf(1000))
                .build();
        assertEquals(mockSaleWithAllFields().toString(), sale.toString());
    }

    @Test
    public void saleWithOnlIdFieldWithSuccessTest() {
        Sale sale = saleBuilder
                .id(2L)
                .build();
        assertEquals(mockSaleWithOnlyIdField().toString(), sale.toString());
    }

    private Sale mockSaleWithAllFields() {
        Sale sale = new Sale();
        sale.setLayoutId(1L);
        sale.setId(2L);
        sale.setSalesmanName("Pedro");
        sale.setSaleItems(mockSaleItemsWithAllFields());
        sale.setTotalSalePrice(BigDecimal.valueOf(1000));
        return sale;
    }

    private Sale mockSaleWithOnlyIdField() {
        Sale sale = new Sale();
        sale.setId(2L);
        return sale;
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
