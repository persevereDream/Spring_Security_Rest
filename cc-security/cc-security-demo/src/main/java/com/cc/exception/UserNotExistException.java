package com.cc.exception;

public class UserNotExistException extends RuntimeException{


    private static final long serialVersionUID = -9172573524083271087L;
    private String id;

    public UserNotExistException(String id){
        super("user not exist");
        this.id = id;
    }


    public String getId() {
        return id;
    }

    public UserNotExistException setId(String id) {
        this.id = id;
        return this;
    }
}
