package com.amiabledata.archertracker;

import java.io.*;

import com.google.gson.*;

public class ArcheryDataHelper {
	private Gson gson = new Gson();
	private File file;
	private ArcheryDataList data;

	// BackEnd Start
	private ArcheryDataList getData() {
		return this.data;
	}

	private void getJson() throws FileNotFoundException {
		this.data = gson.fromJson(new FileReader(file), ArcheryDataList.class);
	}
	// BackEnd End
	
	// FrontEnd Start
    public ArcheryDataHelper() {
	    data = new ArcheryDataList();
    }

	public ArcheryDataHelper(String path) throws FileNotFoundException, NullPointerException {
	    this(new File(path));
	}

    public ArcheryDataHelper(File f) throws FileNotFoundException, NullPointerException {
	    if (f == null) {
	        throw new NullPointerException();
        } else if (!f.isFile()) {
	        throw new FileNotFoundException();
        } else {
	        setFile(f);
        }

        getJson();
    }

	public void setFile(File f) throws FileNotFoundException {
		this.file = f;

		getJson();
	}

	public File getFile() {
		return this.file;
	}

	public ArcheryDataList getDataList() {
		return data;
	}

	public void setCompetitionName(Integer Index, String value) {
		getData().getAllDataList().get(Index).setCompetitionName(value);
	}

	public String getCompetitionName(Integer Index) {
		return getData().getAllDataList().get(Index).getCompetitionName();
	}

	public String getStartDate(Integer Index) {
		return getData().getAllDataList().get(Index).getStartDate();
	}

	public String getEndDate(Integer Index) {
		return getData().getAllDataList().get(Index).getEndDate();
	}

	public String getLocation(Integer Index) {
		return getData().getAllDataList().get(Index).getLocation();
	}

	public Boolean getEventFinished(Integer Index) {
		return getData().getAllDataList().get(Index).getEventFinished();
	}

	public String getCategory(Integer Index) {
		return getData().getAllDataList().get(Index).getCategory();
	}
	
	// IndividualRound Entry Start
	public String getIndividualEntryType(Integer Competition_Index, Integer Entry_Index) {
		return getData().getAllDataList().get(Competition_Index).getIndividualEntry(Entry_Index).getEntryType();
	}

	// IndividualRound Qualification Round
	public String getIndividualQualificationStage(Integer Competition_Index, Integer Entry_Index){
		return getData().getAllDataList().get(Competition_Index).getIndividualEntry(Entry_Index).getQualificationState().getStage();
	}

	public String getIndividualQualificationStageContestantName(Integer Competition_Index, Integer Entry_Index, Integer Contestant_Index) {
		return getData().getAllDataList().get(Competition_Index).getIndividualEntry(Entry_Index).getQualificationState().getContestants(Contestant_Index).getName();
	}

	public Integer getIndividualQualificationStageContestantRanking(Integer Competition_Index, Integer Entry_Index, Integer Contestant_Index) {
		return getData().getAllDataList().get(Competition_Index).getIndividualEntry(Entry_Index).getQualificationState().getContestants(Contestant_Index).getRanking();
	}

	public Integer getIndividualQualificationStageContestantSetNumber(Integer Competition_Index, Integer Entry_Index, Integer Contestant_Index, Integer Set_Index) {
		return getData().getAllDataList().get(Competition_Index).getIndividualEntry(Entry_Index).getQualificationState().getContestants(Contestant_Index).getScore(Set_Index).getSetNumber();
	}

	public Integer getIndividualQualificationStageContestantArrowPoints(Integer Competition_Index, Integer Entry_Index, Integer Contestant_Index, Integer Set_Index, Integer Arrow_Index) {
		return getData().getAllDataList().get(Competition_Index).getIndividualEntry(Entry_Index).getQualificationState().getContestants(Contestant_Index).getScore(Set_Index).getValue(Arrow_Index);
	}

	public Integer getIndividualQualificationStageContestantSum(Integer Competition_Index, Integer Entry_Index, Integer Contestant_Index, Integer Set_Index) {
		return getData().getAllDataList().get(Competition_Index).getIndividualEntry(Entry_Index).getQualificationState().getContestants(Contestant_Index).getScore(Set_Index).getSum();
	}

	public Integer getIndividualQualificationStageContestantTenPlusX(Integer Competition_Index, Integer Entry_Index, Integer Contestant_Index, Integer Set_Index) {
		return getData().getAllDataList().get(Competition_Index).getIndividualEntry(Entry_Index).getQualificationState().getContestants(Contestant_Index).getScore(Set_Index).getTenPlusX();
	}

