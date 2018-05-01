package com.amiabledata.archertracker;

import java.io.File;
import java.io.FileNotFoundException;

public class App {
    public static void main( String[] args ) {
        ArcheryDataHelper Archery;

        try {
            Archery = new ArcheryDataHelper(new File("").getAbsolutePath() + "/data/archerydata.json");
            System.out.print(Archery.getIndividualQualificationStageContestantSum(0,0,0,0));
        } catch (FileNotFoundException err) {
            System.out.println("File not found!");
        }

// MainGUI g = new MainGUI();
//    	g.setVisible(true);
    }
}
