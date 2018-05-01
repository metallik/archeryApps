package com.amiabledata.archertrackergui;

import com.amiabledata.archertracker.ArcheryDataHelper;
import com.amiabledata.archertracker.ArcheryDataList;
import com.amiabledata.archertracker.CompetitionData;
import com.amiabledata.archertracker.matches.IndividualContestantMatches;
import com.amiabledata.archertracker.qualification.IndividualContestantQualification;
import com.amiabledata.archertracker.round.IndividualRound;
import com.amiabledata.archertracker.round.TeamRound;
import com.amiabledata.archertracker.score.IndividualMatchesScore;
import com.amiabledata.archertracker.score.IndividualQualificationScore;
import com.amiabledata.archertracker.stage.IndividualMatchesStage;

import javax.swing.*;
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

        int csel, sel, tsel, qmsel, ctsel, rsel, msel;
        while ((csel = getCompetitionSelection()) >= 0) {
            while ((sel = getIndividualOrTeam()) >= 0) {
                if (sel == 1) {
                    // team
                    // FIXME!
                    JOptionPane.showMessageDialog(null,"FIXME!");
                    continue;
                }
                while ((tsel = getEntryTypeSelectionOf(csel, sel)) >= 0) {
                    while ((qmsel = getQualificationOrMatch()) >= 0) {
                        switch(qmsel) {
                            case 0: // qualification
                                while ((ctsel = getQualificationContestantOf(csel, sel, tsel)) >= 0) {
                                    showIndividualContestantQualification(csel, sel, tsel, ctsel);
                                }
                                break;
                            case 1: // match
                                while ((rsel = getRoundSelectionOf(csel, sel, tsel)) >= 0) {
                                    while ((msel = getMatchSelectionOf(csel, sel, tsel, rsel)) >= 0) {
                                        showIndividualMatchSelection(csel, sel, tsel, rsel, msel);
                                    }
                                }
                                break;
                        }
                    }
                }
            }
        }

        return 0;
    }

    public int getIndividualOrTeam() {
        ArrayList<String> sel = new ArrayList<String>();
        sel.add("Individual");
        sel.add("Team");

        return getUserSelectionOf(sel);
    }

    public int getEntryTypeSelectionOf(int competition, int unit) {
        CompetitionData cd = cdl.get(competition);
        if (unit == 0) {
            ArrayList<IndividualRound> r = cd.getAllIndividualEntry();
            ArrayList<String> sel = new ArrayList<String>();

            for (IndividualRound i : r) {
                if (i == null) {
                    break;
                }

                sel.add(i.getEntryType());
            }

            return getUserSelectionOf(sel);
        } else if (unit == 1) {
            ArrayList<TeamRound> r = cd.getAllTeamEntry();
            ArrayList<String> sel = new ArrayList<String>();

            for (TeamRound i : r) {
                if (i == null) {
                    break;
                }

                sel.add(i.getEntryType());
            }

            return getUserSelectionOf(sel);
        } else {
            return -1;
        }
    }

    public int getQualificationOrMatch() {
        ArrayList<String> sel = new ArrayList<String>();
        sel.add("Qualification");
        sel.add("Match");

        return getUserSelectionOf(sel);
    }

    public int getRoundSelectionOf(int competition, int unit, int entrytype) {
        CompetitionData cd = cdl.get(competition);
        if (unit == 0) {
            ArrayList<IndividualMatchesStage> r = cd.getAllIndividualEntry().get(entrytype).getAllMatchState();
            ArrayList<String> sel = new ArrayList<String>();

            for (IndividualMatchesStage i : r) {
                sel.add(i.getStage());
            }

            return getUserSelectionOf(sel);
        } else if (unit == 1) {
            // FIXME!
            JOptionPane.showMessageDialog(null,"FIXME!");
            return -1;
        } else {
            return -1;
        }
    }

    public int getMatchSelectionOf(int competition, int unit, int entrytype, int round) {
        CompetitionData cd = cdl.get(competition);
        if (unit == 0) {
            ArrayList<IndividualContestantMatches> r = cd.getAllIndividualEntry().get(entrytype).getMatchState(round).getAllMatches();
            ArrayList<String> sel = new ArrayList<String>();

            for (IndividualContestantMatches i : r) {
                sel.add(i.getFirstContestant() + " - " + i.getSecondContestant());
            }

            return getUserSelectionOf(sel);
        } else if (unit == 1) {
            // FIXME!
            JOptionPane.showMessageDialog(null,"FIXME!");
            return -1;
        } else {
            return -1;
        }
    }

    public int getQualificationContestantOf(int competition, int unit, int entrytype) {
        CompetitionData cd = cdl.get(competition);
        if (unit == 0) {
            ArrayList<IndividualContestantQualification> r = cd.getAllIndividualEntry().get(entrytype).getQualificationState().getAllContestants();
            ArrayList<String> sel = new ArrayList<String>();

            for (IndividualContestantQualification i : r) {
                sel.add(i.getName());
            }

            return getUserSelectionOf(sel);
        } else if (unit == 1) {
            // FIXME!
            JOptionPane.showMessageDialog(null,"FIXME!");
            return -1;
        } else {
            return -1;
        }
    }

    private int getUserSelectionOf(final ArrayList<String> list) {
        int r, sel;

        TableModel dataModel = new AbstractTableModel() {
            public int getColumnCount() { return 1; }
            public int getRowCount() { return list.size();}
            public Object getValueAt(int row, int col) {
                return list.get(row);
            }

            @Override
            public String getColumnName(int column) {
                return null;
            }
        };
        JTable table = new JTable(dataModel);
        JScrollPane scrollpane = new JScrollPane(table);

        do {
            r = JOptionPane.showConfirmDialog(null, scrollpane, "Select an option to proceed", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            sel = table.getSelectedRow();
            System.out.println("Got option: " + r);
            System.out.println("Got sel: " + table.getSelectedRow());

            switch (r) {
                case JOptionPane.OK_OPTION:
                    if (sel >= 0) {
                        return sel;
                    } else {
                        JOptionPane.showMessageDialog(null, "You need to select an option!", "No selection", JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                case JOptionPane.CANCEL_OPTION:
                    return -1;
            }
        } while(true);
    }

    private void showIndividualContestantQualification(int competition, int unit, int entrytype, int contestant) {
        IndividualContestantQualification d = cdl.get(competition).getAllIndividualEntry().get(entrytype).getQualificationState().getContestants(contestant);
        final ArrayList<IndividualQualificationScore> s = d.getAllScore();

        TableModel dataModel = new AbstractTableModel() {
            public int getColumnCount() { return 10; }
            public int getRowCount() { return s.size();}
            public Object getValueAt(int row, int col) {
                String n;
                IndividualQualificationScore r = s.get(row);
                int sc;
                switch(col) {
                    case 0:
                        n = "" + r.getSetNumber();
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        sc = r.getValue(col-1);
                        if (sc > 10) {
                            n = "X";
                        } else {
                            n = "" + sc;
                        }
                        break;
                    case 7:
                        n = "" + r.getSum();
                        break;
                    case 8:
                        n = "" + r.getTenPlusX();
                        break;
                    case 9:
                        n = "" + r.getAmountOfX();
                        break;
                    default:
                        n = "Boink!";
                }
                return n;
            }

            @Override
            public String getColumnName(int column) {
                String n;
                switch(column) {
                    case 0:
                        n = "Set";
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        n = "" + column;
                        break;
                    case 7:
                        n = "Sum";
                        break;
                    case 8:
                        n = "10+X";
                        break;
                    case 9:
                        n = "X";
                        break;
                    default:
                        n = "Boink!";
                }
                return n;
            }
        };
        JTable table = new JTable(dataModel);
        JScrollPane scrollpane = new JScrollPane(table);

        JOptionPane.showMessageDialog(null, scrollpane, d.getName() + " [Rank: " + d.getRanking() + "]", JOptionPane.OK_OPTION);
    }

    private void showIndividualMatchSelection(int competition, int unit, int entrytype, int round, int match) {
        IndividualContestantMatches d = cdl.get(competition).getAllIndividualEntry().get(entrytype).getMatchState(round).getMatches(match);
        final ArrayList<IndividualMatchesScore> s = d.getAllScore();

        TableModel dataModel = new AbstractTableModel() {
            public int getColumnCount() { return 11; }
            public int getRowCount() { return s.size();}
            public Object getValueAt(int row, int col) {
                String n;
                IndividualMatchesScore r = s.get(row);
                int sc;
                switch(col) {
                    case 0:
                        n = "" + r.getSetNumber();
                        break;
                    case 1:
                    case 2:
                    case 3:
                        sc = r.getFirstContestantArrows(col-1);
                        if (sc > 10) {
                            n = "X";
                        } else {
                            n = "" + sc;
                        }
                        break;
                    case 4:
                        n = "" + r.getFirstContestantAccumulativeSetPoints();
                        break;
                    case 5:
                        n = "" + r.getFirstContestantSetPoints();
                        break;
                    case 6:
                    case 7:
                    case 8:
                        sc = r.getSecondContestantArrows(col-6);
                        if (sc > 10) {
                            n = "X";
                        } else {
                            n = "" + sc;
                        }
                        break;
                    case 9:
                        n = "" + r.getSecondContestantAccumulativeSetPoints();
                        break;
                    case 10:
                        n = "" + r.getSecondContestantSetPoints();
                        break;
                    default:
                        n = "Boink!";
                }
                return n;
            }

            @Override
            public String getColumnName(int column) {
                String n;
                switch(column) {
                    case 0:
                        n = "Set";
                        break;
                    case 1:
                    case 2:
                    case 3:
                        n = "" + column;
                        break;
                    case 4:
                        n = "AccPts";
                        break;
                    case 5:
                        n = "Pts #1";
                        break;
                    case 6:
                    case 7:
                    case 8:
                        n = "" + (column - 5);
                        break;
                    case 9:
                        n = "AccPts";
                        break;
                    case 10:
                        n = "Pts #2";
                        break;
                    default:
                        n = "Boink!";
                }
                return n;
            }
        };
        JTable table = new JTable(dataModel);
        JScrollPane scrollpane = new JScrollPane(table);

        JOptionPane.showMessageDialog(null, scrollpane, d.getFirstContestant() + " - " + d.getSecondContestant(), JOptionPane.OK_OPTION);
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
        if (cmdArgs.length == 1) {
            return new File(cmdArgs[0]);
        } else if (cmdArgs.length > 1) {
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
        System.out.println("Got " + args.length + " argument(s)");
        if (args.length == 1) {
            System.out.println("Got file: " + args[0]);
        }

        App inst = new App(args);
        inst.beginApp();
    }
}
