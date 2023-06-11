package com.example.miguelS.provisionalname.infrastructure.repositories.mappers;

import com.example.miguelS.provisionalname.domain.Prices;
import com.example.miguelS.provisionalname.infrastructure.repositories.VO.PricesVO;
import org.springframework.stereotype.Component;

@Component
public class VOPricesMapper {

    public Prices mapVOtoBO(PricesVO pricesVO) {
        return Prices.builder()
                .id(pricesVO.getId())
                .brandId(pricesVO.getBrandId())
                .startDate(pricesVO.getStartDate())
                .endDate(pricesVO.getEndDate())
                .priceList(pricesVO.getPriceList())
                .productId(pricesVO.getProductId())
                .priority(pricesVO.getPriority())
                .price(pricesVO.getPrice())
                .build();
    }
}
