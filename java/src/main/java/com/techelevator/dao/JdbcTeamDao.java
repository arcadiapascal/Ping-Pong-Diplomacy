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

    @Override
    public void addTeam(Team team) throws SQLException {
        String sql = "INSERT INTO team (team_id, team_name, team_description, address, city, state) " +
                "VALUES (DEFAULT, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, team.getTeamName(), team.getTeamDescription(),
                team.getAddress(), team.getCity(), team.getState());
    }

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

    @Override
    public List<Team> listTeamsInState(String state) throws SQLException {
        List<Team> teams = new ArrayList<>();
        String sql = "SELECT * FROM team WHERE state = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, state);
        while (results.next()) {
            Team team = mapRowToTeam(results);
            teams.add(team);
        }
        return teams;
    }

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

    @Override
    public void updateTeam(Team team) throws SQLException {
        String sql = "UPDATE team SET team_name = ?, team_description = ?, address = ?, city = ?, state = ? " +
                "WHERE team_id = ?";
        jdbcTemplate.update(sql, team.getTeamName(), team.getTeamDescription(),
                team.getAddress(), team.getCity(), team.getState(), team.getId());
    }

    @Override
    public void deleteTeam(Team team) throws SQLException {
        String sql = "DELETE FROM TEAM WHERE ID = ?";
        jdbcTemplate.update(sql, team.getId());
    }

    private Team mapRowToTeam(SqlRowSet rs) {
        Team team = new Team();
        team.setId(rs.getInt("id"));
        team.setTeamName(rs.getString("team_name"));
        team.setTeamDescription(rs.getString("team_description"));
        team.setAddress(rs.getString("address"));
        team.setCity(rs.getString("city"));
        team.setState(rs.getString("state"));
        return team;
    }

}
