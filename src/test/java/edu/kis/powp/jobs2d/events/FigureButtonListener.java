package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.features.DrawerFeature;
import edu.kis.powp.jobs2d.tests.TestStrategy;

public class FigureButtonListener implements ActionListener {

    private final DriverManager driverManager;
    private final TestStrategy testStrategy;
    private final DrawPanelController drawPanelController;

    public FigureButtonListener(DriverManager driverManager, TestStrategy testStrategy) {
        this.driverManager = driverManager;
        this.testStrategy = testStrategy;
        this.drawPanelController = DrawerFeature.getDrawerController();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.drawPanelController.clearPanel();
        testStrategy.execute(driverManager);
    }
}