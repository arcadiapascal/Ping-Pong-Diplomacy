package com.techelevator.dao;

import com.techelevator.model.Tournament;

import java.sql.SQLException;
import java.util.Date;
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
    void updateTournament(Tournament tournament) throws SQLException;

    // Delete
    void deleteTournament(Tournament tournament) throws SQLException;

}
