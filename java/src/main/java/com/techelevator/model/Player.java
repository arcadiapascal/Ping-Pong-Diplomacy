package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class Player {

    private int playerId;
    @JsonProperty("userId")
    private int userId;
    @NotNull
    private String playerName;
    private int age;
    @NotNull
    private String city;
    @NotNull
    private String stateAbbrev;
    private int wins;
    private int losses;
    private BigDecimal winPercentage;
    private int ranking;
    private int totalPoints;
    @NotNull
    private char rightLeftHanded = 'R';
    @NotNull
    private String email;
    private String photoFile;
    private byte[] photo;

    public Player() {}

    public Player(int userId, String playerName, int age, String city, String stateAbbrev,
                  char rightLeftHanded, String email) {
        this.userId = userId;
        this.playerName = playerName;
        this.age = age;
        this.city = city;
        this.stateAbbrev = stateAbbrev;
        this.rightLeftHanded = rightLeftHanded;
        this.email = email;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
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

    public String getStateAbbrev() {
        return stateAbbrev;
    }

    public void setStateAbbrev(String stateAbbrev) {
        this.stateAbbrev = stateAbbrev;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }

    public BigDecimal getWinPercentage() {
        return winPercentage;
    }

    public void setWinPercentage(BigDecimal winPercentage) {
        this.winPercentage = winPercentage;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }

    public char getRightLeftHanded() {
        return rightLeftHanded;
    }

    public void setRightLeftHanded(char rightLeftHanded) {
        this.rightLeftHanded = rightLeftHanded;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotoFile() {
        return photoFile;
    }

    public void setPhotoFile(String photoFile) {
        this.photoFile = photoFile;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", userId=" + userId +
                ", playerName='" + playerName + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", stateAbbrev='" + stateAbbrev + '\'' +
                ", wins=" + wins +
                ", losses=" + losses +
                ", winPercentage=" + winPercentage +
                ", ranking=" + ranking +
                ", totalPoints=" + totalPoints +
                ", rightLeftHanded=" + rightLeftHanded +
                ", email='" + email + '\'' +
                ", photoFile='" + photoFile + '\'' +
                ", photo=" + photo +
                '}';
    }

}

