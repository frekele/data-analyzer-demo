package org.frekele.demo.data.analyzer.factory;

import lombok.extern.slf4j.Slf4j;
import org.frekele.demo.data.analyzer.enums.layout.field.SalesmanEnum;
import org.frekele.demo.data.analyzer.model.Salesman;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.regex.Matcher;

@Slf4j
@Component
public class SalesmanFactoryImpl implements SalesmanFactory {

    @Override
    public Salesman create(Matcher matcher) {
        return Salesman.builder()
                .layoutId(Long.parseLong(matcher.group(SalesmanEnum.LAYOUT_ID.getValue())))
                .cpf(matcher.group(SalesmanEnum.CPF.getValue()))
                .name(matcher.group(SalesmanEnum.NAME.getValue()))
                .salary(new BigDecimal(matcher.group(SalesmanEnum.SALARY.getValue())))
                .totalSalesPrice(BigDecimal.ZERO)
                .build();
    }
}
