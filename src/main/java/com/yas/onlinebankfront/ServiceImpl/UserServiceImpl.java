package com.yas.onlinebankfront.ServiceImpl;

import java.util.List;
import java.util.Set;

import com.yas.onlinebankfront.dao.UserDao;
import com.yas.onlinebankfront.entities.User;
import com.yas.onlinebankfront.entities.security.UserRole;
import com.yas.onlinebankfront.service.AccountService;
import com.yas.onlinebankfront.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserDao userDao;

    @Autowired
    AccountService accountService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
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
        if (checkUsernameExists(username) || checkEmailExists(email)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean checkUsernameExists(String username) {
        if (findByUsername(username) != null) {
            LOG.debug("Username found!!");
            return true;
        }
        return false;
    }

    @Override
    public boolean checkEmailExists(String email) {
        if (findByEmail(email) != null) {
            return true;
        }
        return false;
    }

    @Override
    public User createUser(User user, Set<UserRole> userRoles) {
        System.out.println("Inside createUser met start");
        User localUser = userDao.findByUsername(user.getUsername());

        if (localUser != null){
            LOG.info("User with username {} already exists...", user.getUsername());
            return localUser;
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUserRoles(userRoles);
        user.setPrimaryAccount(accountService.createPrimaryAccount());
        user.setSavingsAccount(accountService.createSavingsAccount());
        System.out.println("Inside createUser met end");
        return userDao.save(user);
    }

    
}