package com.knoldus.springbootswaggerexample.controller;

import com.knoldus.springbootswaggerexample.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api(value = "/api/v1", tags = "User API Controller")
public class UserController {

    ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<>();

    @ApiOperation(value = "get user by its id",notes = "get user by id if exist",tags = {"GET USER BY ID"})
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "OK"),
            @ApiResponse(code = 202,message = "success"),
            @ApiResponse(code = 404,message = "Invalid"),
            @ApiResponse(code = 500,message = "Server error")

    })
    @GetMapping("/{id}")
    public User getUser(@PathVariable int id){
      return users.get(id);
    }

    @ApiOperation(value = "Get All user details ", notes = "get all user if exist", tags = {"GET USER"})
    @GetMapping("/getAll")
     public List<User>getAllUser()   {
       return new ArrayList<User>(users.values());

        }
    @ApiOperation(value = "Create User", notes = "Create new User", tags = {"CREATE CREATE"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User created successfully!!"),
            @ApiResponse(code = 404, message = "Invalid Data"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
    })
    @PostMapping("/add")
    public User addUser(@RequestBody User user){
         users.put(user.getId(),user);
         return user;
    }

}

