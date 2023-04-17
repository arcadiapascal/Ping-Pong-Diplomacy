package com.techelevator.controller;

import com.techelevator.dao.NewUserDao;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
@PreAuthorize("isAuthenticated()")
@RestController
public class RandomContoller {
    private NewUserDao newUserDao;

    public RandomContoller(NewUserDao newUserDao) {
        this.newUserDao = newUserDao;
    }
    @RequestMapping(path = "/username/{username}", method = RequestMethod.GET)
    public User findByUsername(@PathVariable String username) {
        User user = newUserDao.findByUsername(username);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found");
        } else {
            return user;
        }
    }
}
