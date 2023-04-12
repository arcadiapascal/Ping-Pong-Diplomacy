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
    private JdbcTemplate jdbcTemplate;

    public JdbcPlayerDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // Create
    @Override
    public void addPlayer(Player player) throws SQLException {
        String sql = "INSERT INTO players (username, name, age, city, state, wins, losses, total_points, ppg, right_or_left_handed) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, player.getUsername(), player.getName(), player.getAge(), player.getCity(),
                player.getState(), player.getWins(), player.getLosses(), player.getTotalPoints(), player.getPpg(),
                player.getRightOrLeftHanded());
    }

//    @Override
//    public Player makeUserPlayer(Player player) {
//        // Logic to create user player
//    }

    // Read
    @Override
    public List<Player> getAllPlayers() throws SQLException {
        String sql = "SELECT * FROM players";
        List<Player> players = jdbcTemplate.query(sql, new RowMapper<Player>() {
            @Override
            public Player mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Player(
                        resultSet.getInt("player_id"),
                        resultSet.getString("username"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("city"),
                        resultSet.getString("state"),
                        resultSet.getInt("wins"),
                        resultSet.getInt("losses"),
                        resultSet.getInt("total_points"),
                        resultSet.getDouble("ppg"),
                        resultSet.getString("right_or_left_handed")
                );
            }
        });
        return players;
    }

    @Override
    public Player getPlayerById(int id) throws SQLException {
        String sql = "SELECT * FROM players WHERE player_id = ?";
        Player player = jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<Player>() {
            @Override
            public Player mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Player(
                        resultSet.getInt("player_id"),
                        resultSet.getString("username"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("city"),
                        resultSet.getString("state"),
                        resultSet.getInt("wins"),
                        resultSet.getInt("losses"),
                        resultSet.getInt("total_points"),
                        resultSet.getDouble("ppg"),
                        resultSet.getString("right_or_left_handed")
                );
            }
        });
        return player;
    }

    // Update
    @Override
    public void updatePlayer(Player player) throws SQLException {
        String sql = "UPDATE players SET username = ?, name = ?, age = ?, city = ?, state = ?, " +
                "wins = ?, losses = ?, total_points = ?, ppg = ?, right_or_left_handed = ? WHERE player_id = ?";
        jdbcTemplate.update(sql, player.getUsername(), player.getName(), player.getAge(), player.getCity(),
                player.getState(), player.getWins(), player.getLosses(), player.getTotalPoints(), player.getPpg(),
                player.getRightOrLeftHanded(), player.getPlayerId());
    }

    // Delete
    @Override
    public void deletePlayer(Player player) throws SQLException {
        String sql = "DELETE FROM players WHERE player_id = ?";
        jdbcTemplate.update(sql, player.getPlayerId());
    }
}
