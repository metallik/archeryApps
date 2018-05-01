package puit.archeryApps;

import java.util.ArrayList;
import java.util.Iterator;

abstract class Score{
	// Variables
	private Integer SetNumber;
	// Methods
	public void setSetNumber(Integer value) {
		this.SetNumber = value;
	}
	public Integer getSetNumber() {
		return this.SetNumber;
	}
}

class Individual_Qualification extends Score{
	// Variables
	private ArrayList<Integer> value;
	private Integer sum;
	private Integer tenPlusX;
	private Integer amountOfX;
	// Methods
	public Individual_Qualification() {
		setSetNumber(0);
		this.value = new ArrayList<Integer>();
		this.sum = 0;
		this.tenPlusX = 0;
		this.amountOfX = 0;
	}
	public Individual_Qualification(Individual_Qualification value) {
		setSetNumber(value.getSetNumber());
		setValue(value.getAllValue());
	}
	public void setValue(ArrayList<Integer> value) {
		this.value = new ArrayList<Integer>();
		this.value.addAll(value);
		setSum();
	}
	public void addValue(Integer value) {
		this.value.add(value);
		setSum();
	}
	public ArrayList<Integer> getAllValue() {
		return this.value;
	}
	public Integer getValue(Integer Index) {
		return this.value.get(Index);
	}
	private void setSum() {
		this.sum = 0;
		setTenPlusX();
		for(Iterator<Integer>it = this.value.iterator();it.hasNext();) {
			if(it.next() == 11) {
				this.sum += it.next()-1;
			}
			else {
				this.sum += it.next();
			}
		}
	}
	public Integer getSum() {
		return this.sum;
	}
	private void setTenPlusX() {
		this.tenPlusX = 0;
		this.amountOfX = 0;
		for(Iterator<Integer>it = this.value.iterator();it.hasNext();) {
			if(it.next() == 10 || it.next() == 11) {
				tenPlusX++;
				setAmountOfX(it.next());
			}
		}
	}
	public Integer getTenPlusX() {
		return this.tenPlusX;
	}
	private void setAmountOfX(Integer value) {
		if(value == 11) {
			this.amountOfX++;
		}
	}
	public Integer getAmountOfX() {
		return this.amountOfX;
	}
}

class Individual_Matches extends Score{
	// Variables
	private ArrayList<Integer> FirstContestant_Arrows;
	private Integer FirstContestant_Accumulative_SetPoints;
	private Integer FirstContestant_SetPoints;
	private ArrayList<Integer> SecondContestant_Arrows;
	private Integer SecondContestant_Accumulative_SetPoints;
	private Integer SecondContestant_SetPoints;
	// Methods
	public Individual_Matches() {
		this.setSetNumber(0);
		this.FirstContestant_Arrows = new ArrayList<Integer>();
		this.FirstContestant_Accumulative_SetPoints = 0;
		this.FirstContestant_SetPoints = 0;
		this.SecondContestant_Arrows = new ArrayList<Integer>();
		this.SecondContestant_Accumulative_SetPoints = 0;
		this.SecondContestant_SetPoints = 0;
	}
	public Individual_Matches(Individual_Matches value) {
		setSetNumber(value.getSetNumber());
		setFirstContestant_Arrows(value.getAllFirstContestant_Arrows());
		setFirstContestant_Accumulative_SetPoints(value.getFirstContestant_Accumulative_SetPoints());
		setFirstContestant_SetPoints(value.getFirstContestant_SetPoints());
		setSecondContestant_Arrows(value.getAllSecondContestant_Arrows());
		setSecondContestant_Accumulative_SetPoints(value.getSecondContestant_Accumulative_SetPoints());
		setSecondContestant_SetPoints(value.getSecondContestant_SetPoints());
	}
	public void setFirstContestant_Arrows(ArrayList<Integer> value) {
		this.FirstContestant_Arrows = new ArrayList<Integer>();
		this.FirstContestant_Arrows.addAll(value);
	}
	public void addFirstContestant_Arrows(Integer value) {
		this.FirstContestant_Arrows.add(value);
	}
	public ArrayList<Integer> getAllFirstContestant_Arrows(){
		return this.FirstContestant_Arrows;
	}
	public Integer getFirstContestant_Arrows(Integer Index) {
		return this.FirstContestant_Arrows.get(Index);
	}
	public void setFirstContestant_Accumulative_SetPoints(Integer value) {
		this.FirstContestant_Accumulative_SetPoints = value;
	}
	public Integer getFirstContestant_Accumulative_SetPoints() {
		return this.FirstContestant_Accumulative_SetPoints;
	}
	public void setFirstContestant_SetPoints(Integer value) {
		this.FirstContestant_SetPoints = value;
	}
	public Integer getFirstContestant_SetPoints() {
		return this.FirstContestant_SetPoints;
	}
	public void setSecondContestant_Arrows(ArrayList<Integer> value) {
		this.SecondContestant_Arrows = new ArrayList<Integer>();
		this.SecondContestant_Arrows.addAll(value);
	}
	public void addSecondContestant_Arrows(Integer value) {
		this.SecondContestant_Arrows.add(value);
	}
	public ArrayList<Integer> getAllSecondContestant_Arrows(){
		return this.SecondContestant_Arrows;
	}
	public Integer getSecondContestant_Arrows(Integer Index) {
		return this.SecondContestant_Arrows.get(Index);
	}
	public void setSecondContestant_Accumulative_SetPoints(Integer value) {
		this.SecondContestant_Accumulative_SetPoints = value;
	}
	public Integer getSecondContestant_Accumulative_SetPoints() {
		return this.SecondContestant_Accumulative_SetPoints;
	}
	public void setSecondContestant_SetPoints(Integer value) {
		this.SecondContestant_SetPoints = value;
	}
	public Integer getSecondContestant_SetPoints() {
		return this.SecondContestant_SetPoints;
	}
}

