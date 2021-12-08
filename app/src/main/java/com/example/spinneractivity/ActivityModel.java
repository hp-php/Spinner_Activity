package com.example.spinneractivity;

import java.util.ArrayList;

public class ActivityModel {
    int id;
    String name;
    ArrayList<PlayModel> play;

    public ActivityModel(int id, String name, ArrayList<PlayModel> games) {
        this.id = id;
        this.name = name;
        this.play = games;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<PlayModel> getGames() {
        return play;
    }

    public void setGames(ArrayList<PlayModel> games) {
        this.play = games;
    }

    public ArrayList<PlayModel> getPlay() {
        return play;
    }

    public void setPlay(ArrayList<PlayModel> play) {
        this.play = play;
    }
}
