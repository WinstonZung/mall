package com.winston.mall.dao;

import com.winston.mall.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Slf4j
public class MemberDao {

    private final JdbcTemplate jdbcTemplate;

    public MemberDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Member getMemberInfoByUsername(String username) {
        String sql =
                "select id, level_id levelId, username, nickname, mobile," +
                "email, header, gender, birth, city, job,sign, source_type sourceType," +
                "integration, growth, status, create_time createTime from ums_member " +
                "where username = ?";
        Member members;
        try {
            members = jdbcTemplate.queryForObject(sql, new MemberPo(), username);
        } catch (Exception e) {
            log.warn("{}---未找到用户信息...", username);
            throw new RuntimeException("未有用户信息...");
        }
        return members;

    }

    public Map<String, Object> getPasswordByUsername(String username) {
        String sql = "select password, status from ums_member where username = ?";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, username);
        if (!CollectionUtils.isEmpty(maps)) {
           return maps.get(0);
        }
        return new HashMap<>();
    }

    private class MemberPo implements RowMapper<Member> {

        @Override
        public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
            Member member = new Member();
            int id = rs.getInt("id");
            member.setId(1231231L);
            return member;
        }
    }
}
