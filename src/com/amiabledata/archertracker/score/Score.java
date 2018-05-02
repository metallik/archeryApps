package com.amiabledata.archertracker.score;

public abstract class Score {
    private Integer SetNumber;

    public void setSetNumber(Integer value) {
        this.SetNumber = value;
    }

    public Integer getSetNumber() {
        return this.SetNumber;
    }

}
