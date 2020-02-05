package org.frekele.demo.data.analyzer.service;

import lombok.extern.slf4j.Slf4j;
import org.frekele.demo.data.analyzer.factory.CustomerFactory;
import org.frekele.demo.data.analyzer.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;

@Slf4j
@Service
class CustomerServiceImpl implements CustomerService {

    private CustomerFactory customerFactory;

    public CustomerServiceImpl(CustomerFactory customerFactory) {
        this.customerFactory = customerFactory;
    }

    @Override
    public Customer buildCustomerByMatcher(Matcher matcher) {
        return this.customerFactory.create(matcher);
    }

    @Override
    public Integer getTotalCustomer(List<Customer> customerList) {
        return customerList.size();
    }
}
