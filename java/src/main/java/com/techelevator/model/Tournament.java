package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Tournament {

    @JsonProperty("tournamentId")
    private int id;
    @NotNull
    @JsonProperty("name")
    private String tournamentName;
    @NotNull
    @JsonProperty("description")
    private String tournamentDescription;
    private int numberOfPlayers;
    @NotNull
    @JsonProperty("tournamentDate")
    private Timestamp date;
    @NotNull
    private String location;
    @NotNull
    private String address;
    @NotNull
    @JsonProperty("skillLevel")
    private String level;
    @NotNull
    private boolean active;
    @NotNull
    private Date registrationDeadline;

    public Tournament() { }

    public Tournament(int id, String tournamentName, String tournamentDescription, int numberOfPlayers, Timestamp date, String location, String address, String level, boolean active, Date registrationDeadline) {
        this.id = id;
        this.tournamentName = tournamentName;
        this.tournamentDescription = tournamentDescription;
        this.numberOfPlayers = numberOfPlayers;
        this.date = date;
        this.location = location;
        this.address = address;
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

    public Timestamp getDate(){
        return date;
    }

    public void setDate(Timestamp date){
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Date getRegistrationDeadline() {
        return registrationDeadline;
    }

    public void setRegistrationDeadline(Date registrationDeadline) {
        this.registrationDeadline = registrationDeadline;
    }
}
