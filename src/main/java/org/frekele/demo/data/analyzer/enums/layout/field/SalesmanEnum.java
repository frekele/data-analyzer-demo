package org.frekele.demo.data.analyzer.enums.layout.field;

import lombok.Getter;

public enum SalesmanEnum {

    LAYOUT_ID("layoutIdSalesman"),
    CPF("cpfSalesman"),
    NAME("nameSalesman"),
    SALARY("SalarySalesman");

    @Getter
    private String value;

    SalesmanEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return getValue();
    }
}
