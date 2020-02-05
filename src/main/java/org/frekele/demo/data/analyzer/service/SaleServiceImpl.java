package org.frekele.demo.data.analyzer.service;

import lombok.extern.slf4j.Slf4j;
import org.frekele.demo.data.analyzer.factory.SaleFactory;
import org.frekele.demo.data.analyzer.model.Sale;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;

@Slf4j
@Service
class SaleServiceImpl implements SaleService {

    private static final String GROUP_NAME_ITEM = "itemSale";
    private SaleFactory saleFactory;
    private SaleItemService saleItemService;

    public SaleServiceImpl(SaleFactory saleFactory, SaleItemService saleItemService) {
        this.saleFactory = saleFactory;
        this.saleItemService = saleItemService;
    }

    @Override
    public Sale buildSaleByMatcher(Matcher matcher) {
        Sale sale = this.saleFactory.create(
                matcher,
                this.saleItemService.buildItemListBySale(matcher.group(GROUP_NAME_ITEM))
        );
        sale = getTotalSalePriceFromItems(sale);

        return sale;
    }

    @Override
    public Sale getSaleMoreExpensive(List<Sale> saleList) {
        return saleList
                .stream()
                .max(Comparator.comparing(Sale::getTotalSalePrice))
                .orElseThrow(NoSuchElementException::new);
    }

    private Sale getTotalSalePriceFromItems(Sale sale) {
        BigDecimal totalItemsValue = sale.getSaleItems()
                .stream()
                .map(itemSale -> itemSale.getPrice().multiply(BigDecimal.valueOf(itemSale.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        sale.setTotalSalePrice(totalItemsValue);
        return sale;
    }
}