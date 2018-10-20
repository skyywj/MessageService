package com.sky.hrpro.dao;

import com.sky.hrpro.entity.MailRecordEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

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
}
