package org.frekele.demo.data.analyzer.enums.layout.field;

import lombok.Getter;

public enum SaleItemEnum {

    ID("idSaleItem"),
    QUANTITY("quantitySaleItem"),
    PRICE("priceSaleItem");

    @Getter
    private String value;

    SaleItemEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return getValue();
    }
}
