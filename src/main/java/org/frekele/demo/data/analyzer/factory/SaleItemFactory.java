package org.frekele.demo.data.analyzer.factory;

import org.frekele.demo.data.analyzer.model.SaleItem;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;

@Component
public interface SaleItemFactory {

    SaleItem create(Matcher matcher);
}
