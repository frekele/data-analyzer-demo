package org.frekele.demo.data.analyzer.factory;

import lombok.extern.slf4j.Slf4j;
import org.frekele.demo.data.analyzer.enums.layout.field.SaleItemEnum;
import org.frekele.demo.data.analyzer.model.SaleItem;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.regex.Matcher;

@Slf4j
@Component
public class SaleItemFactoryImpl implements SaleItemFactory {

    @Override
    public SaleItem create(Matcher matcher) {
        return SaleItem.builder()
                .id(Long.parseLong(matcher.group(SaleItemEnum.ID.getValue())))
                .quantity(Integer.parseInt(matcher.group(SaleItemEnum.QUANTITY.getValue())))
                .price(new BigDecimal(matcher.group(SaleItemEnum.PRICE.getValue())))
                .build();
    }
}
