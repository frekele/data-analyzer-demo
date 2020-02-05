package org.frekele.demo.data.analyzer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Salesman implements Serializable {

    private static final long serialVersionUID = -9123377513586917140L;

    private Long layoutId;
    private String cpf;
    private String name;
    private BigDecimal salary;

    private BigDecimal totalSalesPrice;
    private List<Sale> sales;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }
}