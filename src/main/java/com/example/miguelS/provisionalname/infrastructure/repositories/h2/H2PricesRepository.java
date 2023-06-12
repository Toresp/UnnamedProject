package com.example.miguelS.provisionalname.infrastructure.repositories.h2;

import com.example.miguelS.provisionalname.infrastructure.repositories.VO.PricesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.List;

@Repository
public class H2PricesRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public H2PricesRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<PricesVO> findByDateRangeBrandIdProductId(Instant appDate, Long brandId, Long productId) {
        String query = "SELECT * FROM prices WHERE ? BETWEEN START_DATE AND END_DATE AND BRAND_ID = ? AND PRODUCT_ID = ?";
        return jdbcTemplate.query(query, this::mapRowToEntity, appDate, brandId, productId);
    }

    private PricesVO mapRowToEntity(ResultSet rs, int rowNum) throws SQLException {
        PricesVO entity = new PricesVO();
        entity.setId(rs.getLong("id"));
        entity.setBrandId(rs.getLong("brand_id"));
        entity.setStartDate(rs.getTimestamp("start_date").toInstant());
        entity.setEndDate(rs.getTimestamp("end_date").toInstant());
        entity.setPriceList(rs.getString("price_list"));
        entity.setProductId(rs.getLong("product_id"));
        entity.setPriority(rs.getInt("priority"));
        entity.setPrice(rs.getBigDecimal("price"));
        entity.setCurr(rs.getString("curr"));
        return entity;
    }
}
