package org.frekele.demo.data.analyzer.factory;

import lombok.extern.slf4j.Slf4j;
import org.frekele.demo.data.analyzer.enums.layout.field.SaleEnum;
import org.frekele.demo.data.analyzer.model.Sale;
import org.frekele.demo.data.analyzer.model.SaleItem;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;

@Slf4j
@Component
class SaleFactoryImpl implements SaleFactory {

    @Override
    public Sale create(Matcher matcher, List<SaleItem> saleItems) {
        return Sale.builder()
                .layoutId(Long.parseLong(matcher.group(SaleEnum.LAYOUT_ID.getValue())))
                .id(Long.parseLong(matcher.group(SaleEnum.ID.getValue())))
                .saleItems(saleItems)
                .salesmanName(matcher.group(SaleEnum.SALESMAN_NAME.getValue()))
                .totalSalePrice(BigDecimal.ZERO)
                .build();
    }
}
