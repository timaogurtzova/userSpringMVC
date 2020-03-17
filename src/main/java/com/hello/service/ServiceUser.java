package com.hello.service;

import com.hello.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceUser {

    List<User> getAllUserService();
    User getUserByIdService(long id);
    User getUserWithNameAndPasswordService(String name, String password);
    void updateUserByIdService(User user);
    void addUserService(User user);
    void deleteUserById(long id);

}
