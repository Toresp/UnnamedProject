package com.example.miguelS.provisionalname.domain.filters;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Builder
@Getter
public class PriceFilterParameters {
    private Instant startDate;
    private Long brandId;
    private Long productId;
}
