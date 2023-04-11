package com.techelevator.dao;

import com.techelevator.model.Tournament;

import java.sql.SQLException;
import java.util.List;

public interface TournamentDao {

    // Create
    void addTournament(Tournament tournament) throws SQLException;
    Tournament createTournament(Tournament tournament);

    // Read
    List<Tournament> getAllTournaments() throws SQLException;
    Tournament getTournamentById(int id) throws SQLException;

    // Update
    void updateTournament(Tournament tournament) throws SQLException;

    // Delete
    void deleteTournament(Tournament tournament) throws SQLException;

    // POST A NEW TOURNAMENT

    // EDIT A TOURNAMENT

    // GET LIST OF ALL TOURNAMENTS

    // GET LIST OF PAST TOURNAMENTS

    // GET LIST OF PRESENT AND FUTURE TOURNAMENTS

    // GET TOURNAMENT DETAILS
}