class Team_Matches extends Score{
	// Variables
	private ArrayList<Integer> FirstTeam_Arrows;
	private Integer FirstTeam_Accumulative_SetPoints;
	private Integer FirstTeam_SetPoints;
	private ArrayList<Integer> SecondTeam_Arrows;
	private Integer SecondTeam_Accumulative_SetPoints;
	private Integer SecondTeam_SetPoints;
	// Methods
	public Team_Matches() {
		setSetNumber(0);
		this.FirstTeam_Arrows = new ArrayList<Integer>();
		this.FirstTeam_Accumulative_SetPoints = 0;
		this.FirstTeam_SetPoints = 0;
		this.SecondTeam_Arrows = new ArrayList<Integer>();
		this.SecondTeam_Accumulative_SetPoints = 0;
		this.SecondTeam_SetPoints = 0;
	}
	public Team_Matches(Team_Matches value) {
		setSetNumber(value.getSetNumber());
		setFirstTeam_Arrows(value.getAllFirstTeam_Arrows());
		setFirstTeam_Accumulative_SetPoints(value.getFirstTeam_Accumulative_SetPoints());
		setFirstTeam_SetPoints(value.getFirstTeam_SetPoints());
		setSecondTeam_Arrows(value.getAllSecondTeam_Arrows());
		setSecondTeam_Accumulative_SetPoints(value.getSecondTeam_Accumulative_SetPoints());
		setSecondTeam_SetPoints(value.getSecondTeam_SetPoints());
	}
	public void setFirstTeam_Arrows(ArrayList<Integer> value) {
		this.FirstTeam_Arrows = new ArrayList<Integer>();
		this.FirstTeam_Arrows.addAll(value);
	}
	public void addFirstTeam_Arrows(Integer value) {
		this.FirstTeam_Arrows.add(value);
	}
	public ArrayList<Integer> getAllFirstTeam_Arrows(){
		return this.FirstTeam_Arrows;
	}
	public Integer getFirstTeam_Arrows(Integer Index) {
		return this.FirstTeam_Arrows.get(Index);
	}
	public void setFirstTeam_Accumulative_SetPoints(Integer value) {
		this.FirstTeam_Accumulative_SetPoints = value;
	}
	public Integer getFirstTeam_Accumulative_SetPoints() {
		return this.FirstTeam_Accumulative_SetPoints;
	}
	public void setFirstTeam_SetPoints(Integer value) {
		this.FirstTeam_SetPoints = value;
	}
	public Integer getFirstTeam_SetPoints() {
		return this.FirstTeam_SetPoints;
	}
	public void setSecondTeam_Arrows(ArrayList<Integer> value) {
		this.SecondTeam_Arrows = new ArrayList<Integer>();
		this.SecondTeam_Arrows.addAll(value);
	}
	public void addSecondTeam_Arrows(Integer value) {
		this.SecondTeam_Arrows.add(value);
	}
	public ArrayList<Integer> getAllSecondTeam_Arrows(){
		return this.SecondTeam_Arrows;
	}
	public Integer getSecondTeam_Arrows(Integer Index) {
		return this.SecondTeam_Arrows.get(Index);
	}
	public void setSecondTeam_Accumulative_SetPoints(Integer value) {
		this.SecondTeam_Accumulative_SetPoints = value;
	}
	public Integer getSecondTeam_Accumulative_SetPoints() {
		return this.SecondTeam_Accumulative_SetPoints;
	}
	public void setSecondTeam_SetPoints(Integer value) {
		this.SecondTeam_SetPoints = value;
	}
	public Integer getSecondTeam_SetPoints() {
		return this.SecondTeam_SetPoints;
	}
}

