package com.codegym.services;

import com.codegym.models.User;

public interface IUserService {
    User findUserByEmail(String email);
}
