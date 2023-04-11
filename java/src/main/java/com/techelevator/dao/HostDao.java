package com.techelevator.dao;

import com.techelevator.model.Host;

import java.sql.SQLException;
import java.util.List;

public interface HostDao {

    // Create
    void addHost(Host host) throws SQLException;
//    Host makeUserHost(Host host);

    // Read
    List<Host> getAllHosts() throws SQLException;
    Host getHostById(int id) throws SQLException;

    // Update
    void updateHost(Host host) throws SQLException;

    // Delete
    void deleteHost(Host host) throws SQLException;

}
