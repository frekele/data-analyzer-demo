package org.frekele.demo.data.analyzer.service;

import org.frekele.demo.data.analyzer.enums.LayoutMatcherRegexEnum;
import org.frekele.demo.data.analyzer.factory.SaleFactory;
import org.frekele.demo.data.analyzer.model.Sale;
import org.frekele.demo.data.analyzer.model.SaleItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class SaleServiceTest extends BaseServiceTest {

    private SaleService saleService;
    private SaleFactory saleFactory;
    private SaleItemService saleItemService;

    @BeforeEach
    public void setUp() {
        this.saleFactory = mock(SaleFactory.class);
        this.saleItemService = mock(SaleItemService.class);
        this.saleService = new SaleServiceImpl(this.saleFactory, this.saleItemService);
    }

    @Test
    public void buildSaleByMatcherByMatcherWithSuccessTest() {
        Matcher matcher = getMatcherByLayout("003ç10ç[1-22-130]çJulio Cesar", LayoutMatcherRegexEnum.SALE);
        matcher.find();
        when(this.saleFactory.create(any(), any())).thenReturn(mockSaleWithAllFields(BigDecimal.valueOf(1000)));
        when(this.saleItemService.buildItemListBySale(any())).thenReturn(mockSaleItemsWithAllFields());
        assertEquals(mockSaleWithAllFields(BigDecimal.valueOf(2860)).toString(), this.saleService.buildSaleByMatcher(matcher).toString());
    }

    @Test
    public void getSaleMoreExpensiveWithOneSaleWithSuccessTest() {
        List<Sale> saleList = new ArrayList<>();
        saleList.add(mockSaleWithAllFields(BigDecimal.valueOf(2860)));
        assertEquals(BigDecimal.valueOf(2860), this.saleService.getSaleMoreExpensive(saleList).getTotalSalePrice());
    }

    @Test
    public void getSaleMoreExpensiveWithSuccessTest() {
        List<Sale> saleList = new ArrayList<>();
        saleList.add(mockSaleWithAllFields(BigDecimal.valueOf(2860)));
        saleList.add(mockSaleWithAllFields(BigDecimal.valueOf(5000)));
        assertEquals(BigDecimal.valueOf(5000), this.saleService.getSaleMoreExpensive(saleList).getTotalSalePrice());
    }

    private Sale mockSaleWithAllFields(BigDecimal totalSaleValue) {
        Sale sale = new Sale();
        sale.setLayoutId(3L);
        sale.setId(10L);
        sale.setSalesmanName("Julio Cesar");
        sale.setSaleItems(mockSaleItemsWithAllFields());
        sale.setTotalSalePrice(totalSaleValue);
        return sale;
    }

    private List<SaleItem> mockSaleItemsWithAllFields() {
        List<SaleItem> saleItemList = new ArrayList<>();
        SaleItem saleItem = new SaleItem();
        saleItem.setId(1L);
        saleItem.setPrice(BigDecimal.valueOf(130));
        saleItem.setQuantity(22);
        saleItemList.add(saleItem);
        return saleItemList;
    }
}
