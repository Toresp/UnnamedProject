package com.example.miguelS.provisionalname.infrastructure.repositories.VO;

import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
public class PricesVO {

    private Long id;

    private Long brandId;

    private Instant startDate;

    private Instant endDate;

    private String priceList;

    private Long productId;

    private Integer priority;

    private BigDecimal price;

    private String curr;
}