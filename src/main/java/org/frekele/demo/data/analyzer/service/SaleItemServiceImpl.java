package org.frekele.demo.data.analyzer.service;

import lombok.extern.slf4j.Slf4j;
import org.frekele.demo.data.analyzer.enums.LayoutMatcherRegexEnum;
import org.frekele.demo.data.analyzer.factory.SaleItemFactory;
import org.frekele.demo.data.analyzer.model.SaleItem;
import org.frekele.demo.data.analyzer.service.validation.LayoutValidation;
import org.frekele.demo.data.analyzer.service.validation.LayoutValidationImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

@Slf4j
@Service
class SaleItemServiceImpl implements SaleItemService {

    private SaleItemFactory saleItemFactory;

    public SaleItemServiceImpl(SaleItemFactory saleItemFactory) {
        this.saleItemFactory = saleItemFactory;
    }

    @Override
    public List<SaleItem> buildItemListBySale(String itemSaleGroup) {
        List<SaleItem> saleItemList = new ArrayList<>();
        LayoutValidation layoutValidation = new LayoutValidationImpl(itemSaleGroup);
        Matcher matcher = layoutValidation.getMatcherByLayout(LayoutMatcherRegexEnum.SALE_ITEM);

        while (matcher.find()) {
            saleItemList.add(this.saleItemFactory.create(matcher));
        }

        return saleItemList;
    }
}
