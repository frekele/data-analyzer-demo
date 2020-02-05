package org.frekele.demo.data.analyzer.enums.layout.field;

import lombok.Getter;

public enum SaleEnum {

    LAYOUT_ID("layoutIdSale"),
    ID("idSale"),
    ITEM("itemSale"),
    SALESMAN_NAME("salesmanNameSale");

    @Getter
    private String value;

    SaleEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return getValue();
    }
}
