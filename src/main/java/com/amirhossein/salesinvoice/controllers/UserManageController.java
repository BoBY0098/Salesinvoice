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
    @ApiOperation(value = "" , notes = "" , response = UserRes.class)
    public UserRes userLogin(@NonNull @RequestParam String username ,@NonNull @RequestParam String password){
        return userService.userLogin(username , password);
    }

    @GetMapping()
    @ApiOperation(value = "" , notes = "" , response = UserRes.class , responseContainer = "List")
    public List<UserRes> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    @ApiOperation(value = "" , notes = "" , response = UserRes.class)
    public UserRes getUserById(@PathVariable UUID userId){
        return userService.getUserById(userId);
    }

    @PostMapping()
    @ApiOperation(value = "" , notes = "" , response = UserRes.class)
    public UserRes createUser(@RequestBody UserReq req){
        return userService.createUser(req);
    }
}
