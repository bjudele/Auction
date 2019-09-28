package com.sda.auction.service;

import com.sda.auction.dto.UserForm;
import com.sda.auction.model.User;
import java.util.Optional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public interface UserService {

	void saveUser(UserForm userForm);

	User findByEmail(String email);

	User getLoggedUser();

	String getLoggedInUserEmail();
}
