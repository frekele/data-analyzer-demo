package org.frekele.demo.data.analyzer.enums;

import lombok.Getter;

public enum ConfigEnum {

    HOME_PATH(System.getProperty("user.home"));

    @Getter
    private String value;

    ConfigEnum(String value) {
        this.value = value;
    }

}
