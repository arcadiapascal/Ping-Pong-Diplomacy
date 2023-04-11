package com.techelevator.dao;

import com.techelevator.model.Team;

import java.sql.SQLException;
import java.util.List;

public interface TeamDao {

    // Create
    void addTeam(Team team) throws SQLException;

    // Read
    List<Team> getAllTeams() throws SQLException;
    List<Team> listTeamsInState(String state) throws SQLException;
    List<Team> listTeamsInCity(String city) throws SQLException;
    Team getTeamByName(String name) throws SQLException;
    Team getTeamById(int id) throws SQLException;

    // Update
    void updateTeam(Team team) throws SQLException;

    // Delete
    void deleteTeam(Team team) throws SQLException;

}
