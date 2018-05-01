package com.amiabledata.archertracker.matches;

import com.amiabledata.archertracker.score.IndividualMatchesScore;

import java.util.ArrayList;

public class IndividualContestantMatches {
    private String FirstContestant;
    private String SecondContestant;
    private ArrayList<IndividualMatchesScore> Score;

    public IndividualContestantMatches(){
        this.FirstContestant = new String();
        this.SecondContestant = new String();
        this.Score = new ArrayList<IndividualMatchesScore>();
    }

    public IndividualContestantMatches(IndividualContestantMatches value) {
        setFirstContestant(value.getFirstContestant());
        setSecondContestant(value.getSecondContestant());
        setScore(value.getAllScore());
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

    public void setScore(ArrayList<IndividualMatchesScore> value) {
        this.Score = new ArrayList<IndividualMatchesScore>();
        this.Score.addAll(value);
    }

    public void addScore(IndividualMatchesScore value) {
        this.Score.add(value);
    }

    public ArrayList<IndividualMatchesScore> getAllScore() {
        return this.Score;
    }

    public IndividualMatchesScore getScore(Integer Index) {
        return this.Score.get(Index);
    }
}