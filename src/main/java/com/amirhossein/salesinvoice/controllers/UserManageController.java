package com.amirhossein.salesinvoice.controllers;

import com.amirhossein.salesinvoice.models.user.UserReq;
import com.amirhossein.salesinvoice.models.user.UserRes;
import com.amirhossein.salesinvoice.services.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Api(tags = "manage-users")
@RequestMapping("/manage/users")
public class UserManageController {

    private UserService userService;

    @Autowired
    public UserManageController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    @ApiOperation(value = "User Login" , notes = "User Login by Username and Password" , response = UserRes.class)
    public UserRes userLogin(@NonNull @RequestParam String username ,@NonNull @RequestParam String password){
        return userService.userLogin(username , password);
    }

    @GetMapping()
    @ApiOperation(value = "Get All Users" , notes = "Get All Users" , response = UserRes.class , responseContainer = "List")
    public List<UserRes> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    @ApiOperation(value = "Get a User" , notes = "Get a User by UserID" , response = UserRes.class)
    public UserRes getUserById(@PathVariable UUID userId){
        return userService.getUserById(userId);
    }

    @PostMapping("/register")
    @ApiOperation(value = "Create a New User" , notes = "Create a New User" , response = UserRes.class)
    public UserRes createUser(@RequestBody UserReq req){
        return userService.createUser(req);
    }
}
