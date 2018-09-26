package com.cc.dto;

import com.fasterxml.jackson.annotation.JsonView;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class User {

    public interface UserSimpleView {};
    public interface UserDetailView extends UserSimpleView {};

    private String id;
    private String username;
    @NotBlank
    private String password;
    private Date birthday;

    @JsonView(UserSimpleView.class)
    public Date getBirthday() {
        return birthday;
    }
    public User setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    @JsonView(UserSimpleView.class)
    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }

    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }
    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id='").append(id).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", birthday=").append(birthday);
        sb.append('}');
        return sb.toString();
    }
}
