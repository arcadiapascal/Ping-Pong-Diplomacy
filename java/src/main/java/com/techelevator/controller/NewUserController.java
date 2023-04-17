package com.techelevator.controller;
import com.techelevator.dao.NewUserDao;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
@PreAuthorize("isAuthenticated()")
@RestController
public class NewUserController {
    private NewUserDao newUserDao;

    public NewUserController(NewUserDao newUserDao) {
        this.newUserDao = newUserDao;
    }
    @CrossOrigin
    @RequestMapping(path = "/username/1/{username}", method = RequestMethod.GET)
    public User findByUsername(@PathVariable String username) {
        User user = newUserDao.findByUsername(username);
       int a =2;
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found");
        } else {
            return user;
        }
    }
}
