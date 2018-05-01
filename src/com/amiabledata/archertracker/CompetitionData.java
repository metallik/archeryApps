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
	private ArrayList<IndividualRound> IndividualRoundEntries;
	private ArrayList<TeamRound> TeamRoundEntries;
	private String Category;

	public CompetitionData() {
		setCompetitionName(new String());
		setStartDate(new String());
		setEndDate(new String());
		setLocation(new String());
		setEventFinished(null);
		setIndividualRoundEntries(new ArrayList<IndividualRound>());
		setTeamRoundEntries(new ArrayList<TeamRound>());
		setCategory(new String());
	}
	public CompetitionData(CompetitionData item) {
		setCompetitionName(item.getCompetitionName());
		setStartDate(item.getStartDate());
		setEndDate(item.getEndDate());
		setLocation(item.getLocation());
		setEventFinished(item.getEventFinished());
		setIndividualRoundEntries(item.getAllIndividualEntry());
		setTeamRoundEntries(item.getAllTeamEntry());
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

	public void setIndividualRoundEntries(ArrayList<IndividualRound>value) {
		this.IndividualRoundEntries = new ArrayList<IndividualRound>();
		this.IndividualRoundEntries.addAll(value);
	}
	public void addEntry(IndividualRound value) {
		this.IndividualRoundEntries.add(value);
	}
	public void setTeamRoundEntries(ArrayList<TeamRound>value) {
		this.TeamRoundEntries = new ArrayList<TeamRound>();
		this.TeamRoundEntries.addAll(value);
	}
	public void addEntry(TeamRound value) {
		this.TeamRoundEntries.add(value);
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
		return this.IndividualRoundEntries;
	}

	public IndividualRound getIndividualEntry(Integer Index) {
		return this.IndividualRoundEntries.get(Index);
	}

	public ArrayList<TeamRound> getAllTeamEntry(){
		return this.TeamRoundEntries;
	}

	public TeamRound getTeamEntry(Integer Index) {
		return this.TeamRoundEntries.get(Index);
	}

	public String getCategory() {
		return this.Category;
	}
}