	public Integer getIndividualQualificationStageContestantAmountOfX(Integer Competition_Index, Integer Entry_Index, Integer Contestant_Index, Integer Set_Index) {
		return getData().getAllDataList().get(Competition_Index).getIndividualEntry(Entry_Index).getQualificationState().getContestants(Contestant_Index).getScore(Set_Index).getAmountOfX();
	}
	// IndividualRound Qualification End
        
        //Individual Match Round Start 
         public String getIndividualMatchesStage(Integer Competition_Index, Integer Entry_Index, Integer Match_Index){
          return getData().getAllDataList().get(Competition_Index).getIndividualEntry(Entry_Index).getMatchState(Match_Index).getStage();
       } 
         public String getIndividualMatchesStageFirstContestantName(Integer Competition_Index, Integer Entry_Index, Integer Match_Index, Integer Contestant_Index){
           return getData().getAllDataList().get(Competition_Index).getIndividualEntry(Entry_Index).getMatchState(Match_Index).getMatches(Contestant_Index).getFirstContestant();
       }
       public String getIndividualMatchesStageSecondContestantName(Integer Competition_Index, Integer Entry_Index, Integer Match_Index, Integer Contestant_Index){
           return getData().getAllDataList().get(Competition_Index).getIndividualEntry(Entry_Index).getMatchState(Match_Index).getMatches(Contestant_Index).getSecondContestant();
       }
       public Integer getIndividualMatchesStageSetNumber(Integer Competition_Index, Integer Entry_Index, Integer Match_Index, Integer Contestant_Index, Integer Set_Index){
           return getData().getAllDataList().get(Competition_Index).getIndividualEntry(Entry_Index).getMatchState(Match_Index).getMatches(Contestant_Index).getScore(Set_Index).getSetNumber();
       }
       public Integer getIndividualMatchesStageFirstContestantArrowPoints(Integer Competition_Index, Integer Entry_Index, Integer Match_Index, Integer Contestant_Index, Integer Set_Index, Integer Arrow_Index){
           return getData().getAllDataList().get(Competition_Index).getIndividualEntry(Entry_Index).getMatchState(Match_Index).getMatches(Contestant_Index).getScore(Set_Index).getFirstContestantArrows(Arrow_Index);
       }
       public Integer getIndividualMatchesStageFirstContestantAccumulativePoints(Integer Competition_Index, Integer Entry_Index, Integer Match_Index, Integer Contestant_Index, Integer Set_Index){
           return getData().getAllDataList().get(Competition_Index).getIndividualEntry(Entry_Index).getMatchState(Match_Index).getMatches(Contestant_Index).getScore(Set_Index).getFirstContestantAccumulativeSetPoints();
       }
       public Integer getIndividualMatchesStageFirstContestantSetPoints(Integer Competition_Index, Integer Entry_Index, Integer Match_Index, Integer Contestant_Index, Integer Set_Index){
           return getData().getAllDataList().get(Competition_Index).getIndividualEntry(Entry_Index).getMatchState(Match_Index).getMatches(Contestant_Index).getScore(Set_Index).getFirstContestantSetPoints();
       }
       public Integer getIndividualMatchesStageSecondContestantArrowPoints(Integer Competition_Index, Integer Entry_Index, Integer Match_Index, Integer Contestant_Index, Integer Set_Index, Integer Arrow_Index){
           return getData().getAllDataList().get(Competition_Index).getIndividualEntry(Entry_Index).getMatchState(Match_Index).getMatches(Contestant_Index).getScore(Set_Index).getSecondContestantArrows(Arrow_Index);
       }
       public Integer getIndividualMatchesStageSecondContestantAccumulativePoints(Integer Competition_Index, Integer Entry_Index, Integer Match_Index, Integer Contestant_Index, Integer Set_Index){
           return getData().getAllDataList().get(Competition_Index).getIndividualEntry(Entry_Index).getMatchState(Match_Index).getMatches(Contestant_Index).getScore(Set_Index).getSecondContestantAccumulativeSetPoints();
       }
       public Integer getIndividualMatchesStageSecondContestantSetPoints(Integer Competition_Index, Integer Entry_Index, Integer Match_Index, Integer Contestant_Index, Integer Set_Index){
           return getData().getAllDataList().get(Competition_Index).getIndividualEntry(Entry_Index).getMatchState(Match_Index).getMatches(Contestant_Index).getScore(Set_Index).getSecondContestantSetPoints();
                   
       }
       //Individual Match Round End
           
	// IndividualRound Entry End
	
	// TeamRound Entry Start
	public String getTeamEntryType(Integer Competition_Index, Integer Entry_Index) {
		return getData().getAllDataList().get(Competition_Index).getTeamEntry(Entry_Index).getEntryType();
	}
	// TeamRound Entry End
	// FrontEnd End

    public void addCompetitionData(CompetitionData v) {
	    data.addDataList(v);
    }
}