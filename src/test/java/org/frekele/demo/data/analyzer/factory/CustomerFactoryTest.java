package org.frekele.demo.data.analyzer.factory;

import org.frekele.demo.data.analyzer.enums.LayoutMatcherRegexEnum;
import org.frekele.demo.data.analyzer.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerFactoryTest extends BaseFactoryTest {

    private CustomerFactory customerFactory;

    @BeforeEach
    public void setUp() {
        this.customerFactory = new CustomerFactoryImpl();
    }

    @Test
    public void createCustomerFactoryWithSuccessTest() {
        String line = "002ç2345675434544345çJose da SilvaçRural";
        Matcher matcher = getMatcherByLayout(line, LayoutMatcherRegexEnum.CUSTOMER);
        matcher.find();
        Customer customer = this.customerFactory.create(matcher);
        assertEquals(mockCustomerWithAllFields().toString(), customer.toString());
    }

    private Customer mockCustomerWithAllFields() {
        Customer customer = new Customer();
        customer.setLayoutId(002L);
        customer.setCnpj("2345675434544345");
        customer.setName("Jose da Silva");
        customer.setBusinessArea("Rural");
        return customer;
    }
}
