package com.sky.hrpro.dao;

import com.sky.hrpro.entity.MailRecordEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: CarryJey @Date: 2018/10/20 18:01:21
 */
@Repository
public class MailRecordDao {
    private static final BeanPropertyRowMapper<MailRecordEntity> rowMapper =
        BeanPropertyRowMapper.newInstance(MailRecordEntity.class);

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void addRecord(MailRecordEntity mailRecordEntity) {
        String sql =
            "INSERT INTO mailrecord (from_address,to_address,content,title,created_time,updated_time)"
                + " VALUES(:fromAddress,:toAddress,:content,:title,:createdTime,:updatedTime)";
        int rows = jdbcTemplate.update(sql, new BeanPropertySqlParameterSource(mailRecordEntity));
        assert rows == 1;
    }

    public MailRecordEntity getMailRecord(String fromAddress, String toAddress) {
        String sql = "SELECT * FROM mailrecord WHERE from_address = :fromAddress AND to_address = :toAddress";
        List<MailRecordEntity> res =
            jdbcTemplate.query(
                sql, new MapSqlParameterSource("fromAddress", fromAddress).addValue("toAddress", toAddress), rowMapper);
        return res.get(0);
    }
}
