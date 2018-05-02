package com.amiabledata.archertracker.stage;

import com.amiabledata.archertracker.matches.TeamContestantMatches;

import java.util.ArrayList;

public class TeamMatchesStage extends Stage {
    private ArrayList<TeamContestantMatches> Matches;

    public TeamMatchesStage() {
        setStage(new String());
        setMatches(new ArrayList<TeamContestantMatches>());
    }

    public TeamMatchesStage(TeamMatchesStage value) {
        setStage(value.getStage());
        setMatches(value.getAllMatches());
    }

    public void setMatches(ArrayList<TeamContestantMatches> value) {
        this.Matches = new ArrayList<TeamContestantMatches>();
        this.Matches.addAll(value);
    }

    public void setMatches(TeamContestantMatches value) {
        this.Matches.add(value);
    }

    public ArrayList<TeamContestantMatches> getAllMatches(){
        return this.Matches;
    }

    public TeamContestantMatches getMatches(Integer Index) {
        return this.Matches.get(Index);
    }
}
