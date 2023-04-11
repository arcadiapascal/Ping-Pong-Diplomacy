package com.techelevator.dao;

import com.techelevator.model.Tournament;

import java.util.List;

public interface TournamentDao {

    List<Tournament> findAll();

    Tournament getTournamentById(int id);

    Tournament findByTournamentName(String tournamentName);

    boolean create(int id, String tournamentName, String tournamentDescription, int numberOfPlayers, String date, String location, String level, boolean active, String registrationDeadline);

}
