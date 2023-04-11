package com.techelevator.dao;

import com.techelevator.model.Team;
import com.techelevator.model.Tournament;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class JdbcTeamDao implements TeamDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTeamDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
   public List<Team> findAll(){
        List<Team> teams = new ArrayList<>();
        String sql = "select * from team";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Team team = mapRowToTeam(results);
            teams.add(team);
        }

        return teams;
    }

    @Override
  public Team getTournamentById(int id){
        String sql = "SELECT * FROM users WHERE id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            return mapRowToTeam(results);
        } else {
            return null;
        }
    }

    @Override
  public   Team findByTournamentName(String teamName){
        if (teamName == null) throw new IllegalArgumentException("Username cannot be null");

        for (Team team : this.findAll()) {
            if (team.getTeamName().equalsIgnoreCase(teamName)) {
                return team;
            }
        }
        throw new UsernameNotFoundException("User " + teamName + " was not found.");
    }

    @Override
  public   boolean create(int id, String teamName, String teamDescription, String address, String city, String state){
    String insertUserSql = "insert into teams (teamName,teamDescription,address,city,state) values (?,?,?,?,?)";
        return jdbcTemplate.update(insertUserSql, teamName, teamDescription, address, city, state) == 1;
}

    private Team mapRowToTeam(SqlRowSet results) {
        Team team = new Team();
        team.setId(results.getInt("team_id"));
        team.setTeamName(results.getString("teamName"));
        team.setTeamDescription(results.getString("teamDescription"));
        team.setAddress(results.getString("address"));
        team.setCity(results.getString("city"));
        team.setState(results.getString("state"));

        return team;
    }

}
