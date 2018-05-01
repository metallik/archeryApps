package com.amiabledata.archertracker.stage;

import com.amiabledata.archertracker.matches.IndividualContestantMatches;

import java.util.ArrayList;

public class IndividualMatchesStage extends Stage {
    private ArrayList<IndividualContestantMatches> Matches;

    public IndividualMatchesStage() {
        setStage(new String());
        this.Matches = new ArrayList<IndividualContestantMatches>();
    }

    public IndividualMatchesStage(IndividualMatchesStage value) {
        setStage(value.getStage());
        setMatches(value.getAllMatches());
    }

    public void setMatches(ArrayList<IndividualContestantMatches> value) {
        this.Matches = new ArrayList<IndividualContestantMatches>();
        this.Matches.addAll(value);
    }

    public void addMatches(IndividualContestantMatches value) {
        this.Matches.add(value);
    }

    public ArrayList<IndividualContestantMatches> getAllMatches() {
        return this.Matches;
    }

    public IndividualContestantMatches getMatches(Integer Index) {
        return this.Matches.get(Index);
    }
}
