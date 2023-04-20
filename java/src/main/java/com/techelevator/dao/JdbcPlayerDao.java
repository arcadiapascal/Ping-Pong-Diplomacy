package com.techelevator.dao;

import com.techelevator.model.Player;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class JdbcPlayerDao implements PlayerDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcPlayerDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // GET ALL PLAYERS FROM TOURNAMENT
    @Override
    public List<Player> getAllPlayersFromTournament(int tournamentId){
        String sql = "select player.player_id, user_id, player_name, age, city, state_abbrev, wins, losses, win_percentage, ranking, total_points, email,right_left_handed,photo_file,photo\n" +
                "from tournament_player\n" +
                "join player on tournament_player.player_id = player.player_id\n" +
                "join tournament on tournament_player.tournament_id = tournament.tournament_id\n" +
                "where tournament.tournament_id = ?";
        return jdbcTemplate.query(sql, new PlayerMapper(), tournamentId);
    }

    // CREATES A NEW PLAYER
    @Override
    public void addPlayer(Player player) throws SQLException {
        String sql = "INSERT INTO player (user_id, player_name, age, city, state_abbrev, " +
                "right_left_handed, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, player.getUserId(), player.getPlayerName(), player.getAge(),
                player.getCity(), player.getStateAbbrev(), player.getRightLeftHanded(), player.getEmail());
    }

    // LISTS ALL PLAYERS
    @Override
    public List<Player> getAllPlayers() throws SQLException {
        String sql = "SELECT * FROM player";
        return jdbcTemplate.query(sql, new PlayerMapper());
    }

    // GETS A PLAYER BY ID
    @Override
    public Player getPlayerById(int id) throws SQLException {
        String sql = "SELECT * FROM player WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql, new PlayerMapper(), id);
    }

    // UPDATES A PLAYER
    @Override
    public void updatePlayer(Player player) throws SQLException {
        String sql = "UPDATE player SET user_id = ?, player_name = ?, age = ?, city = ?, " +
                "state_abbrev = ?, wins = ?, losses = ?, win_percentage = ?, ranking = ?, " +
                "total_points = ?, right_left_handed = ?, email = ?, photo_file = ?, photo = ? " +
                "WHERE user_id = ?";
        jdbcTemplate.update(sql, player.getUserId(), player.getPlayerName(), player.getAge(),
                player.getCity(), player.getStateAbbrev(), player.getWins(), player.getLosses(),
                player.getWinPercentage(), player.getRanking(), player.getTotalPoints(),
                player.getRightLeftHanded(), player.getEmail(), player.getPhotoFile(), player.getPhoto(),
                player.getPlayerId());
    }

    // DELETES A PLAYER
    @Override
    public void deletePlayer(Player player) throws SQLException {
        String sql = "DELETE FROM player WHERE player_id = ?";
        jdbcTemplate.update(sql, player.getPlayerId());
    }

    private static final class PlayerMapper implements RowMapper<Player> {

        @Override
        public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
            Player player = new Player();
            player.setPlayerId(rs.getInt("player_id"));
            player.setUserId(rs.getInt("user_id"));
            player.setPlayerName(rs.getString("player_name"));
            player.setAge(rs.getInt("age"));
            player.setCity(rs.getString("city"));
            player.setStateAbbrev(rs.getString("state_abbrev"));
            player.setWins(rs.getInt("wins"));
            player.setLosses(rs.getInt("losses"));
            player.setWinPercentage(rs.getBigDecimal("win_percentage"));
            player.setRanking(rs.getInt("ranking"));
            player.setTotalPoints(rs.getInt("total_points"));
            player.setRightLeftHanded(rs.getString("right_left_handed").charAt(0));
            player.setEmail(rs.getString("email"));
            player.setPhotoFile(rs.getString("photo_file"));
            player.setPhoto(rs.getBytes("photo"));
            return player;
        }
    }
}
