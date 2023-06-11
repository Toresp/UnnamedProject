package com.example.miguelS.provisionalname.domain;


import com.example.miguelS.provisionalname.domain.filters.PriceFilterParameters;

import java.util.List;

public interface PricesRepository {

    List<Prices> priceFilterParameters(PriceFilterParameters priceFilterParameters);

}
