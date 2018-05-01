package com.amiabledata.archertrackergui;

import com.amiabledata.archertracker.ArcheryDataHelper;
import com.amiabledata.archertracker.ArcheryDataList;
import com.amiabledata.archertracker.CompetitionData;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class App {
    ArcheryDataHelper db = new ArcheryDataHelper();
    ArcheryDataList dl;
    ArrayList<CompetitionData> cdl;

    String[] cmdArgs;

    public App(String[] args) {
        cmdArgs = args;
    }

    public int beginApp() {
        File f = null;

        try {
            f = autoSelectFile();
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, err.getMessage(), "Fatal error", JOptionPane.ERROR_MESSAGE);
            return 1;
        }

        if (f == null) {
            return 0;
        }

        try {
            db.setFile(f);
        } catch (FileNotFoundException err) {
            JOptionPane.showMessageDialog(null,"File \"" + f.getAbsolutePath() + "\" not found!\nExiting...", "File not found", JOptionPane.ERROR_MESSAGE);
            return 1;
        }

        dl = db.getDataList();
        cdl = dl.getAllDataList();

        int sel;
        while ((sel = getCompetitionSelection()) >= 0) {
            showOtherStuff(sel);
        }

        return 0;
    }

    private void showOtherStuff(int idx) {
        // FIXME
        JOptionPane.showMessageDialog(null,"FIXME! sel="+idx);
    }

    public File selectFile() {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Select data source");
        fc.setDialogType(JFileChooser.OPEN_DIALOG);

        do {
            switch (fc.showDialog(null, "Load")) {
                case JFileChooser.APPROVE_OPTION:
                    return fc.getSelectedFile();
                default:
                    return null;
            }
        } while (true);
    }

    private File autoSelectFile() throws Exception {
        if (cmdArgs.length == 2) {
            return new File(cmdArgs[1]);
        } else if (cmdArgs.length > 2) {
            //JOptionPane.showMessageDialog(null,"Invalid parameter count: " + cmdArgs.length, "Invalid parameter", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Invalid parameter count: " + cmdArgs.length);
        } else {
            return selectFile();
        }
    }

    public int getCompetitionSelection() {
        int r, sel;

        TableModel dataModel = new AbstractTableModel() {
            public int getColumnCount() { return 5; }
            public int getRowCount() { return cdl.size();}
            public Object getValueAt(int row, int col) {
                String v;
                CompetitionData cd = cdl.get(row);
                switch(col) {
                    case 0:
                        v = cd.getCompetitionName();
                        break;
                    case 1:
                        v = cd.getStartDate();
                        break;
                    case 2:
                        v = cd.getEndDate();
                        break;
                    case 3:
                        v = cd.getLocation();
                        break;
                    case 4:
                        v = cd.getEventFinished().toString();
                        break;
                    default:
                        v = "Boink!";
                }
                return v;
            }

            @Override
            public String getColumnName(int column) {
                String n;
                switch(column) {
                    case 0:
                        n = "Competition Name";
                        break;
                    case 1:
                        n = "Start Date";
                        break;
                    case 2:
                        n = "End Data";
                        break;
                    case 3:
                        n = "Location";
                        break;
                    case 4:
                        n = "Is Finished";
                        break;
                    default:
                        n = "Boink!";
                }
                return n;
            }
        };
        JTable table = new JTable(dataModel);
        JScrollPane scrollpane = new JScrollPane(table);

        do {
            r = JOptionPane.showConfirmDialog(null, scrollpane, "Select event", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            sel = table.getSelectedRow();
            System.out.println("Got option: " + r);
            System.out.println("Got sel: " + table.getSelectedRow());

            switch (r) {
                case JOptionPane.OK_OPTION:
                    if (sel >= 0) {
                        return sel;
                    } else {
                        JOptionPane.showMessageDialog(null, "You need to select a competition!", "No selection", JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                case JOptionPane.CANCEL_OPTION:
                    return -1;
            }
        } while(true);
    }

    public static void main(String[] args) {
        App inst = new App(args);
        inst.beginApp();
    }
}
