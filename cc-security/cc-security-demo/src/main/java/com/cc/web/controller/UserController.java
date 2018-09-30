package com.cc.web.controller;


import com.cc.dto.User;
import com.cc.dto.UserQueryCondition;
import com.cc.exception.UserNotExistException;
import com.fasterxml.jackson.annotation.JsonView;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping
    public User create(@Valid @RequestBody User user, BindingResult errors){
        if (errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }
        System.out.println(user.toString());
        user.setId("1");
        return user;
    }

    @PostMapping("/c1")
    public User create(@Valid @RequestBody User user){
        System.out.println(user.toString());
        user.setId("1");
        return user;
    }

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> query(UserQueryCondition userQueryCondition,
                            @PageableDefault(size = 15,page = 3,sort = "username",direction = Sort.Direction.DESC) Pageable pageable){
        System.out.println(ReflectionToStringBuilder.toString(userQueryCondition,ToStringStyle.MULTI_LINE_STYLE));
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());

        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable(name = "id") String id){
        throw new RuntimeException("user not exist");
//        throw new UserNotExistException(id);

//        System.out.println("进入getInfo服务");
//        User user = new User();
//        user.setUsername("cc");
//        user.setPassword("password");
//        return user;
    }

    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult errors){
        if (errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error -> {
                FieldError fieldError = (FieldError)error;
                String message = fieldError.getField() +":"+ error.getDefaultMessage();
                System.out.println(message);
            });
        }
        System.out.println(user.toString());
        user.setId("1");
        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable String id){
        System.out.println(id);
    }

}
