package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDao userDao;


    // SHOW ALL APP USERS
    @RequestMapping(path = "/allUsers", method = RequestMethod.GET)
    public List<User> showUsers() {
        Principal principal = null;
        return userDao.findAll();
    }

    @RequestMapping(path = "/{userId}", method = RequestMethod.GET)
    public User getUserById(@PathVariable int userId) {
        User user = userDao.getUserById(userId);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found");
        } else {
            return user;
        }
    }


    // GET SINGLE USER BY ID
    @RequestMapping(path = "/{username}", method = RequestMethod.GET)
    public User findByUsername(@PathVariable String username) {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found");
        } else {
            return user;
        }
    }

    // GET


}
