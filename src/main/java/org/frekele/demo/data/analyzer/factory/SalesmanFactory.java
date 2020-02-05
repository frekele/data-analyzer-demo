package org.frekele.demo.data.analyzer.factory;

import org.frekele.demo.data.analyzer.model.Salesman;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;


@Component
public interface SalesmanFactory {

    Salesman create(Matcher matcher);
}
