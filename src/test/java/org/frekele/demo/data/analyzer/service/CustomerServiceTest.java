package org.frekele.demo.data.analyzer.service;

import org.frekele.demo.data.analyzer.factory.CustomerFactory;
import org.frekele.demo.data.analyzer.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class CustomerServiceTest extends BaseServiceTest {

    private CustomerService customerService;
    private CustomerFactory customerFactory;

    @BeforeEach
    public void setUp() {
        this.customerFactory = mock(CustomerFactory.class);
        this.customerService = new CustomerServiceImpl(this.customerFactory);
    }

    @Test
    public void buildCustomerByMatcherWithSuccessTest() {
        when(this.customerFactory.create(any())).thenReturn(mockCustomerWithAllFields());
        assertEquals(mockCustomerWithAllFields().toString(), this.customerService.buildCustomerByMatcher(any()).toString());
    }

    @Test
    public void getTotalCustomerWithSuccessTest() {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(mockCustomerWithAllFields());
        assertEquals(Integer.valueOf(1), this.customerService.getTotalCustomer(customerList));
    }

    private Customer mockCustomerWithAllFields() {
        Customer customer = new Customer();
        customer.setLayoutId(2L);
        customer.setCnpj("2345675434544345");
        customer.setName("Jose da Silva");
        customer.setBusinessArea("Rural");
        return customer;
    }
}
