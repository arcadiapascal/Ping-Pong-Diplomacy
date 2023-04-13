package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class Team {

    @JsonProperty("teamId")
    private int id;
    @NotNull
    private String teamName;
    private String teamDescription;
    @NotNull
    private String city;
    @NotNull
    private String state;


    public Team() { }

    public Team(int id, String teamName, String teamDescription, String city, String state) {
        this.id = id;
        this.teamName = teamName;
        this.teamDescription = teamDescription;
        this.city = city;
        this.state = state;

    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }


    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamDescription() {
        return teamDescription;
    }

    public void setTeamDescription(String teamDescription) {
        this.teamDescription = teamDescription;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}


