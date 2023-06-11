package com.example.miguelS.provisionalname.domain.filters;

import lombok.Builder;

@Builder
public class PriceFilterParameters {
    private String startDate;
    private Long brandId;
    private Long productId;
}
