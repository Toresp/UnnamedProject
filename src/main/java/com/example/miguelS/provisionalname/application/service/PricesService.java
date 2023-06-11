package com.example.miguelS.provisionalname.application.service;

import com.example.miguelS.provisionalname.domain.Prices;
import com.example.miguelS.provisionalname.domain.PricesRepository;
import com.example.miguelS.provisionalname.domain.filters.PriceFilterParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricesService {

    private PricesRepository pricesRepository;


    @Autowired
    public PricesService(PricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
    }

    public List<Prices> getPrices(PriceFilterParameters filterParameters) {
        return this.pricesRepository.priceFilterParameters(filterParameters);
    }
}
