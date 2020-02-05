package org.frekele.demo.data.analyzer.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SaleItemTest extends BaseModelTest {

    private SaleItem.SaleItemBuilder saleItemBuilder;

    @BeforeEach
    public void setUp() {
        this.saleItemBuilder = SaleItem.builder();
    }

    @Test
    public void saleItemWithAllFieldsWithSuccessTest() {
        SaleItem saleItem = saleItemBuilder
                .id(1L)
                .price(BigDecimal.valueOf(2.22))
                .quantity(10)
                .build();
        assertEquals(mockSaleItemWithAllFields().toString(), saleItem.toString());
    }


    @Test
    public void saleItemFromWithOnlyPriceFieldWithSuccessTest() {
        SaleItem saleItem = saleItemBuilder
                .price(BigDecimal.valueOf(2.22))
                .build();
        assertEquals(mockSaleItemWithOnlyPriceField().toString(), saleItem.toString());
    }

    private SaleItem mockSaleItemWithAllFields() {
        SaleItem saleItem = new SaleItem();
        saleItem.setId(1L);
        saleItem.setPrice(BigDecimal.valueOf(2.22));
        saleItem.setQuantity(10);
        return saleItem;
    }

    private SaleItem mockSaleItemWithOnlyPriceField() {
        SaleItem saleItem = new SaleItem();
        saleItem.setPrice(BigDecimal.valueOf(2.22));
        return saleItem;
    }
}
