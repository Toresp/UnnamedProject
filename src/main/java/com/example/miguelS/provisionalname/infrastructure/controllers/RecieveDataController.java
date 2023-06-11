package com.example.miguelS.provisionalname.infrastructure.controllers;

import com.example.miguelS.provisionalname.application.service.PricesService;
import com.example.miguelS.provisionalname.domain.Prices;
import com.example.miguelS.provisionalname.domain.filters.PriceFilterParameters;
import com.example.miguelS.provisionalname.infrastructure.controllers.dto.PricesListDTO;
import com.example.miguelS.provisionalname.infrastructure.controllers.mappers.DTOPricesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.miguelS.provisionalname.domain.Constants.PRICES;

@RestController
public class RecieveDataController {

    private PricesService pricesService;

    private DTOPricesMapper dtoPricesMapper;

    @Autowired
    public RecieveDataController(PricesService pricesService, DTOPricesMapper dtoPricesMapper) {
        this.pricesService = pricesService;
        this.dtoPricesMapper = dtoPricesMapper;
    }


    @GetMapping(PRICES)
    public ResponseEntity<PricesListDTO> Prices(@RequestParam("appDate") String appDate, @RequestParam("productId") Long productId, @RequestParam("brandId") Long brandId) {
        try {
            List<Prices> pricesList = this.pricesService.getPrices(PriceFilterParameters.builder()
                    .startDate(appDate)
                    .productId(productId)
                    .brandId(brandId).build());
            if (pricesList.isEmpty()) {
                ResponseEntity.notFound().build();
            }
            ResponseEntity.ok(dtoPricesMapper.mapToDTOs(pricesList));
        } catch (RuntimeException e) {
            //TODO logger
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }


        return ResponseEntity.ok().build();
    }

}
