package com.amiabledata.archertracker.qualification;

import com.amiabledata.archertracker.score.IndividualQualificationScore;

import java.util.ArrayList;

public class IndividualContestantQualification {
    private String Name;
    private Integer Ranking;
    private ArrayList<IndividualQualificationScore> Score;

    public IndividualContestantQualification() {
        this.Name = new String();
        this.Ranking = 0;
        this.Score = new ArrayList<IndividualQualificationScore>();
    }

    public IndividualContestantQualification(IndividualContestantQualification value) {
        setName(value.getName());
        setRanking(value.getRanking());
        setScore(value.getAllScore());
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

    public void setScore(ArrayList<IndividualQualificationScore>value) {
        this.Score = new ArrayList<IndividualQualificationScore>();
        this.Score.addAll(value);
    }

    public void addScore(IndividualQualificationScore value) {
        this.Score.add(value);
    }

    public ArrayList<IndividualQualificationScore> getAllScore(){
        return this.Score;
    }

    public IndividualQualificationScore getScore(Integer Index) {
        return this.Score.get(Index);
    }
}