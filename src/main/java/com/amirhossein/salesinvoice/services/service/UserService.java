package com.amirhossein.salesinvoice.services.service;

import com.amirhossein.salesinvoice.models.user.UserReq;
import com.amirhossein.salesinvoice.models.user.UserRes;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<UserRes> getAllUsers();

    UserRes getUserById(UUID userId);

    UserRes createUser(UserReq userReq);

    UserRes userLogin(String username, String password);
}
