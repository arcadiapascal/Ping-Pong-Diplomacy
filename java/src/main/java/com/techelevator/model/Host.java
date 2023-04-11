package com.techelevator.model;

public class Host {
    private int id;
    private String hostName;
    private String description;
    private String city;
    private String state;
    private String username;

    public Host(int id, String hostName, String description, String city, String state, String username) {
        this.id = id;
        this.hostName = hostName;
        this.description = description;
        this.city = city;
        this.state = state;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Host{" +
                "id=" + id +
                ", hostName='" + hostName + '\'' +
                ", description='" + description + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}

