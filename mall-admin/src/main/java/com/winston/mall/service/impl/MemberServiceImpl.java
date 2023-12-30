package com.winston.mall.service.impl;

import com.winston.mall.dao.MemberDao;
import com.winston.mall.entity.Member;
import com.winston.mall.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService {
    private final MemberDao memberDao;

    public MemberServiceImpl(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public Member getMemberByUsername(String username) {
        return memberDao.getMemberInfoByUsername(username);
    }

    @Override
    public Member doLogin(Map<String, Object> loginParam) {
        String password = MapUtils.getString(loginParam, "password");
        String username = MapUtils.getString(loginParam, "username");
        Map<String, Object> loginInfo = memberDao.getPasswordByUsername(username);

        if (!StringUtils.equals(password, MapUtils.getString(loginInfo, "password"))) {
            log.warn("{}---登陆失败！", username);
            throw new RuntimeException("登录失败！");
        }

        return getMemberByUsername(username);
    }
}
