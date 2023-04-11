package com.techelevator.controller;


import com.techelevator.dao.HostDao;
import com.techelevator.dao.PlayerDao;
import com.techelevator.dao.TeamDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
@RequestMapping("/tournaments")
public class TournamentController {

    @Autowired
    private UserDao userDao;
    private PlayerDao playerDao;
    private HostDao hostDao;
    private TeamDao teamDao;

    // POST A NEW TOURNAMENT

    // EDIT A TOURNAMENT

    // GET LIST OF ALL TOURNAMENTS

    // GET LIST OF PAST TOURNAMENTS

    // GET LIST OF PRESENT AND FUTURE TOURNAMENTS

    // GET TOURNAMENT DETAILS


    // TEAM METHODS

    // POST NEW TEAM
    @RequestMapping(path = "/teams", method = RequestMethod.POST)
    public void addTeam(@RequestBody Team team) throws SQLException {
        teamDao.addTeam(team);
    }

    // PUT EXISTING TEAM
    @RequestMapping(path = "/teams/{id}", method = RequestMethod.PUT)
    public void updateTeam(@PathVariable int id, @RequestBody Team team) throws SQLException {
        team.setId(id);
        teamDao.updateTeam(team);
    }

    // GET ALL TEAMS
    @RequestMapping(path = "/teams", method = RequestMethod.GET)
    public List<Team> getAllTeams() throws SQLException {
        return teamDao.getAllTeams();
    }

    // GET TEAM BY ID
    @RequestMapping(path = "/teams/{id}", method = RequestMethod.GET)
    public Team getTeamById(@PathVariable int id) throws SQLException {
        return teamDao.getTeamById(id);
    }

    // GET TEAM BY NAME
    @RequestMapping(path = "/teams/name/{name}", method = RequestMethod.GET)
    public Team getTeamByName(@PathVariable String name) throws SQLException {
        return teamDao.getTeamByName(name);
    }

    // GET TEAMS BY STATE
    @RequestMapping(path = "/teams/state/{state}", method = RequestMethod.GET)
    public List<Team> getTeamsByState(@PathVariable String state) throws SQLException {
        return teamDao.listTeamsInState(state);
    }

    // GET TEAMS BY CITY
    @RequestMapping(path = "/teams/city/{city}", method = RequestMethod.GET)
    public List<Team> getTeamsByCity(@PathVariable String city) throws SQLException {
        return teamDao.listTeamsInCity(city);
    }


}
