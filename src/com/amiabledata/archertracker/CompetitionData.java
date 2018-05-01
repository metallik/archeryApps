package com.amiabledata.archertracker;

import com.amiabledata.archertracker.round.IndividualRound;
import com.amiabledata.archertracker.round.TeamRound;

import java.util.ArrayList;

public class CompetitionData {
	private String CompetitionName;
	private String StartDate;
	private String EndDate;
	private String Location;
	private Boolean EventFinished;
	private ArrayList<IndividualRound> individualRoundEntry;
	private ArrayList<TeamRound> teamRoundEntry;
	private String Category;

	public CompetitionData() {
		setCompetitionName(new String());
		setStartDate(new String());
		setEndDate(new String());
		setLocation(new String());
		setEventFinished(null);
		setIndividualRoundEntry(new ArrayList<IndividualRound>());
		setTeamRoundEntry(new ArrayList<TeamRound>());
		setCategory(new String());
	}
	public CompetitionData(CompetitionData item) {
		setCompetitionName(item.getCompetitionName());
		setStartDate(item.getStartDate());
		setEndDate(item.getEndDate());
		setLocation(item.getLocation());
		setEventFinished(item.getEventFinished());
		setIndividualRoundEntry(item.getAllIndividualEntry());
		setTeamRoundEntry(item.getAllTeamEntry());
		setCategory(item.getCategory());
	}
	public void setCompetitionName(String value) {
		this.CompetitionName = value;
	}

	public void setStartDate(String value) {
		this.StartDate = value;
	}

	public void setEndDate(String value) {
		this.EndDate = value;
	}

	public void setLocation(String value) {
		this.Location = value;
	}

	public void setEventFinished(Boolean value) {
		this.EventFinished = value;
	}

	public void setIndividualRoundEntry(ArrayList<IndividualRound>value) {
		this.individualRoundEntry = new ArrayList<IndividualRound>();
		this.individualRoundEntry.addAll(value);
	}
	public void addEntry(IndividualRound value) {
		this.individualRoundEntry.add(value);
	}
	public void setTeamRoundEntry(ArrayList<TeamRound>value) {
		this.teamRoundEntry = new ArrayList<TeamRound>();
		this.teamRoundEntry.addAll(value);
	}
	public void addEntry(TeamRound value) {
		this.teamRoundEntry.add(value);
	}

	public void setCategory(String value) {
		this.Category = value;
	}

	public String getCompetitionName() {
		return this.CompetitionName;
	}

	public String getStartDate() {
		return this.StartDate;
	}

	public String getEndDate() {
		return this.EndDate;
	}

	public String getLocation() {
		return this.Location;
	}

	public Boolean getEventFinished() {
		return this.EventFinished;
	}

	public ArrayList<IndividualRound> getAllIndividualEntry(){
		return this.individualRoundEntry;
	}

	public IndividualRound getIndividualEntry(Integer Index) {
		return this.individualRoundEntry.get(Index);
	}

	public ArrayList<TeamRound> getAllTeamEntry(){
		return this.teamRoundEntry;
	}

	public TeamRound getTeamEntry(Integer Index) {
		return this.teamRoundEntry.get(Index);
	}

	public String getCategory() {
		return this.Category;
	}
}
