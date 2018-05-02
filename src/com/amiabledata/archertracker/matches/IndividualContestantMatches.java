package com.amiabledata.archertracker.matches;

import com.amiabledata.archertracker.score.IndividualMatchesScore;

import java.util.ArrayList;

public class IndividualContestantMatches {
    private String FirstContestant;
    private String SecondContestant;
    private ArrayList<IndividualMatchesScore> Scores;

    public IndividualContestantMatches(){
        this.FirstContestant = new String();
        this.SecondContestant = new String();
        this.Scores = new ArrayList<IndividualMatchesScore>();
    }

    public IndividualContestantMatches(IndividualContestantMatches value) {
        setFirstContestant(value.getFirstContestant());
        setSecondContestant(value.getSecondContestant());
        setScores(value.getAllScore());
    }

    public void setFirstContestant(String value) {
        this.FirstContestant = value;
    }

    public String getFirstContestant() {
        return this.FirstContestant;
    }

    public void setSecondContestant(String value) {
        this.SecondContestant = value;
    }

    public String getSecondContestant() {
        return this.SecondContestant;
    }

    public void setScores(ArrayList<IndividualMatchesScore> value) {
        this.Scores = new ArrayList<IndividualMatchesScore>();
        this.Scores.addAll(value);
    }

    public void addScore(IndividualMatchesScore value) {
        this.Scores.add(value);
    }

    public ArrayList<IndividualMatchesScore> getAllScore() {
        return this.Scores;
    }

    public IndividualMatchesScore getScore(Integer Index) {
        return this.Scores.get(Index);
    }
}