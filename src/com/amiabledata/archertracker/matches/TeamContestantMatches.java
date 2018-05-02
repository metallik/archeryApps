package com.amiabledata.archertracker.matches;

import com.amiabledata.archertracker.score.TeamMatchesScore;

import java.util.ArrayList;

public class TeamContestantMatches {
    private String FirstTeamName;
    private ArrayList<String> FirstTeamMembers;
    private String SecondTeamName;
    private ArrayList<String> SecondTeamMembers;
    private ArrayList<TeamMatchesScore> Scores;

    public TeamContestantMatches() {
        setFirstTeamName(new String());
        setFirstTeamMembers(new ArrayList<String>());
        setSecondTeamName(new String());
        setSecondTeamMembers(new ArrayList<String>());
        setScores(new ArrayList<TeamMatchesScore>());
    }

    public TeamContestantMatches(TeamContestantMatches value) {
        setFirstTeamName(value.getFirstTeamName());
        setFirstTeamMembers(value.getAllFirstTeamMembers());
        setSecondTeamName(value.getSecondTeamName());
        setSecondTeamMembers(value.getAllSecondTeamMembers());
        setScores(value.getAllScore());
    }

    public void setFirstTeamName(String value) {
        this.FirstTeamName = value;
    }

    public String getFirstTeamName() {
        return this.FirstTeamName;
    }

    public void setFirstTeamMembers(ArrayList<String> value) {
        this.FirstTeamMembers = new ArrayList<String>();
        this.FirstTeamMembers.addAll(value);
    }

    public void addFirstTeamMembers(String value) {
        this.FirstTeamMembers.add(value);
    }

    public ArrayList<String> getAllFirstTeamMembers(){
        return this.FirstTeamMembers;
    }

    public String getFirstTeamMembers(Integer Index) {
        return this.FirstTeamMembers.get(Index);
    }

    public void setSecondTeamName(String value) {
        this.SecondTeamName = value;
    }

    public String getSecondTeamName() {
        return this.SecondTeamName;
    }

    public void setSecondTeamMembers(ArrayList<String> value) {
        this.SecondTeamMembers = new ArrayList<String>();
        this.SecondTeamMembers.addAll(value);
    }

    public void addSecondTeamMembers(String value) {
        this.SecondTeamMembers.add(value);
    }

    public ArrayList<String> getAllSecondTeamMembers() {
        return this.SecondTeamMembers;
    }

    public String getSecondTeamMembers(Integer Index) {
        return this.SecondTeamMembers.get(Index);
    }

    public void setScores(ArrayList<TeamMatchesScore> value) {
        this.Scores = new ArrayList<TeamMatchesScore>();
        this.Scores.addAll(value);
    }

    public void addScore(TeamMatchesScore value) {
        this.Scores.add(value);
    }

    public ArrayList<TeamMatchesScore> getAllScore() {
        return this.Scores;
    }

    public TeamMatchesScore getScore(Integer Index) {
        return this.Scores.get(Index);
    }
}