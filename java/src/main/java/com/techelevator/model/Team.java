package com.techelevator.model;

public class Team {

    private int id;
    private String teamName;
    private String teamDescription;
    private String address;
    private String city;
    private String state;


    public Team() { }

    public Team(int id, String teamName, String teamDescription, String address, String city, String state) {
        this.id = id;
        this.teamName = teamName;
        this.teamDescription = teamDescription;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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



