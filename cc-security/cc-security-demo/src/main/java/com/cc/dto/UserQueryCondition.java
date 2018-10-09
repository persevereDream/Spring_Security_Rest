package com.cc.dto;

import io.swagger.annotations.ApiModelProperty;

public class UserQueryCondition {

    private String username;
    @ApiModelProperty(value = "用户年龄起始值")
    private int age;
    @ApiModelProperty(value = "用户年龄终止值")
    private int ageTo;
    private String xxx;

    public String getUsername() {
        return username;
    }

    public UserQueryCondition setUsername(String username) {
        this.username = username;
        return this;
    }

    public int getAge() {
        return age;
    }

    public UserQueryCondition setAge(int age) {
        this.age = age;
        return this;
    }

    public int getAgeTo() {
        return ageTo;
    }

    public UserQueryCondition setAgeTo(int ageTo) {
        this.ageTo = ageTo;
        return this;
    }

    public String getXxx() {
        return xxx;
    }

    public UserQueryCondition setXxx(String xxx) {
        this.xxx = xxx;
        return this;
    }

}
