package com.techelevator.dao;

import com.techelevator.model.Tournament;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTournamentDao implements TournamentDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcTournamentDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Tournament createTournament(Tournament tournament) {
        String sql = "INSERT INTO tournaments (tournament_name, tournament_description, number_of_players, date, location, level, active, registration_deadline) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, tournament.getTournamentName(), tournament.getTournamentDescription(),
                tournament.getNumberOfPlayers(), tournament.getDate(), tournament.getLocation(),
                tournament.getLevel(), tournament.isActive(), tournament.getRegistrationDeadline());

        sql = "SELECT tournament_id, tournament_name, tournament_description, number_of_players, date, location, level, active, registration_deadline " +
                "FROM tournaments WHERE tournament_name = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, tournament.getTournamentName());
        if (results.next()) {
            return mapRowToTournament(results);
        } else {
            throw new RuntimeException("Error creating tournament");
        }
    }


    @Override
    public List<Tournament> getAllTournaments() {
        List<Tournament> tournaments = new ArrayList<>();
        String sql = "SELECT * FROM tournaments";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Tournament tournament = mapRowToTournament(results);
            tournaments.add(tournament);
        }
        return tournaments;
    }

    @Override
    public Tournament getTournamentById(int id) {
        String sql = "SELECT * FROM tournaments WHERE tournament_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            return mapRowToTournament(results);
        } else {
            return null;
        }
    }

    @Override
    public List<Tournament> getTournamentsByLevel(String level) {
        List<Tournament> tournaments = new ArrayList<>();
        String sql = "SELECT * FROM tournaments WHERE level = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, level);
        while (results.next()) {
            Tournament tournament = mapRowToTournament(results);
            tournaments.add(tournament);
        }
        return tournaments;
    }

    @Override
    public List<Tournament> getActiveTournaments(boolean active) {
        List<Tournament> tournaments = new ArrayList<>();
        String sql = "SELECT * FROM tournaments WHERE active = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, active);
        while (results.next()) {
            Tournament tournament = mapRowToTournament(results);
            tournaments.add(tournament);
        }
        return tournaments;
    }

    @Override
    public List<Tournament> getPastTournaments() {
        List<Tournament> tournaments = new ArrayList<>();
        String sql = "SELECT * FROM tournament WHERE date < ?";
        LocalDate today = LocalDate.now();
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, today);
        while (results.next()) {
            Tournament tournament = mapRowToTournament(results);
            tournaments.add(tournament);
        }
        return tournaments;
    }

    @Override
    public List<Tournament> getFutureTournaments() {
        List<Tournament> tournaments = new ArrayList<>();
        String sql = "SELECT * FROM tournaments WHERE date >= ?";
        LocalDate today = LocalDate.now();
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, today);
        while (results.next()) {
            Tournament tournament = mapRowToTournament(results);
            tournaments.add(tournament);
        }
        return tournaments;
    }

    @Override
    public void updateTournament(int id, Tournament tournament) throws SQLException {
        String sql = "UPDATE tournaments SET tournament_name = ?, tournament_description = ?, " +
                "number_of_players = ?, date = ?, location = ?, level = ?, active = ?, " +
                "registration_deadline = ? WHERE id = ?";
        jdbcTemplate.update(sql, tournament.getTournamentName(), tournament.getTournamentDescription(),
                tournament.getNumberOfPlayers(), tournament.getDate(), tournament.getLocation(),
                tournament.getLevel(), tournament.isActive(), tournament.getRegistrationDeadline(),
                id);
    }

    @Override
    public void deleteTournament(int id) throws SQLException {
        String sql = "DELETE FROM tournaments WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    // ADD A PLAYER TO A TOURNAMENT
    // REMOVE A PLAYER FROM A TOURNAMENT
    // ADD A TEAM TO A TOURNAMENT
    // REMOVE A TEAM FROM A TOURNAMENT


    private Tournament mapRowToTournament (SqlRowSet results){
        Tournament tournament = new Tournament();
        tournament.setId(results.getInt("tournament_id"));
        tournament.setTournamentName(results.getString("tournament_name"));
        tournament.setTournamentDescription(results.getString("tournament_description"));
        tournament.setNumberOfPlayers(results.getInt("number_of_players"));
        tournament.setDate(results.getString("date"));
        tournament.setLocation(results.getString("location"));
        tournament.setLevel(results.getString("level"));
        tournament.setActive(results.getBoolean("active"));
        tournament.setRegistrationDeadline(results.getString("registration_deadline"));
        return tournament;
    }
}
