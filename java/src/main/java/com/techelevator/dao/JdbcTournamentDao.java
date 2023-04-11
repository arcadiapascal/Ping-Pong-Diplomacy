package com.techelevator.dao;

import com.techelevator.model.Tournament;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class JdbcTournamentDao implements TournamentDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTournamentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Tournament> findAll() {
        List<Tournament> tournaments = new ArrayList<>();
        String sql = "select * from tournament";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Tournament tournament = mapRowToTournament(results);
            tournaments.add(tournament);
        }

        return tournaments;
    }

    @Override
    public Tournament getTournamentById(int id) {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            return mapRowToTournament(results);
        } else {
            return null;
        }
    }

    @Override
    public Tournament findByTournamentName(String tournamentName) {
        if (tournamentName == null) throw new IllegalArgumentException("Username cannot be null");

        for (Tournament tournament : this.findAll()) {
            if (tournament.getTournamentName().equalsIgnoreCase(tournamentName)) {
                return tournament;
            }
        }
        throw new UsernameNotFoundException("User " + tournamentName + " was not found.");
    }


    @Override
    public boolean create(int id, String tournamentName, String tournamentDescription, int numberOfPlayers, String date, String location, String level, boolean active, String registrationDeadline){
        String insertUserSql = "insert into tournaments (tournamentName,tournamentDescription,numberOfPlayers,date,location,level,active,registrationDeadline) values (?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(insertUserSql, tournamentName, tournamentDescription, numberOfPlayers, date, location, level, active, registrationDeadline) == 1;
    }


    private Tournament mapRowToTournament(SqlRowSet rs) {
        Tournament tournament = new Tournament();
        tournament.setId(rs.getInt("tournament_id"));
        tournament.setTournamentName(rs.getString("tournament_name"));
        tournament.setTournamentDescription(rs.getString("tournament_description"));
        tournament.setNumberOfPlayers(rs.getInt("number_of_players"));
        tournament.setDate(rs.getString("date"));
        tournament.setLocation(rs.getString("location"));
        tournament.setLevel(rs.getString("level"));
        tournament.setActive(rs.getBoolean("active"));
        tournament.setRegistrationDeadline(rs.getString("registration_deadline"));
        return tournament;
    }
}

