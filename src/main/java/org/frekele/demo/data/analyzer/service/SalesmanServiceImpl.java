package org.frekele.demo.data.analyzer.service;

import lombok.extern.slf4j.Slf4j;
import org.frekele.demo.data.analyzer.factory.SalesmanFactory;
import org.frekele.demo.data.analyzer.model.Sale;
import org.frekele.demo.data.analyzer.model.Salesman;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

@Slf4j
@Service
class SalesmanServiceImpl implements SalesmanService {

    private SalesmanFactory salesmanFactory;

    public SalesmanServiceImpl(SalesmanFactory salesmanFactory) {
        this.salesmanFactory = salesmanFactory;
    }

    @Override
    public Salesman buildSalesmanByMatcher(Matcher matcher) {
        return this.salesmanFactory.create(matcher);
    }

    @Override
    public List<Salesman> setSalesmanSales(List<Salesman> salesmanList,
                                           List<Sale> saleList) {

        salesmanList.forEach(salesman -> {
            salesman.setSales(saleList.stream()
                    .filter(sale -> sale.getSalesmanName().equals(salesman.getName()))
                    .collect(Collectors.toList()));
            salesman.setTotalSalesPrice(getSalesmanTotalSalesPrice(salesman).getTotalSalesPrice());
        });
        return salesmanList;
    }

    @Override
    public Integer getTotalSalesman(List<Salesman> salesmanList) {
        return salesmanList.size();
    }

    @Override
    public Salesman getWorstSalesman(List<Salesman> salesmanList) {
        return salesmanList
                .stream()
                .min(Comparator.comparing(Salesman::getTotalSalesPrice))
                .orElseThrow(NoSuchElementException::new);
    }

    private Salesman getSalesmanTotalSalesPrice(Salesman salesman) {
        BigDecimal totalSalesmanSaleValue = salesman.getSales()
                .stream()
                .map(Sale::getTotalSalePrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        salesman.setTotalSalesPrice(totalSalesmanSaleValue);
        return salesman;
    }
}
