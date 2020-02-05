package org.frekele.demo.data.analyzer.enums;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigEnumTest {

    private String homePath;

    @BeforeEach
    public void setUp() {
        this.homePath = System.getProperty("user.home");
    }

    @Test
    public void shouldBuildCustomerWithAllPropertiesWithSuccess() {
        ConfigEnum.HOME_PATH.getValue().equals(homePath);
        assertEquals(homePath, ConfigEnum.HOME_PATH.getValue());
    }

}