package org.frekele.demo.data.analyzer.factory;

import org.frekele.demo.data.analyzer.enums.LayoutMatcherRegexEnum;
import org.frekele.demo.data.analyzer.model.Salesman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.*;

public class SalesmanFactoryTest extends BaseFactoryTest {

    private SalesmanFactory salesmanFactory;

    @BeforeEach
    public void setUp() {
        this.salesmanFactory = new SalesmanFactoryImpl();
    }

    @Test
    public void createSalesmanFactoryWithSuccessTest() {
        String line = "001ç1234567891234çPedroç50000";
        Matcher matcher = getMatcherByLayout(line, LayoutMatcherRegexEnum.SALESMAN);
        matcher.find();
        Salesman salesman = salesmanFactory.create(matcher);
        assertEquals(mockSalesmanWithAllFields().toString(), salesman.toString());
    }

    private Salesman mockSalesmanWithAllFields() {
        Salesman salesman = new Salesman();
        salesman.setLayoutId(001L);
        salesman.setCpf("1234567891234");
        salesman.setName("Pedro");
        salesman.setSalary(BigDecimal.valueOf(50000));
        salesman.setTotalSalesPrice(BigDecimal.ZERO);
        return salesman;
    }
}
