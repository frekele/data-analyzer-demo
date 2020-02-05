package org.frekele.demo.data.analyzer.factory;

import org.frekele.demo.data.analyzer.model.Customer;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;

@Component
public interface CustomerFactory {

    Customer create(Matcher matcher);
}
