package com.amiabledata.archertracker.stage;

import com.amiabledata.archertracker.qualification.IndividualContestantQualification;

import java.util.ArrayList;

public class IndividualQualificationStage extends Stage {
    private ArrayList<IndividualContestantQualification> Contestants;

    public IndividualQualificationStage() {
        setStage("Qualification Round");
        this.Contestants = new ArrayList<IndividualContestantQualification>();
    }

    public IndividualQualificationStage(IndividualQualificationStage value) {
        setStage(value.getStage());
        setContestants(value.getAllContestants());
    }

    public void setContestants(ArrayList<IndividualContestantQualification>value) {
        this.Contestants = new ArrayList<IndividualContestantQualification>();
        this.Contestants.addAll(value);
    }

    public void addContestants(IndividualContestantQualification value) {
        this.Contestants.add(value);
    }

    public ArrayList<IndividualContestantQualification> getAllContestants() {
        return this.Contestants;
    }

    public IndividualContestantQualification getContestants(Integer Index) {
        return this.Contestants.get(Index);
    }
}
