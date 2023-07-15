package com.amirhossein.salesinvoice.converters.user;

import com.amirhossein.salesinvoice.models.user.User;
import com.amirhossein.salesinvoice.models.user.UserReq;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ReqToUser implements Converter<UserReq, User> {

    @Override
    public User convert(UserReq input) {

        User output = new User();

        output.setUserName(input.getUserName());
        output.setPassword(input.getPassword());
        output.setFirstName(input.getFirstName());
        output.setLastName(input.getLastName());
        output.setPhoneNumber(input.getPhoneNumber());

        return output;
    }
}
