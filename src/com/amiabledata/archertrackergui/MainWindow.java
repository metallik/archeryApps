package com.amiabledata.archertrackergui;

import com.amiabledata.archertracker.ArcheryDataHelper;

import javax.swing.*;

public class MainWindow extends JFrame {
    private ArcheryDataHelper dataSource;

    private JTabbedPane mainTabs;
    private JTabbedPane individualTabs;
    private JTabbedPane teamTabs;

    private JTable individualQualificationTable;
    private JTable individualMTable;

    private void setupUi() {
        mainTabs = new JTabbedPane();
        individualTabs = new JTabbedPane();
        teamTabs = new JTabbedPane();
    }

    public MainWindow() {
        this(new ArcheryDataHelper());
    }

    public MainWindow(ArcheryDataHelper dh) {
        super();
        setupUi();
        setDataSource(dh);
    }

    public void setDataSource(ArcheryDataHelper dh) {
        dataSource = dh;
    }
}