class Individual_Contestant_Qualification{
	// Variables
	private String Name;
	private Integer Ranking;
	private ArrayList<Individual_Qualification> Score;
	// Methods
	public Individual_Contestant_Qualification() {
		this.Name = new String();
		this.Ranking = 0;
		this.Score = new ArrayList<Individual_Qualification>();
	}
	public Individual_Contestant_Qualification(Individual_Contestant_Qualification value) {
		setName(value.getName());
		setRanking(value.getRanking());
		setScore(value.getAllScore());
	}
	public void setName(String value) {
		this.Name = value;
	}
	public String getName() {
		return this.Name;
	}
	public void setRanking(Integer value) {
		this.Ranking = value;
	}
	public Integer getRanking() {
		return this.Ranking;
	}
	public void setScore(ArrayList<Individual_Qualification>value) {
		this.Score = new ArrayList<Individual_Qualification>();
		this.Score.addAll(value);
	}
	public void addScore(Individual_Qualification value) {
		this.Score.add(value);
	}
	public ArrayList<Individual_Qualification> getAllScore(){
		return this.Score;
	}
	public Individual_Qualification getScore(Integer Index) {
		return this.Score.get(Index);
	}
}

class Team_Contestant_Qualification{
	
}

class Individual_Contestant_Matches{
	// Variables
	private String FirstContestant;
	private String SecondContestant;
	private ArrayList<Individual_Matches> Score;
	// Methods
	public Individual_Contestant_Matches(){
		this.FirstContestant = new String();
		this.SecondContestant = new String();
		this.Score = new ArrayList<Individual_Matches>();
	}
	public Individual_Contestant_Matches(Individual_Contestant_Matches value) {
		setFirstContestant(value.getFirstContestant());
		setSecondContestant(value.getSecondContestant());
		setScore(value.getAllScore());
	}
	public void setFirstContestant(String value) {
		this.FirstContestant = value;
	}
	public String getFirstContestant() {
		return this.FirstContestant;
	}
	public void setSecondContestant(String value) {
		this.SecondContestant = value;
	}
	public String getSecondContestant() {
		return this.SecondContestant;
	}
	public void setScore(ArrayList<Individual_Matches> value) {
		this.Score = new ArrayList<Individual_Matches>();
		this.Score.addAll(value);
	}
	public void addScore(Individual_Matches value) {
		this.Score.add(value);
	}
	public ArrayList<Individual_Matches> getAllScore(){
		return this.Score;
	}
	public Individual_Matches getScore(Integer Index) {
		return this.Score.get(Index);
	}
}

class Team_Contestant_Matches{
	// Variables
	private String FirstTeamName;
	private ArrayList<String> FirstTeamMembers;
	private String SecondTeamName;
	private ArrayList<String> SecondTeamMembers;
	private ArrayList<Team_Matches> Score;
	// Methods
	public Team_Contestant_Matches() {
		setFirstTeamName(new String());
		setFirstTeamMembers(new ArrayList<String>());
		setSecondTeamName(new String());
		setSecondTeamMembers(new ArrayList<String>());
		setScore(new ArrayList<Team_Matches>());
	}
	public Team_Contestant_Matches(Team_Contestant_Matches value) {
		setFirstTeamName(value.getFirstTeamName());
		setFirstTeamMembers(value.getAllFirstTeamMembers());
		setSecondTeamName(value.getSecondTeamName());
		setSecondTeamMembers(value.getAllSecondTeamMembers());
		setScore(value.getAllScore());
	}
	public void setFirstTeamName(String value) {
		this.FirstTeamName = value;
	}
	public String getFirstTeamName() {
		return this.FirstTeamName;
	}
	public void setFirstTeamMembers(ArrayList<String> value) {
		this.FirstTeamMembers = new ArrayList<String>();
		this.FirstTeamMembers.addAll(value);
	}
	public void addFirstTeamMembers(String value) {
		this.FirstTeamMembers.add(value);
	}
	public ArrayList<String> getAllFirstTeamMembers(){
		return this.FirstTeamMembers;
	}
	public String getFirstTeamMembers(Integer Index) {
		return this.FirstTeamMembers.get(Index);
	}
	public void setSecondTeamName(String value) {
		this.SecondTeamName = value;
	}
	public String getSecondTeamName() {
		return this.SecondTeamName;
	}
	public void setSecondTeamMembers(ArrayList<String> value) {
		this.SecondTeamMembers = new ArrayList<String>();
		this.SecondTeamMembers.addAll(value);
	}
	public void addSecondTeamMembers(String value) {
		this.SecondTeamMembers.add(value);
	}
	public ArrayList<String> getAllSecondTeamMembers(){
		return this.SecondTeamMembers;
	}
	public String getSecondTeamMembers(Integer Index) {
		return this.SecondTeamMembers.get(Index);
	}
	public void setScore(ArrayList<Team_Matches> value) {
		this.Score = new ArrayList<Team_Matches>();
		this.Score.addAll(value);
	}
	public void addScore(Team_Matches value) {
		this.Score.add(value);
	}
	public ArrayList<Team_Matches> getAllScore(){
		return this.Score;
	}
	public Team_Matches getScore(Integer Index) {
		return this.Score.get(Index);
	}
}

