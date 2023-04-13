package com.techelevator.dao;

import com.techelevator.model.Team;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTeamDao implements TeamDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcTeamDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // CREATES A NEW TEAM
    @Override
    public void addTeam(Team team) throws SQLException {
        String sql = "INSERT INTO team (team_name, description, city, state_abbrev) " +
                "VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, team.getTeamName(), team.getTeamDescription(),
                team.getCity(), team.getState());
    }

    // LISTS OUT ALL THE TEAMS
    @Override
    public List<Team> getAllTeams() throws SQLException {
        List<Team> teams = new ArrayList<>();
        String sql = "SELECT * FROM team";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Team team = mapRowToTeam(results);
            teams.add(team);
        }
        return teams;
    }

    // LISTS TEAMS IN A SPECIFIC STATE
    @Override
    public List<Team> listTeamsInState(String state) throws SQLException {
        List<Team> teams = new ArrayList<>();
        String sql = "SELECT * FROM team WHERE state_abbrev = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, state);
        while (results.next()) {
            Team team = mapRowToTeam(results);
            teams.add(team);
        }
        return teams;
    }

    // LISTS TEAMS IN A SPECIFIC CITY
    @Override
    public List<Team> listTeamsInCity(String city) throws SQLException {
        List<Team> teams = new ArrayList<>();
        String sql = "SELECT * FROM team WHERE city = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, city);
        while (results.next()) {
            Team team = mapRowToTeam(results);
            teams.add(team);
        }
        return teams;
    }

    // GETS A TEAM BY NAME
    @Override
    public Team getTeamByName(String name) throws SQLException {
        Team team = null;
        String sql = "SELECT * FROM team WHERE team_name = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
        if (results.next()) {
            team = mapRowToTeam(results);
        }
        return team;
    }

    // GETS A TEAM BY ID
    @Override
    public Team getTeamById(int id) throws SQLException {
        Team team = null;
        String sql = "SELECT * FROM team WHERE team_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            team = mapRowToTeam(results);
        }
        return team;
    }

    // UPDATES A TEAM
    @Override
    public void updateTeam(Team team) throws SQLException {
        String sql = "UPDATE team SET team_name = ?, description = ?, city = ?, state_abbrev = ? " +
                "WHERE team_id = ?";
        jdbcTemplate.update(sql, team.getTeamName(), team.getTeamDescription(),
                team.getCity(), team.getState(), team.getId());
    }

    // DELETE TEAM
    @Override
    public void deleteTeam(Team team) throws SQLException {
        String sql = "DELETE FROM TEAM WHERE TEAM_ID = ?";
        jdbcTemplate.update(sql, team.getId());
    }

    // ADDS A PLAYER TO A TEAM
    @Override
    public void addPlayerToTeam(int teamId, int playerId) {
        String sql = "INSERT INTO player_team (team_id, player_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, teamId, playerId);
    }

    // REMOVES A PLAYER FROM A TEAM
    @Override
    public void removePlayerFromTeam(int teamId, int playerId) {
        String sql = "DELETE FROM player_team WHERE team_id = ? AND player_id = ?";
        jdbcTemplate.update(sql, teamId, playerId);
    }

    private Team mapRowToTeam(SqlRowSet rs) {
        Team team = new Team();
        team.setId(rs.getInt("team_id"));
        team.setTeamName(rs.getString("team_name"));
        team.setTeamDescription(rs.getString("description"));
        team.setCity(rs.getString("city"));
        team.setState(rs.getString("state_abbrev"));
        return team;
    }

}
