package org.frekele.demo.data.analyzer.service;

import org.frekele.demo.data.analyzer.factory.SaleItemFactory;
import org.frekele.demo.data.analyzer.model.SaleItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class SaleItemServiceTest extends BaseServiceTest {

    private SaleItemService saleItemService;
    private SaleItemFactory saleItemFactory;

    @BeforeEach
    public void setUp() {
        this.saleItemFactory = mock(SaleItemFactory.class);
        this.saleItemService = new SaleItemServiceImpl(this.saleItemFactory);
    }

    @Test
    public void shouldBuildItemListBySaleWithSuccess() {
        String itemSale = "[1-10-100]";
        when(this.saleItemFactory.create(any())).thenReturn(mockSaleItemWithAllFields());
        assertEquals(mockSaleItemsWithAllFields().toString(), this.saleItemService.buildItemListBySale(itemSale).toString());

    }

    private SaleItem mockSaleItemWithAllFields() {
        SaleItem saleItem = new SaleItem();
        saleItem.setId(1L);
        saleItem.setPrice(BigDecimal.valueOf(100));
        saleItem.setQuantity(10);
        return saleItem;
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
}
