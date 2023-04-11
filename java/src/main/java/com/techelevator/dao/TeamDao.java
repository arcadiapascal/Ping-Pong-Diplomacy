package com.techelevator.dao;

import com.techelevator.model.Team;

import java.sql.SQLException;
import java.util.List;

public interface TeamDao {

    // Create
    void addTeam(Team team) throws SQLException;
    Team createNewTeam(Team team);

    // Read
    List<Team> getAllTeams() throws SQLException;
    List<Team> listTeamsInState(String state);
    List<Team> listTeamsInCity(String city);
    Team getTeamByName(String name);

    // Update
    void updateTeam(Team team) throws SQLException;

    // Delete
    void deleteTeam(Team team) throws SQLException;


}
