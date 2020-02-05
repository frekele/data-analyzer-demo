package org.frekele.demo.data.analyzer.service;

import org.frekele.demo.data.analyzer.model.Sale;
import org.frekele.demo.data.analyzer.model.Salesman;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;

@Service
public interface SalesmanService {

    Salesman buildSalesmanByMatcher(Matcher matcher);

    List<Salesman> setSalesmanSales(List<Salesman> salesmanList,
                                    List<Sale> saleList);

    Integer getTotalSalesman(List<Salesman> salesmanList);

    Salesman getWorstSalesman(List<Salesman> salesmanList);


}
