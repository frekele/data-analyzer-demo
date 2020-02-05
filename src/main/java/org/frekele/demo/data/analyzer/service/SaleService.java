package org.frekele.demo.data.analyzer.service;

import org.frekele.demo.data.analyzer.model.Sale;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;

@Service
public interface SaleService {

    Sale buildSaleByMatcher(Matcher matcher);

    Sale getSaleMoreExpensive(List<Sale> saleList);
}