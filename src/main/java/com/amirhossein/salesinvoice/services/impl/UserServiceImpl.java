package com.amirhossein.salesinvoice.services.impl;

import com.amirhossein.salesinvoice.converters.user.ReqToUser;
import com.amirhossein.salesinvoice.converters.user.UserToRes;
import com.amirhossein.salesinvoice.exceptions.NotFoundException;
import com.amirhossein.salesinvoice.models.user.User;
import com.amirhossein.salesinvoice.models.user.UserReq;
import com.amirhossein.salesinvoice.models.user.UserRes;
import com.amirhossein.salesinvoice.repositories.UserRepository;
import com.amirhossein.salesinvoice.services.UserDetailService;
import com.amirhossein.salesinvoice.services.service.UserService;
import com.amirhossein.salesinvoice.utils.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final JwtUtility jwtUtility;
    private UserRepository userRepository;
    private UserToRes userToRes;
    private ReqToUser reqToUser;

    @Autowired
    public UserServiceImpl(JwtUtility jwtUtility, UserRepository userRepository, UserToRes userToRes, ReqToUser reqToUser) {
        this.jwtUtility = jwtUtility;
        this.userRepository = userRepository;
        this.userToRes = userToRes;
        this.reqToUser = reqToUser;
    }

    @Override
    public List<UserRes> getAllUsers() {
        List<User> users = userRepository.findAll();

        List<UserRes> res = new ArrayList<>();

        for (int i = 0; i < users.size(); i++) {
            res.add(userToRes.convert(users.get(i)));
        }

        return res;
    }

    @Override
    public UserRes getUserById(UUID userId) {
        Optional<User> user = userRepository.findById(userId);

        UserRes res = userToRes.convert(user.get());

        return res;
    }

    @Override
    public UserRes createUser(UserReq userReq) {
        User user = reqToUser.convert(userReq);

        userRepository.save(user);

        UserRes res = userToRes.convert(user);

        return res;
    }

    @Override
    public UserRes userLogin(String username ,String password) {

        Optional<User> user = userRepository.findAllByVerifiedIsTrueAndUserNameAndPasswordIs(username , password);

        if (user.isPresent()){

            UserDetails userDetails = new UserDetailService().loadUserByUsername(username);

            UserRes userRes = userToRes.convert(user.get());

            userRes.setToken(jwtUtility.generateToken(userDetails));
            userRes.setRefreshToken(jwtUtility.generateRefreshToken(userDetails));

            return userRes;

        } else {
            throw new NotFoundException("No User Found With Username : " + username);
        }
    }
}
