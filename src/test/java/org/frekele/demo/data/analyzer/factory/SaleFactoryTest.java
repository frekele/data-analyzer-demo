package org.frekele.demo.data.analyzer.factory;

import org.frekele.demo.data.analyzer.enums.LayoutMatcherRegexEnum;
import org.frekele.demo.data.analyzer.model.Sale;
import org.frekele.demo.data.analyzer.model.SaleItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.*;

public class SaleFactoryTest extends BaseFactoryTest {

    private SaleFactory saleFactory;

    @BeforeEach
    public void setUp() {
        this.saleFactory = new SaleFactoryImpl();
    }

    @Test
    public void createSaleFactoryWithSuccessTest() {
        String line = "003ç10ç[1-10-100]çPedro";
        Matcher matcher = getMatcherByLayout(line, LayoutMatcherRegexEnum.SALE);
        matcher.find();
        Sale sale = saleFactory.create(matcher, mockItemListWithAllFields());
        assertEquals(mockSaleWithAllFields().toString(), sale.toString());

    }

    private Sale mockSaleWithAllFields() {
        Sale sale = new Sale();
        sale.setLayoutId(003L);
        sale.setId(10L);
        sale.setSalesmanName("Pedro");
        sale.setSaleItems(mockItemListWithAllFields());
        sale.setTotalSalePrice(BigDecimal.ZERO);
        return sale;
    }

    private List<SaleItem> mockItemListWithAllFields() {
        List<SaleItem> saleItemList = new ArrayList<>();
        SaleItem saleItem = new SaleItem();
        saleItem.setId(1L);
        saleItem.setPrice(BigDecimal.valueOf(100));
        saleItem.setQuantity(10);
        saleItemList.add(saleItem);
        return saleItemList;
    }
}
