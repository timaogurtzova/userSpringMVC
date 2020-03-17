package com.hello.dao;

import com.hello.exception.DBException;
import com.hello.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUser() throws DBException;

    User getUserById(long id) throws DBException;

    User getUserWithNameAndPassword(String name, String password) throws DBException;

    void updateUserById(User newParameterUser) throws DBException;

    void addUser(User user) throws DBException;

    void deleteUserById(long id) throws DBException;
}