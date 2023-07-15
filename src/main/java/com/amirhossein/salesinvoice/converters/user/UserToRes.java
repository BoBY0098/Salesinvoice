package com.amirhossein.salesinvoice.converters.user;

import com.amirhossein.salesinvoice.models.user.User;
import com.amirhossein.salesinvoice.models.user.UserRes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToRes implements Converter<User , UserRes> {

    @Override
    public UserRes convert(User input) {

        UserRes output = new UserRes();

        output.setId(input.getId());

        output.setUserName(input.getUserName());
        output.setFirstName(input.getFirstName());
        output.setLastName(input.getLastName());
        output.setToken(null);
        output.setRefreshToken(null);

        return output;
    }
}
