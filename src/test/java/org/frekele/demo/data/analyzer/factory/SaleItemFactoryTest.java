package org.frekele.demo.data.analyzer.factory;

import org.frekele.demo.data.analyzer.enums.LayoutMatcherRegexEnum;
import org.frekele.demo.data.analyzer.model.SaleItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.*;

public class SaleItemFactoryTest extends BaseFactoryTest {

    private SaleItemFactory saleItemFactory;

    @BeforeEach
    public void setUp() {
        this.saleItemFactory = new SaleItemFactoryImpl();
    }

    @Test
    public void createSaleItemFactoryWithSuccessTest() {
        String line = "[1-10-100]";
        Matcher matcher = getMatcherByLayout(line, LayoutMatcherRegexEnum.SALE_ITEM);
        matcher.find();
        SaleItem saleItem = saleItemFactory.create(matcher);
        assertEquals(mockSaleItemWithAllFields().toString(), saleItem.toString());
    }

    private SaleItem mockSaleItemWithAllFields() {
        SaleItem saleItem = new SaleItem();
        saleItem.setId(1L);
        saleItem.setPrice(BigDecimal.valueOf(100));
        saleItem.setQuantity(10);
        return saleItem;
    }
}
