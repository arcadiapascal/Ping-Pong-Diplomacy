package com.techelevator.dao;

import com.techelevator.model.Player;

import java.sql.SQLException;
import java.util.List;

public interface PlayerDao {

    // Create
    void addPlayer(Player player) throws SQLException;

    //
    List<Player> getAllPlayersFromTournament(int tournamentId);

    // Read
    List<Player> getAllPlayers() throws SQLException;
    Player getPlayerById(int id) throws SQLException;

    // Update
    void updatePlayer(Player player) throws SQLException;

    // Delete
    void deletePlayer(Player player) throws SQLException;
}

