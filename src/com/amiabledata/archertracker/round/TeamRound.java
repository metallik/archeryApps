package com.amiabledata.archertracker.round;

import com.amiabledata.archertracker.stage.TeamMatchesStage;
import com.amiabledata.archertracker.stage.TeamQualificationStage;

import java.util.ArrayList;

public class TeamRound extends Round {
    private ArrayList<TeamQualificationStage> QualificationState;
    private ArrayList<TeamMatchesStage> MatchState;

    public TeamRound() {
        setEntryType(new String());
        this.QualificationState = new ArrayList<TeamQualificationStage>();
        this.MatchState = new ArrayList<TeamMatchesStage>();
    }

    public TeamRound(TeamRound value) {
        setEntryType(value.getEntryType());
        setQualificationState(value.getAllQualificationState());
        setMatchState(value.getAllMatchState());
    }

    public void setQualificationState(ArrayList<TeamQualificationStage> value) {
        this.QualificationState = new ArrayList<TeamQualificationStage>();
        this.QualificationState.addAll(value);
    }

    public void addQualificationState(TeamQualificationStage value) {
        this.QualificationState.add(value);
    }

    public ArrayList<TeamQualificationStage> getAllQualificationState(){
        return this.QualificationState;
    }

    public TeamQualificationStage getQualificationState(Integer Index) {
        return this.QualificationState.get(Index);
    }

    public void setMatchState(ArrayList<TeamMatchesStage> value) {
        this.MatchState = new ArrayList<TeamMatchesStage>();
        this.MatchState.addAll(value);
    }

    public void addMatchState(TeamMatchesStage value) {
        this.MatchState.add(value);
    }

    public ArrayList<TeamMatchesStage> getAllMatchState() {
        return this.MatchState;
    }

    public TeamMatchesStage getMatchState(Integer Index) {
        return this.MatchState.get(Index);
    }
}
