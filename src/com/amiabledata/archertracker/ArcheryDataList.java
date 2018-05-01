package com.amiabledata.archertracker;

import java.util.ArrayList;

public class ArcheryDataList {
    private ArrayList<CompetitionData> dataList;

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
