package org.frekele.demo.data.analyzer.service;

import org.frekele.demo.data.analyzer.model.SaleItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SaleItemService {

    List<SaleItem> buildItemListBySale(String itemSaleGroup);
}
