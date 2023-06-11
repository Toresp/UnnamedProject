package com.example.miguelS.provisionalname.infrastructure.repositories;

import com.example.miguelS.provisionalname.domain.Prices;
import com.example.miguelS.provisionalname.domain.PricesRepository;
import com.example.miguelS.provisionalname.domain.filters.PriceFilterParameters;
import com.example.miguelS.provisionalname.infrastructure.repositories.VO.PricesVO;
import com.example.miguelS.provisionalname.infrastructure.repositories.h2.H2PricesRepository;
import com.example.miguelS.provisionalname.infrastructure.repositories.mappers.VOPricesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PricesRepositoryImpl implements PricesRepository {
    private H2PricesRepository h2PricesRepository;

    private VOPricesMapper voPricesMapper;

    @Autowired
    public PricesRepositoryImpl(H2PricesRepository h2PricesRepository, VOPricesMapper voPricesMapper) {
        this.h2PricesRepository = h2PricesRepository;
        this.voPricesMapper = voPricesMapper;
    }

    @Override
    public List<Prices> priceFilterParameters(PriceFilterParameters priceFilterParameters) {
        List<PricesVO> pricesVOList = h2PricesRepository.priceFilterParameters(priceFilterParameters);
        if (pricesVOList == null) {
            return Collections.emptyList();
        }
        return pricesVOList.stream().map(pricesVO -> this.voPricesMapper.mapVOtoBO(pricesVO)).collect(Collectors.toList());
    }
}