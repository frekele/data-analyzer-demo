package org.frekele.demo.data.analyzer.enums.layout.field;

import lombok.Getter;

public enum CustomerEnum {

    LAYOUT_ID("layoutIdCustomer"),
    CNPJ("cnpjCustomer"),
    NAME("nameCustomer"),
    BUSINESS_AREA("businessAreaCustomer");

    @Getter
    private String value;

    CustomerEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return getValue();
    }
}
