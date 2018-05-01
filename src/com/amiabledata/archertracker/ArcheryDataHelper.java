package com.amiabledata.archertracker;

import java.util.ArrayList;
import java.io.*;

import com.google.gson.*;

class ArcheryDataList {
	private ArrayList <CompetitionData> dataList;

	public ArcheryDataList() {
		setDataList(new ArrayList<CompetitionData>());
	}
	public ArcheryDataList(ArcheryDataList value) {
		setDataList(value.getAllDataList());
	}
	public void setDataList(ArrayList<CompetitionData> value) {
		this.dataList = new ArrayList<CompetitionData>();
		dataList.addAll(value);
	}
	public void addDataList(CompetitionData value) {
		this.dataList.add(value);
	}
	public ArrayList<CompetitionData> getAllDataList(){
		return this.dataList;
	}
	public CompetitionData getDataList(Integer Index) {
		return this.dataList.get(Index);
	}
}

public class ArcheryDataHelper {
	private Gson gson = new Gson();
	private String path;
	private ArcheryDataList data;

	// BackEnd Start
	private ArcheryDataList getData() {
		return this.data;
	}

	private void getJson(File f) throws FileNotFoundException {
		this.data = gson.fromJson(new FileReader(f), ArcheryDataList.class);
	}
	// BackEnd End
	
	// FrontEnd Start
	public ArcheryDataHelper(String path) throws FileNotFoundException, NullPointerException {
	    this(new File(path));
	}

    public ArcheryDataHelper(File f) throws FileNotFoundException, NullPointerException {
	    if (f == null) {
	        throw new NullPointerException();
        } else if (!f.isFile()) {
	        throw new FileNotFoundException();
        } else {
            getJson(f);
        }
    }

	public void setPath(String value) {
		this.path = value;
	}

	public String getPath() {
		return this.path;
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