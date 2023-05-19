package com.e_nursing_portal.service;

import com.e_nursing_portal.DataTransferObject.UserRegistartionDto;
import com.e_nursing_portal.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserInterface extends UserDetailsService {
    public User saveAccount(UserRegistartionDto userRegistartionDto);
}
