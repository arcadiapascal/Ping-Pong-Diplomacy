package com.techelevator.dao;

import com.techelevator.model.Tournament;

import java.sql.SQLException;
import java.util.List;

public interface TournamentDao {

    // Create
    void createTournament(Tournament tournament) throws SQLException;

    // Read
    List<Tournament> getAllTournaments() throws SQLException;
    Tournament getTournamentById(int id) throws SQLException;
    List<Tournament> getTournamentsByLevel(String level) throws SQLException;
    List<Tournament> getActiveTournaments(boolean active) throws SQLException;
    List<Tournament> getPastTournaments() throws SQLException;
    List<Tournament> getFutureTournaments() throws SQLException;

    // Update
    void updateTournament(int id, Tournament tournament) throws SQLException;

    // Delete
    void deleteTournament(int id) throws SQLException;

    // ADD A PLAYER TO A TOURNAMENT
    public void addPlayerToTournament(int tournamentId, int playerId) throws SQLException;

    // REMOVE A PLAYER FROM A TOURNAMENT
    public void removePlayerFromTournament(int tournamentId, int playerId) throws SQLException;

    // ADD A TEAM TO A TOURNAMENT
    public void addTeamToTournament(int tournamentId, int teamId) throws SQLException;

    // REMOVE A TEAM FROM A TOURNAMENT
    public void removeTeamFromTournament(int tournamentId, int teamId) throws SQLException;




}
