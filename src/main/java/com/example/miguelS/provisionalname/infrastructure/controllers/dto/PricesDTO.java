package com.example.miguelS.provisionalname.infrastructure.controllers.dto;

import lombok.Setter;

import java.math.BigDecimal;

@Setter
public class PricesDTO {

    public Long id;

    public Long brandId;

    public String startDate;

    public String endDate;

    public String priceList;

    public Long productId;

    public Integer priority;

    public BigDecimal price;

    public String curr;
}
