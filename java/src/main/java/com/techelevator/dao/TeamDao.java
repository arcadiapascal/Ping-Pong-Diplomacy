package com.techelevator.dao;

import com.techelevator.model.Team;
import com.techelevator.model.Tournament;

import java.util.List;

public interface TeamDao {

    List<Team> findAll();

    Team getTournamentById(int id);

    Team findByTournamentName(String tournamentName);

    boolean create(int id, String teamName, String teamDescription, String address, String city, String state);

}
