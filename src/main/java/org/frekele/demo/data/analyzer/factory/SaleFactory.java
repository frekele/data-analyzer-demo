package org.frekele.demo.data.analyzer.factory;

import org.frekele.demo.data.analyzer.model.Sale;
import org.frekele.demo.data.analyzer.model.SaleItem;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Matcher;

@Component
public interface SaleFactory {

    Sale create(Matcher matcher, List<SaleItem> saleItemList);
}
