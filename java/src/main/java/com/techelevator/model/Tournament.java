package com.techelevator.model;

public class Tournament {

    private int id;
    private String tournamentName;
    private String tournamentDescription;
    private int numberOfPlayers;
    private String date;
    private String location;
    private String level;
    private boolean active;
    private String registrationDeadline;

    public Tournament() { }

    public Tournament(int id, String tournamentName, String tournamentDescription, int numberOfPlayers, String date, String location, String level, boolean active, String registrationDeadline) {
        this.id = id;
        this.tournamentName = tournamentName;
        this.tournamentDescription = tournamentDescription;
        this.numberOfPlayers = numberOfPlayers;
        this.date = date;
        this.location = location;
        this.level = level;
        this.active = active;
        this.registrationDeadline = registrationDeadline;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public String getTournamentDescription() {
        return tournamentDescription;
    }

    public void setTournamentDescription(String tournamentDescription) {
        this.tournamentDescription = tournamentDescription;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRegistrationDeadline() {
        return registrationDeadline;
    }

    public void setRegistrationDeadline(String registrationDeadline) {
        this.registrationDeadline = registrationDeadline;
    }
}

