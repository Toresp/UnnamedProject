package com.example.miguelS.provisionalname.infrastructure.repositories.h2;

import com.example.miguelS.provisionalname.domain.filters.PriceFilterParameters;
import com.example.miguelS.provisionalname.infrastructure.repositories.VO.PricesVO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface H2PricesRepository extends CrudRepository<PricesVO, Long> {

    List<PricesVO> priceFilterParameters(PriceFilterParameters priceFilterParameters);
}
