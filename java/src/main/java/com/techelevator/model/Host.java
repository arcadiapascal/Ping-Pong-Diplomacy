package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class Host {

    @JsonProperty("hostId")
    private int id;
    @NotNull
    private String hostName;
    @NotNull
    private int userId;

    public Host(int id, String hostName, int userId) {
        this.id = id;
        this.hostName = hostName;
        this.userId = userId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Host{" +
                "id=" + id +
                ", hostName='" + hostName + '\'' +
                ", userId=" + userId +
                '}';
    }
}

