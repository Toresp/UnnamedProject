package com.example.miguelS.provisionalname.infrastructure.controllers.mappers;

import com.example.miguelS.provisionalname.domain.Prices;
import com.example.miguelS.provisionalname.infrastructure.controllers.dto.PricesDTO;
import com.example.miguelS.provisionalname.infrastructure.controllers.dto.PricesListDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DTOPricesMapper {


    public PricesListDTO mapToDTOs(List<Prices> pricesList) {
        PricesListDTO pricesListDTO = new PricesListDTO();
        pricesListDTO.setPricesDTOList(pricesList.stream().map(this::mapToDTO).collect(Collectors.toList()));
        return pricesListDTO;
    }

    public PricesDTO mapToDTO(Prices prices) {
        PricesDTO dto = new PricesDTO();
        dto.setId(prices.getId());
        dto.setBrandId(prices.getBrandId());
        dto.setStartDate(prices.getStartDate());
        dto.setEndDate(prices.getEndDate());
        dto.setPriceList(prices.getPriceList());
        dto.setProductId(prices.getProductId());
        dto.setPriority(prices.getPriority());
        dto.setPrice(prices.getPrice());
        dto.setCurr(prices.getCurr());
        return dto;
    }

}
