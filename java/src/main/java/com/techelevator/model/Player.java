package com.techelevator.model;

public class Player {
    private int playerId;
    private String username;
    private String name;
    private int age;
    private String city;
    private String state;
    private int wins;
    private int losses;
    private int totalPoints;
    private double ppg;
    private String rightOrLeftHanded;

    public Player(int playerId, String username, String name, int age, String city, String state,
                  int wins, int losses, int totalPoints, double ppg, String rightOrLeftHanded) {
        this.playerId = playerId;
        this.username = username;
        this.name = name;
        this.age = age;
        this.city = city;
        this.state = state;
        this.wins = wins;
        this.losses = losses;
        this.totalPoints = totalPoints;
        this.ppg = ppg;
        this.rightOrLeftHanded = rightOrLeftHanded;
    }


    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public double getPpg() {
        return ppg;
    }

    public void setPpg(double ppg) {
        this.ppg = ppg;
    }

    public String getRightOrLeftHanded() {
        return rightOrLeftHanded;
    }

    public void setRightOrLeftHanded(String rightOrLeftHanded) {
        this.rightOrLeftHanded = rightOrLeftHanded;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", wins=" + wins +
                ", losses=" + losses +
                ", totalPoints=" + totalPoints +
                ", ppg=" + ppg +
                ", rightOrLeftHanded='" + rightOrLeftHanded + '\'' +
                '}';
    }
}

