package com.knoldus.springbootswaggerexample.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Entity Class for user",description = "model class for user")
public class User {

    //@ApiModelProperty(notes = "id of the user", name = "user's id",required = true,value = "1")
    @ApiModelProperty(position = 1, required = true, value = "1")
    private int id;

    @ApiModelProperty(notes = "name of the user", name = "user's name",required = true,value = "Deepak")
    private String name;

    @ApiModelProperty(notes = "phone_Number of the user", name = "user's number",required = true,value = "8688652012")
    private Long phoneNumber;

    public User(int id, String name, Long phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
