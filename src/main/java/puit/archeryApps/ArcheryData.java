package puit.archeryApps;

import java.util.ArrayList;
import java.io.*;
import java.util.Iterator;
import com.google.gson.*;

class archeryDataList {
	// Variables
	private ArrayList <CompetitionList> dataList;
	// Methods
	public archeryDataList() {
		setDataList(new ArrayList<CompetitionList>());
	}
	public archeryDataList(archeryDataList value) {
		setDataList(value.getAllDataList());
	}
	public void setDataList(ArrayList<CompetitionList> value) {
		this.dataList = new ArrayList<CompetitionList>();
		dataList.addAll(value);
	}
	public void addDataList(CompetitionList value) {
		this.dataList.add(value);
	}
	public ArrayList<CompetitionList> getAllDataList(){
		return this.dataList;
	}
	public CompetitionList getDataList(Integer Index) {
		return this.dataList.get(Index);
	}
}

public class ArcheryData{
	// Variables
	private Gson gson;
	private String path;
	private archeryDataList data;
	private String[][] ERROR = {{"[ERROR]=>FILE NOT FOUND. Code:[0][0]","[ERROR]=>PROBLEM IN CONVERTING JSON TO OBJECT. Code:[0][1]"},{"[ERROR]=>CANNOT CONVERT TO UNIVERSAL PATH. Code:[1][0]"}};
	
	// Methods
	// BackEnd Start
	private archeryDataList getData() {
		return this.data;
	}
	public void printError(String value) {
		System.err.println(value);
	}
	private void getJson() throws FileNotFoundException, Exception{
		this.data = gson.fromJson(new FileReader(this.getPath()), archeryDataList.class);
	}
	private void toUniversalPath(String path) {
		try {
			String result = path.replace("\\", "/");
			setPath(result);
		}catch(Exception e) {
			printError(ERROR[1][0]);
			printError(e.getMessage());
		}
	}	
	// BackEnd End
	
	// FrontEnd Start
	public ArcheryData() {
		this.gson = new Gson();
		toUniversalPath(new File("").getAbsolutePath() + "/data/archerydata.json");
		try {
			getJson();
		}catch(FileNotFoundException e) {
			printError(ERROR[0][0]);
			printError(e.getMessage());
		}
		catch(Exception e) {
			printError(ERROR[0][1]);
			printError(e.getMessage());
		}
	}	
	public ArcheryData(String path) {
		gson = new Gson();
		toUniversalPath(path);
		try {
			getJson();
		}catch(FileNotFoundException e) {
			printError(ERROR[0][0]);
			printError(e.getMessage());
		}
		catch(Exception e) {
			printError(ERROR[0][1]);
			printError(e.getMessage());
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
	
	// Individual Entry Start
	public String getIndividualEntryType(Integer Competition_Index, Integer Entry_Index) {
		return getData().getAllDataList().get(Competition_Index).getIndividualEntry(Entry_Index).getEntryType();
	}
	// Individual Qualification Round
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
	// Individual Qualification End
	// Individual Entry End
	
	// Team Entry Start
	public String getTeamEntryType(Integer Competition_Index, Integer Entry_Index) {
		return getData().getAllDataList().get(Competition_Index).getTeamEntry(Entry_Index).getEntryType();
	}
	// Team Entry End
	// FrontEnd End
}