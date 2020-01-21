package com.mengchen.assignment2.service;

import com.mengchen.assignment2.dao.UserDAO;
import com.mengchen.assignment2.dao.UserDAOImpl;
import com.mengchen.assignment2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public List<User> listAllUser() {
        return userDAO.listAllUser();
    }

    @Override
    @Transactional
    public User findByEmail(String theEmail) {
        return userDAO.findByEmail(theEmail);
    }

    @Override
    @Transactional
    public void updateUser(User theUser) {
        userDAO.updateUser(theUser);
    }

    @Override
    @Transactional
    public void deleteUser(String theUsername) {
        userDAO.deleteUser(theUsername);
    }
}
