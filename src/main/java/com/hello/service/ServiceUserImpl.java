package com.hello.service;

import com.hello.dao.UserDao;
import com.hello.exception.DBException;
import com.hello.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = DBException.class)
public class ServiceUserImpl implements ServiceUser {

    private static ServiceUserImpl serviceUserImpl;

    private final UserDao userDAO;

    @Autowired
    private ServiceUserImpl(UserDao userDAO) {
        this.userDAO = userDAO;
    }

    public static ServiceUserImpl getInstance() {
        return serviceUserImpl;
    }

    public List<User> getAllUserService() {
        List<User> users = null;
        try {
            users = userDAO.getAllUser();
        } catch (DBException e) {
            //ignore
        }
        return users;
    }

    public User getUserByIdService(long id) {
        User user = null;
        try {
            user = userDAO.getUserById(id);
        } catch (DBException e) {

        }
        return user;
    }

    public User getUserWithNameAndPasswordService(String name, String password) {
        User user = null;
        try {
            if (name != null && password != null)
                user = userDAO.getUserWithNameAndPassword(name, password);
        } catch (DBException e) {

        }
        return user;
    }

    public void updateUserByIdService(User user) {
        try {
            if (user != null) {
                userDAO.updateUserById(user);
            }
        } catch (DBException e) {

        }
    }

    public void addUserService(User user) {
        try {
            if (user != null) {
                userDAO.addUser(user);
            }
        } catch (DBException e) {

        }
    }

    public void deleteUserById(long id) {
        try {
            userDAO.deleteUserById(id);
        } catch (DBException e) {

        }
    }

}