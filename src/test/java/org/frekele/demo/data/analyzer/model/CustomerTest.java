package org.frekele.demo.data.analyzer.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest extends BaseModelTest {

    private Customer.CustomerBuilder customerBuilder;

    @BeforeEach
    public void setUp() {
        this.customerBuilder = Customer.builder();
    }

    @Test
    public void customerWithAllFieldsWithSuccessTest() {
        Customer customer = customerBuilder
                .layoutId(1L)
                .cnpj("56306923802")
                .name("Dale ale")
                .businessArea("Office")
                .build();
        assertEquals(mockCustomerWithAllFields().toString(), customer.toString());
    }

    @Test
    public void customerWithOnlyNameFieldWithSuccessTest() {
        Customer customer = customerBuilder
                .name("Dale ale")
                .build();
        assertEquals(mockCustomerWithOnlyNameField().toString(), customer.toString());
    }

    private Customer mockCustomerWithAllFields() {
        Customer customer = new Customer();
        customer.setLayoutId(1L);
        customer.setCnpj("56306923802");
        customer.setName("Dale ale");
        customer.setBusinessArea("Office");
        return customer;
    }

    private Customer mockCustomerWithOnlyNameField() {
        Customer customer = new Customer();
        customer.setName("Dale ale");
        return customer;
    }
}