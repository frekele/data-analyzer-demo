package org.frekele.demo.data.analyzer.service;

import org.frekele.demo.data.analyzer.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;

@Service
public interface CustomerService {

    Customer buildCustomerByMatcher(Matcher matcher);

    Integer getTotalCustomer(List<Customer> customerList);
}
