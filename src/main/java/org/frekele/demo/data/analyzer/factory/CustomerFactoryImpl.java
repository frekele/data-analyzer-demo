package org.frekele.demo.data.analyzer.factory;

import lombok.extern.slf4j.Slf4j;
import org.frekele.demo.data.analyzer.enums.layout.field.CustomerEnum;
import org.frekele.demo.data.analyzer.model.Customer;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;

@Slf4j
@Component
class CustomerFactoryImpl implements CustomerFactory {

    @Override
    public Customer create(Matcher matcher) {
        return Customer.builder()
                .layoutId(Long.parseLong(matcher.group(CustomerEnum.LAYOUT_ID.getValue())))
                .cnpj(matcher.group(CustomerEnum.CNPJ.getValue()))
                .name(matcher.group(CustomerEnum.NAME.getValue()))
                .businessArea(matcher.group(CustomerEnum.BUSINESS_AREA.getValue()))
                .build();
    }
}
