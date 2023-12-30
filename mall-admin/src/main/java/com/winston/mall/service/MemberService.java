package com.winston.mall.service;

import com.winston.mall.entity.Member;

import java.util.Map;

public interface MemberService {
    Member getMemberByUsername(String username);

    Member doLogin(Map<String, Object> loginParam);
}
