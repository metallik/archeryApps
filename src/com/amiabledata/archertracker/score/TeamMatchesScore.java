package com.amiabledata.archertracker.score;

import java.util.ArrayList;

public class TeamMatchesScore extends Score {
    private ArrayList<Integer> firstTeamArrows;
    private Integer firstTeamAccumulativeSetPoints;
    private Integer firstTeamSetPoints;
    private ArrayList<Integer> secondTeamArrows;
    private Integer secondTeamAccumulativeSetPoints;
    private Integer secondTeamSetPoints;

    public TeamMatchesScore() {
        setSetNumber(0);
        this.firstTeamArrows = new ArrayList<Integer>();
        this.firstTeamAccumulativeSetPoints = 0;
        this.firstTeamSetPoints = 0;
        this.secondTeamArrows = new ArrayList<Integer>();
        this.secondTeamAccumulativeSetPoints = 0;
        this.secondTeamSetPoints = 0;
    }

    public TeamMatchesScore(TeamMatchesScore value) {
        setSetNumber(value.getSetNumber());
        setFirstTeamArrows(value.getAllFirstTeam_Arrows());
        setFirstTeamAccumulativeSetPoints(value.getFirstTeamAccumulativeSetPoints());
        setFirstTeamSetPoints(value.getFirstTeamSetPoints());
        setSecondTeamArrows(value.getAllSecondTeamArrows());
        setSecondTeamAccumulativeSetPoints(value.getSecondTeamAccumulativeSetPoints());
        setSecondTeamSetPoints(value.getSecondTeamSetPoints());
    }

    public void setFirstTeamArrows(ArrayList<Integer> value) {
        this.firstTeamArrows = new ArrayList<Integer>();
        this.firstTeamArrows.addAll(value);
    }
    public void addFirstTeamArrows(Integer value) {
        this.firstTeamArrows.add(value);
    }

    public ArrayList<Integer> getAllFirstTeam_Arrows(){
        return this.firstTeamArrows;
    }

    public Integer getFirstTeamArrows(Integer Index) {
        return this.firstTeamArrows.get(Index);
    }

    public void setFirstTeamAccumulativeSetPoints(Integer value) {
        this.firstTeamAccumulativeSetPoints = value;
    }

    public Integer getFirstTeamAccumulativeSetPoints() {
        return this.firstTeamAccumulativeSetPoints;
    }

    public void setFirstTeamSetPoints(Integer value) {
        this.firstTeamSetPoints = value;
    }

    public Integer getFirstTeamSetPoints() {
        return this.firstTeamSetPoints;
    }

    public void setSecondTeamArrows(ArrayList<Integer> value) {
        this.secondTeamArrows = new ArrayList<Integer>();
        this.secondTeamArrows.addAll(value);
    }

    public void addSecondTeamArrows(Integer value) {
        this.secondTeamArrows.add(value);
    }

    public ArrayList<Integer> getAllSecondTeamArrows() {
        return this.secondTeamArrows;
    }
    public Integer getSecondTeam_Arrows(Integer Index) {
        return this.secondTeamArrows.get(Index);
    }

    public void setSecondTeamAccumulativeSetPoints(Integer value) {
        this.secondTeamAccumulativeSetPoints = value;
    }

    public Integer getSecondTeamAccumulativeSetPoints() {
        return this.secondTeamAccumulativeSetPoints;
    }

    public void setSecondTeamSetPoints(Integer value) {
        this.secondTeamSetPoints = value;
    }

    public Integer getSecondTeamSetPoints() {
        return this.secondTeamSetPoints;
    }
}