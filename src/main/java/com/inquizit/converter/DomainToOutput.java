package com.inquizit.converter;

import com.inquizit.model.domain.User;
import com.inquizit.model.output.UserOutput;

public class DomainToOutput {

    private DomainToOutput () {
    }

    /**
     * Converts a user object in domain format to output format by changing the role type from
     * {@link com.inquizit.model.enums.RoleType} to int
     *
     * @param user object in domain format
     * @return a {@link UserOutput} object
     */
    public static UserOutput convert(User user) {
        return new UserOutput(user.getEmail(), user.getName(), user.getType().getValue());
    }

}
