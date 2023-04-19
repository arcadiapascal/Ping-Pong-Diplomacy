package com.techelevator.dao;

import com.techelevator.model.Tournament;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTournamentDao implements TournamentDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcTournamentDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // CREATE A NEW TOURNAMENT
    @Override
    public void createTournament(Tournament tournament) {
        String sql = "INSERT INTO tournament (tournament_name, tournament_description, player_count, tournament_date, location, tournament_address, skill_level, active, registration_deadline) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, tournament.getTournamentName(), tournament.getTournamentDescription(),
                tournament.getNumberOfPlayers(), tournament.getDate(), tournament.getLocation(),
                tournament.getAddress(), tournament.getLevel(), tournament.isActive(),
                tournament.getRegistrationDeadline());
    }

    // UPDATE A TOURNAMENT
    @Override
    public void updateTournament(int id, Tournament tournament) throws SQLException {
        String sql = "UPDATE tournament SET tournament_name = ?, tournament_description = ?, " +
                "player_count = ?, tournament_date = ?, location = ?, tournament_address = ?, skill_level = ?, active = ?, " +
                "registration_deadline = ? WHERE tournament_id = ?";
        jdbcTemplate.update(sql, tournament.getTournamentName(), tournament.getTournamentDescription(),
                tournament.getNumberOfPlayers(), tournament.getDate(), tournament.getLocation(), tournament.getAddress(),
                tournament.getLevel(), tournament.isActive(), tournament.getRegistrationDeadline(),
                id);
    }

    // LIST ALL TOURNAMENTS
    @Override
    public List<Tournament> getAllTournaments() {
        List<Tournament> tournaments = new ArrayList<>();
        String sql = "SELECT * FROM tournament";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Tournament tournament = mapRowToTournament(results);
            tournaments.add(tournament);
        }
        return tournaments;
    }

    // GET TOURNAMENT BY ID
    @Override
    public Tournament getTournamentById(int id) {
        String sql = "SELECT * FROM tournament WHERE tournament_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            return mapRowToTournament(results);
        } else {
            return null;
        }
    }

    // GET TOURNAMENTS BY SKILL LEVEL
    @Override
    public List<Tournament> getTournamentsByLevel(String level) {
        List<Tournament> tournaments = new ArrayList<>();
        String sql = "SELECT * FROM tournament WHERE skill_level = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, level);
        while (results.next()) {
            Tournament tournament = mapRowToTournament(results);
            tournaments.add(tournament);
        }
        return tournaments;
    }

    // GET ACTIVE TOURNAMENTS
    @Override
    public List<Tournament> getActiveTournaments(boolean active) {
        List<Tournament> tournaments = new ArrayList<>();
        String sql = "SELECT * FROM tournament WHERE active = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, active);
        while (results.next()) {
            Tournament tournament = mapRowToTournament(results);
            tournaments.add(tournament);
        }
        return tournaments;
    }

    // GET PAST TOURNAMENTS
    @Override
    public List<Tournament> getPastTournaments() {
        List<Tournament> tournaments = new ArrayList<>();
        String sql = "SELECT * FROM tournament WHERE tournament_date < ?";
        Timestamp today = Timestamp.valueOf(LocalDateTime.now());
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, today);
        while (results.next()) {
            Tournament tournament = mapRowToTournament(results);
            tournaments.add(tournament);
        }
        return tournaments;
    }

    // GET FUTURE TOURNAMENTS
    @Override
    public List<Tournament> getFutureTournaments() {
        List<Tournament> tournaments = new ArrayList<>();
        String sql = "SELECT * FROM tournament WHERE tournament_date >= ?";
        LocalDate today = LocalDate.now();
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, today);
        while (results.next()) {
            Tournament tournament = mapRowToTournament(results);
            tournaments.add(tournament);
        }
        return tournaments;
    }

    // DELETE TOURNAMENT
    @Override
    public void deleteTournament(int id) throws SQLException {
        String sql = "DELETE FROM tournament WHERE tournament_id = ?";
        jdbcTemplate.update(sql, id);
    }

    // ADD A PLAYER TO A TOURNAMENT
    @Override
    public void addPlayerToTournament(int tournamentId, int playerId) {
        String sql = "INSERT INTO tournament_player (tournament_id, player_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, tournamentId, playerId);
    }

    // REMOVE A PLAYER FROM A TOURNAMENT
    @Override
    public void removePlayerFromTournament(int tournamentId, int playerId) {
        String sql = "DELETE FROM tournament_player WHERE tournament_id = ? AND player_id = ?";
        jdbcTemplate.update(sql, tournamentId, playerId);
    }

    // ADD A TEAM TO A TOURNAMENT
    @Override
    public void addTeamToTournament(int tournamentId, int teamId) {
        String sql = "INSERT INTO tournament_team (tournament_id, team_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, tournamentId, teamId);
    }

    // REMOVE A TEAM FROM A TOURNAMENT
    @Override
    public void removeTeamFromTournament(int tournamentId, int teamId) {
        String sql = "DELETE FROM tournament_team WHERE tournament_id = ? AND team_id = ?";
        jdbcTemplate.update(sql, tournamentId, teamId);
    }





    private Tournament mapRowToTournament (SqlRowSet results){
        Tournament tournament = new Tournament();
        tournament.setId(results.getInt("tournament_id"));
        tournament.setTournamentName(results.getString("tournament_name"));
        tournament.setTournamentDescription(results.getString("tournament_description"));
        tournament.setNumberOfPlayers(results.getInt("player_count"));
        tournament.setDate(results.getTimestamp("tournament_date"));
        tournament.setAddress(results.getString("tournament_address"));
        tournament.setLocation(results.getString("location"));
        tournament.setLevel(results.getString("skill_level"));
        tournament.setActive(results.getBoolean("active"));
        tournament.setRegistrationDeadline(results.getDate("registration_deadline"));
        return tournament;
    }
}
