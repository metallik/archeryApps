package com.amiabledata.archertracker;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class App {
    public static void main( String[] args ) {
        ArcheryData Archery = new ArcheryData();
        CompetitionData n = new CompetitionData();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(Archery);
        System.out.println(json);

//      System.out.print(Archery.getIndividualQualificationStageContestantSum(0,0,0,0));
// MainGUI g = new MainGUI();
//    	g.setVisible(true);
    }
}
