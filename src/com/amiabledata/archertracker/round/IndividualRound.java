package com.amiabledata.archertracker.round;

import com.amiabledata.archertracker.stage.IndividualMatchesStage;
import com.amiabledata.archertracker.stage.IndividualQualificationStage;

import java.util.ArrayList;

public class IndividualRound extends Round {
    private IndividualQualificationStage QualificationState;
    private ArrayList<IndividualMatchesStage> MatchState;

    public IndividualRound() {
        setEntryType(new String());
        this.QualificationState = new IndividualQualificationStage();
        this.MatchState = new ArrayList<IndividualMatchesStage>();
    }

    public IndividualRound(IndividualRound value) {
        setEntryType(value.getEntryType());
        setQualificationState(value.getQualificationState());
        setMatchState(value.getAllMatchState());
    }

    public void setQualificationState(IndividualQualificationStage value) {
        this.QualificationState = new IndividualQualificationStage();
        this.QualificationState = value;
    }

    public IndividualQualificationStage getQualificationState() {
        return this.QualificationState;
    }

    public void setMatchState(ArrayList<IndividualMatchesStage> value) {
        this.MatchState = new ArrayList<IndividualMatchesStage>();
        this.MatchState.addAll(value);
    }

    public void addMatchState(IndividualMatchesStage value) {
        this.MatchState.add(value);
    }

    public ArrayList<IndividualMatchesStage> getAllMatchState(){
        return this.MatchState;
    }

    public IndividualMatchesStage getMatchState(Integer Index) {
        return this.MatchState.get(Index);
    }
}