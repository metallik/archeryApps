package com.amiabledata.archertracker.qualification;

import com.amiabledata.archertracker.score.IndividualQualificationScore;

import java.util.ArrayList;

public class IndividualContestantQualification {
    private String Name;
    private Integer Ranking;
    private ArrayList<IndividualQualificationScore> Scores;

    public IndividualContestantQualification() {
        this.Name = new String();
        this.Ranking = 0;
        this.Scores = new ArrayList<IndividualQualificationScore>();
    }

    public IndividualContestantQualification(IndividualContestantQualification value) {
        setName(value.getName());
        setRanking(value.getRanking());
        setScores(value.getAllScore());
    }

    public void setName(String value) {
        this.Name = value;
    }

    public String getName() {
        return this.Name;
    }

    public void setRanking(Integer value) {
        this.Ranking = value;
    }

    public Integer getRanking() {
        return this.Ranking;
    }

    public void setScores(ArrayList<IndividualQualificationScore>value) {
        this.Scores = new ArrayList<IndividualQualificationScore>();
        this.Scores.addAll(value);
    }

    public void addScore(IndividualQualificationScore value) {
        this.Scores.add(value);
    }

    public ArrayList<IndividualQualificationScore> getAllScore(){
        return this.Scores;
    }

    public IndividualQualificationScore getScore(Integer Index) {
        return this.Scores.get(Index);
    }
}