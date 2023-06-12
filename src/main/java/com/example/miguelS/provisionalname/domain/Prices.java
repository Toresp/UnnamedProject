package com.example.miguelS.provisionalname.domain;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
@Getter
public class Prices {

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