abstract class Stages{
	// Variables
	private String Stage;
	// Methods
	public void setStage(String value) {
		this.Stage = value;
	}
	public String getStage() {
		return this.Stage;
	}
}

class IndividualQualification extends Stages{
	// Variables
	private ArrayList<Individual_Contestant_Qualification> Contestants;
	// Methods
	public IndividualQualification() {
		setStage("Qualification Round");
		this.Contestants = new ArrayList<Individual_Contestant_Qualification>();
	}
	public IndividualQualification(IndividualQualification value) {
		setStage(value.getStage());
		setContestants(value.getAllContestants());
	}
	public void setContestants(ArrayList<Individual_Contestant_Qualification>value) {
		this.Contestants = new ArrayList<Individual_Contestant_Qualification>();
		this.Contestants.addAll(value);
	}
	public void addContestants(Individual_Contestant_Qualification value) {
		this.Contestants.add(value);
	}
	public ArrayList<Individual_Contestant_Qualification> getAllContestants(){
		return this.Contestants;
	}
	public Individual_Contestant_Qualification getContestants(Integer Index) {
		return this.Contestants.get(Index);
	}
}

class TeamQualification extends Stages{
	public TeamQualification() {
		setStage(new String());
	}
	public TeamQualification(TeamQualification value) {
		setStage(value.getStage());
	}
}

class IndividualMatches extends Stages{
	// Variables
	private ArrayList<Individual_Contestant_Matches> Matches;
	// Methods
	public IndividualMatches() {
		setStage(new String());
		this.Matches = new ArrayList<Individual_Contestant_Matches>();
	}
	public IndividualMatches(IndividualMatches value) {
		setStage(value.getStage());
		setMatches(value.getAllMatches());
	}
	public void setMatches(ArrayList<Individual_Contestant_Matches> value) {
		this.Matches = new ArrayList<Individual_Contestant_Matches>();
		this.Matches.addAll(value);
	}
	public void addMatches(Individual_Contestant_Matches value) {
		this.Matches.add(value);
	}
	public ArrayList<Individual_Contestant_Matches> getAllMatches(){
		return this.Matches;
	}
	public Individual_Contestant_Matches getMatches(Integer Index) {
		return this.Matches.get(Index);
	}
}

class TeamMatches extends Stages{
	// Variables
	private ArrayList<Team_Contestant_Matches> Matches;
	// Methods
	public TeamMatches() {
		setStage(new String());
		setMatches(new ArrayList<Team_Contestant_Matches>());
	}
	public TeamMatches(TeamMatches value) {
		setStage(value.getStage());
		setMatches(value.getAllMatches());
	}
	public void setMatches(ArrayList<Team_Contestant_Matches> value) {
		this.Matches = new ArrayList<Team_Contestant_Matches>();
		this.Matches.addAll(value);
	}
	public void setMatches(Team_Contestant_Matches value) {
		this.Matches.add(value);
	}
	public ArrayList<Team_Contestant_Matches> getAllMatches(){
		return this.Matches;
	}
	public Team_Contestant_Matches getMatches(Integer Index) {
		return this.Matches.get(Index);
	}
}

class Round {
	// Variables
	private String EntryType;
	
	// Methods
	public void setEntryType(String value) {
		this.EntryType = value;
	}
	public String getEntryType() {
		return this.EntryType;
	}
}

