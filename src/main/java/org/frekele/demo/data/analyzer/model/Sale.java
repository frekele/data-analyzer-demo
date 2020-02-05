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
public class Sale implements Serializable {

    private static final long serialVersionUID = -3764411526190454501L;

    private Long layoutId;
    private Long id;
    private List<SaleItem> saleItems;
    private String salesmanName;

    private BigDecimal totalSalePrice;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }
}
