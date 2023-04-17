package com.techelevator.controller;

import com.techelevator.dao.HostDao;
import com.techelevator.dao.PlayerDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin(origins="*")
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDao userDao;
    private PlayerDao playerDao;
    private HostDao hostDao;


    // SHOW ALL APP USERS
    @RequestMapping(path = "/allUsers", method = RequestMethod.GET)
    public List<User> showUsers() {
        Principal principal = null;
        return userDao.findAll();
    }

    // GET SINGLE USER BY ID
    @RequestMapping(path = "/id/{userId}", method = RequestMethod.GET)
    public User getUserById(@PathVariable int userId) {
        User user = userDao.getUserById(userId);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found");
        } else {
            return user;
        }
    }

    // GET SINGLE USER BY USERNAME

    @RequestMapping(path = "/username/{username}", method = RequestMethod.GET)
    public User findByUsername(@PathVariable String username) {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found");
        } else {
            return user;
        }
    }

    // GETS A USER ID FROM THEIR USERNAME


}
