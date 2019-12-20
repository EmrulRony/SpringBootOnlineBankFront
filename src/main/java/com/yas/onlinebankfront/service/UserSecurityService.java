package com.yas.onlinebankfront.service;

import com.yas.onlinebankfront.dao.UserDao;
import com.yas.onlinebankfront.entities.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    public static final Logger LOG = LoggerFactory.getLogger(UserSecurityService.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null){
            LOG.error("USERNAME not found", username);
            throw new UsernameNotFoundException("Username "+username + " Not Found!");
        }
        return user; 
    }
    
}