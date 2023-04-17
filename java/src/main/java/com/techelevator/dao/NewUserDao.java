package com.techelevator.dao;
import com.techelevator.model.Tournament;
import com.techelevator.model.User;

import java.sql.SQLException;
import java.util.List;
public interface NewUserDao {
    User findByUsername(String username);

    List<User> findAll();
}
