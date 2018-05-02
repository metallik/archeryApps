package com.amiabledata.archertracker.round;

public abstract class Round {
    private String EntryType;

    public void setEntryType(String value) {
        this.EntryType = value;
    }

    public String getEntryType() {
        return this.EntryType;
    }
}
