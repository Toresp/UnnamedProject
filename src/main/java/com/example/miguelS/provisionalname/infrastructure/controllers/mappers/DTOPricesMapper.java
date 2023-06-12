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
        dto.setBrandId(prices.getBrandId());
        dto.setStartDate(prices.getStartDate().toString());
        dto.setEndDate(prices.getEndDate().toString());
        dto.setProductId(prices.getProductId());
        dto.setPrice(prices.getPrice());
        return dto;
    }

}
