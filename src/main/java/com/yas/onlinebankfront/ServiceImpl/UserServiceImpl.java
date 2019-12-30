package com.yas.onlinebankfront.ServiceImpl;

import java.util.List;

import com.yas.onlinebankfront.dao.UserDao;
import com.yas.onlinebankfront.entities.User;
import com.yas.onlinebankfront.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public List<User> findUserList() {

        return null;
    }

    @Override
    public void save(User user) {


    }

    @Override
    public User saveUser(User user) {

        return null;
    }

    @Override
    public boolean checkUserExists(String username, String email) {
        if ( checkUserExists(username, email) || checkEmailExists(email)){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkUsernameExists(String username) {
        if( findByUsername(username) !=null){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkEmailExists(String email) {
        if ( findByEmail(email) != null){
            return true;
        }
        return false;
    }
    
}