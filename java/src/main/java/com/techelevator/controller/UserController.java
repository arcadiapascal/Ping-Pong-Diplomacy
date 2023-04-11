package com.techelevator.controller;

import com.techelevator.dao.HostDao;
import com.techelevator.dao.PlayerDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Host;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.sql.SQLException;
import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
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
    @RequestMapping(path = "/{userId}", method = RequestMethod.GET)
    public User getUserById(@PathVariable int userId) {
        User user = userDao.getUserById(userId);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found");
        } else {
            return user;
        }
    }

    // GET SINGLE USER BY USERNAME
    @RequestMapping(path = "/{username}", method = RequestMethod.GET)
    public User findByUsername(@PathVariable String username) {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found");
        } else {
            return user;
        }
    }

    // HOST METHODS

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/hosts", method = RequestMethod.POST)
    public void addHost(@RequestBody Host host) {
        try {
            hostDao.addHost(host);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error adding host", e);
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/hosts/{id}", method = RequestMethod.PUT)
    public void updateHost(@PathVariable int id, @RequestBody Host host) {
        Host existingHost;
        try {
            existingHost = hostDao.getHostById(id);
            if (existingHost == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Host not found");
            }
            existingHost.setHostName(host.getHostName());
            existingHost.setDescription(host.getDescription());
            existingHost.setCity(host.getCity());
            existingHost.setState(host.getState());
            existingHost.setUsername(host.getUsername());
            hostDao.updateHost(existingHost);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error updating host", e);
        }
    }

    @RequestMapping(value = "/hosts", method = RequestMethod.GET)
    public List<Host> getAllHosts() {
        try {
            return hostDao.getAllHosts();
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error getting hosts", e);
        }
    }


}
