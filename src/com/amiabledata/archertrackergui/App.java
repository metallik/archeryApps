package com.amiabledata.archertrackergui;

import com.amiabledata.archertracker.ArcheryDataHelper;

import javax.swing.*;
import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) {
        MainWindow mw = new MainWindow();
        ArcheryDataHelper db;

        if (args.length == 2) {
            try {
                db = new ArcheryDataHelper(args[1]);
            } catch (FileNotFoundException err) {
                JOptionPane.showMessageDialog(null,"File \"" + args[1] + "\" not found!", "File not found", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
        } else if (args.length > 2) {
            JOptionPane.showMessageDialog(null,"Invalid parameter count: " + args.length, "Invalid parameter", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } else {
            //JOptionPane.showMessageDialog(null,"No parameter supplied, using empty dataset.", "No parameter", JOptionPane.INFORMATION_MESSAGE);
            db = new ArcheryDataHelper();
        }
    }
}
