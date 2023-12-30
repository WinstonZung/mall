package com.winston.mall.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class Member {
    private Long id;
    private Long levelId;
    private String username;
    private String password;
    private String nickname;
    private String mobile;
    private String email;
    private String header;
    private Short gender;
    private LocalDate birth;
    private String city;
    private String job;
    private String sign;
    private Short sourceType;
    private Integer integration;
    private Integer growth;
    private Short status;
    private LocalDate createTime;
}