class Team extends Round{
	private ArrayList<TeamQualification> QualificationState;
	private ArrayList<TeamMatches> MatchState;
	public Team() {
		setEntryType(new String());
		this.QualificationState = new ArrayList<TeamQualification>();
		this.MatchState = new ArrayList<TeamMatches>();
	}
	public Team(Team value) {
		setEntryType(value.getEntryType());
		setQualificationState(value.getAllQualificationState());
		setMatchState(value.getAllMatchState());
	}
	public void setQualificationState(ArrayList<TeamQualification> value) {
		this.QualificationState = new ArrayList<TeamQualification>();
		this.QualificationState.addAll(value);
	}
	public void addQualificationState(TeamQualification value) {
		this.QualificationState.add(value);
	}
	public ArrayList<TeamQualification> getAllQualificationState(){
		return this.QualificationState;
	}
	public TeamQualification getQualificationState(Integer Index) {
		return this.QualificationState.get(Index);
	}
	public void setMatchState(ArrayList<TeamMatches> value) {
		this.MatchState = new ArrayList<TeamMatches>();
		this.MatchState.addAll(value);
	}
	public void addMatchState(TeamMatches value) {
		this.MatchState.add(value);
	}
	public ArrayList<TeamMatches> getAllMatchState(){
		return this.MatchState;
	}
	public TeamMatches getMatchState(Integer Index) {
		return this.MatchState.get(Index);
	}
}

class Individual extends Round{
	private IndividualQualification QualificationState;
	private ArrayList<IndividualMatches> MatchState;
	public Individual() {
		setEntryType(new String());
		this.QualificationState = new IndividualQualification();
		this.MatchState = new ArrayList<IndividualMatches>();
	}
	public Individual(Individual value) {
		setEntryType(value.getEntryType());
		setQualificationState(value.getQualificationState());
		setMatchState(value.getAllMatchState());
	}
	public void setQualificationState(IndividualQualification value) {
		this.QualificationState = new IndividualQualification();
		this.QualificationState = value;
	}
	public IndividualQualification getQualificationState() {
		return this.QualificationState;
	}
	public void setMatchState(ArrayList<IndividualMatches> value) {
		this.MatchState = new ArrayList<IndividualMatches>();
		this.MatchState.addAll(value);
	}
	public void addMatchState(IndividualMatches value) {
		this.MatchState.add(value);
	}
	public ArrayList<IndividualMatches> getAllMatchState(){
		return this.MatchState;
	}
	public IndividualMatches getMatchState(Integer Index) {
		return this.MatchState.get(Index);
	}
}

public class CompetitionList {
	// Variables	
	private String CompetitionName;
	private String StartDate;
	private String EndDate;
	private String Location;
	private Boolean EventFinished;
	private ArrayList<Individual> IndividualEntry;
	private ArrayList<Team> TeamEntry;
	private String Category;
	// Methods
	public CompetitionList() {
		setCompetitionName(new String());
		setStartDate(new String());
		setEndDate(new String());
		setLocation(new String());
		setEventFinished(null);
		setIndividualEntry(new ArrayList<Individual>());
		setTeamEntry(new ArrayList<Team>());
		setCategory(new String());
	}
	public CompetitionList(CompetitionList item) {
		setCompetitionName(item.getCompetitionName());
		setStartDate(item.getStartDate());
		setEndDate(item.getEndDate());
		setLocation(item.getLocation());
		setEventFinished(item.getEventFinished());
		setIndividualEntry(item.getAllIndividualEntry());
		setTeamEntry(item.getAllTeamEntry());
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
	public void setIndividualEntry(ArrayList<Individual>value) {
		this.IndividualEntry = new ArrayList<Individual>();
		this.IndividualEntry.addAll(value);
	}
	public void addEntry(Individual value) {
		this.IndividualEntry.add(value);
	}
	public void setTeamEntry(ArrayList<Team>value) {
		this.TeamEntry = new ArrayList<Team>();
		this.TeamEntry.addAll(value);
	}
	public void addEntry(Team value) {
		this.TeamEntry.add(value);
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
	public ArrayList<Individual> getAllIndividualEntry(){
		return this.IndividualEntry;
	}
	public Individual getIndividualEntry(Integer Index) {
		return this.IndividualEntry.get(Index);
	}
	public ArrayList<Team> getAllTeamEntry(){
		return this.TeamEntry;
	}
	public Team getTeamEntry(Integer Index) {
		return this.TeamEntry.get(Index);
	}
	public String getCategory() {
		return this.Category;
	}
}
