package com.amiabledata.archertracker.score;

import java.util.ArrayList;

public class IndividualMatchesScore extends Score {
    private ArrayList<Integer> firstContestantArrows;
    private Integer firstContestantAccumulativeSetPoints;
    private Integer firstContestantSetPoints;
    private ArrayList<Integer> secondContestantArrows;
    private Integer secondContestantAccumulativeSetPoints;
    private Integer secondContestantSetPoints;

    public IndividualMatchesScore() {
        this.setSetNumber(0);
        this.firstContestantArrows = new ArrayList<Integer>();
        this.firstContestantAccumulativeSetPoints = 0;
        this.firstContestantSetPoints = 0;
        this.secondContestantArrows = new ArrayList<Integer>();
        this.secondContestantAccumulativeSetPoints = 0;
        this.secondContestantSetPoints = 0;
    }

    public IndividualMatchesScore(IndividualMatchesScore value) {
        setSetNumber(value.getSetNumber());
        setFirstContestantArrows(value.getAllFirstContestantArrows());
        setFirstContestantAccumulativeSetPoints(value.getFirstContestantAccumulativeSetPoints());
        setFirstContestantSetPoints(value.getFirstContestantSetPoints());
        setSecondContestantArrows(value.getAllSecondContestantArrows());
        setSecondContestantAccumulativeSetPoints(value.getSecondContestantAccumulativeSetPoints());
        setSecondContestantSetPoints(value.getSecondContestantSetPoints());
    }

    public void setFirstContestantArrows(ArrayList<Integer> value) {
        this.firstContestantArrows = new ArrayList<Integer>();
        this.firstContestantArrows.addAll(value);
    }

    public void addFirstContestantArrows(Integer value) {
        this.firstContestantArrows.add(value);
    }

    public ArrayList<Integer> getAllFirstContestantArrows() {
        return this.firstContestantArrows;
    }

    public Integer getFirstContestantArrows(Integer Index) {
        return this.firstContestantArrows.get(Index);
    }

    public void setFirstContestantAccumulativeSetPoints(Integer value) {
        this.firstContestantAccumulativeSetPoints = value;
    }

    public Integer getFirstContestantAccumulativeSetPoints() {
        return this.firstContestantAccumulativeSetPoints;
    }

    public void setFirstContestantSetPoints(Integer value) {
        this.firstContestantSetPoints = value;
    }

    public Integer getFirstContestantSetPoints() {
        return this.firstContestantSetPoints;
    }

    public void setSecondContestantArrows(ArrayList<Integer> value) {
        this.secondContestantArrows = new ArrayList<Integer>();
        this.secondContestantArrows.addAll(value);
    }

    public void addSecondContestantArrows(Integer value) {
        this.secondContestantArrows.add(value);
    }

    public ArrayList<Integer> getAllSecondContestantArrows(){
        return this.secondContestantArrows;
    }

    public Integer getSecondContestantArrows(Integer Index) {
        return this.secondContestantArrows.get(Index);
    }

    public void setSecondContestantAccumulativeSetPoints(Integer value) {
        this.secondContestantAccumulativeSetPoints = value;
    }

    public Integer getSecondContestantAccumulativeSetPoints() {
        return this.secondContestantAccumulativeSetPoints;
    }

    public void setSecondContestantSetPoints(Integer value) {
        this.secondContestantSetPoints = value;
    }

    public Integer getSecondContestantSetPoints() {
        return this.secondContestantSetPoints;
    }
}
