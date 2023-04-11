package com.techelevator.dao;

import com.techelevator.model.Tournament;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class JdbcTournamentDao implements TournamentDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcTournamentDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final RowMapper<Tournament> tournamentMapper = new RowMapper<Tournament>() {
        @Override
        public Tournament mapRow(ResultSet rs, int rowNum) throws SQLException {
            Tournament tournament = new Tournament();
            tournament.setId(rs.getInt("id"));
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
    };

    @Override
    public void addTournament(Tournament tournament) {
        String sql = "INSERT INTO tournament (tournament_name, tournament_description, number_of_players, date, location, level, active, registration_deadline) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, tournament.getTournamentName(), tournament.getTournamentDescription(), tournament.getNumberOfPlayers(),
                tournament.getDate(), tournament.getLocation(), tournament.getLevel(), tournament.isActive(), tournament.getRegistrationDeadline());
    }

//    @Override
//    public Tournament createNewTournament(Tournament tournament) {
//        addTournament(tournament);
//        return getTournamentByName(tournament.getTournamentName());
//    }

    @Override
    public List<Tournament> getAllTournaments() {
        String sql = "SELECT * FROM tournament";
        return jdbcTemplate.query(sql, tournamentMapper);
    }

//    @Override
//    public List<Tournament> getActiveTournaments() {
//        String sql = "SELECT * FROM tournament WHERE active = ?";
//        return jdbcTemplate.query(sql, tournamentMapper, true);
//    }

    @Override
    public Tournament getTournamentById(int id) {
        String sql = "SELECT * FROM tournament WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, tournamentMapper, id);
    }

//    @Override
//    public Tournament getTournamentByName(String name) {
//        String sql = "SELECT * FROM tournament WHERE tournament_name = ?";
//        return jdbcTemplate.queryForObject(sql, tournamentMapper, name);
//    }

    @Override
    public void updateTournament(Tournament tournament) {
        String sql = "UPDATE tournament SET tournament_name = ?, tournament_description = ?, number_of_players = ?, date = ?, location = ?, " +
                "level = ?, active = ?, registration_deadline = ? WHERE id = ?";
        jdbcTemplate.update(sql, tournament.getTournamentName(), tournament.getTournamentDescription(), tournament.getNumberOfPlayers(),
                tournament.getDate(), tournament.getLocation(), tournament.getLevel(), tournament.isActive(), tournament.getRegistrationDeadline(), tournament.getId());
    }

    @Override
    public void deleteTournament(Tournament tournament) {
        String sql = "DELETE FROM tournament WHERE id = ?";
        jdbcTemplate.update(sql, tournament.getId());
    }
}

