package edu.kis.powp.jobs2d;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.kis.legacy.drawer.panel.DefaultDrawerFrame;
import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.drivers.adapter.DrawerAdapter;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;
import edu.kis.powp.jobs2d.events.SelectChangeVisibleOptionListener;
import edu.kis.powp.jobs2d.events.FigureButtonListener;
import edu.kis.powp.jobs2d.features.DrawerFeature;
import edu.kis.powp.jobs2d.features.DriverFeature;
import edu.kis.powp.jobs2d.tests.Figure1TestStrategy;
import edu.kis.powp.jobs2d.tests.Figure2TestStrategy;

public class TestJobs2dPatterns {
    private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    /**
     * Setup test concerning preset figures in context.
     *
     * @param application Application context.
     */
    private static void setupPresetTests(Application application) {
        application.addTest("Test Figure 1", new FigureButtonListener(DriverFeature.getDriverManager(), new Figure1TestStrategy()));
        application.addTest("Test Figure 2", new FigureButtonListener(DriverFeature.getDriverManager(), new Figure2TestStrategy()));
    }

    /**
     * Setup driver manager, and set default driver for application.
     *
     * @param application Application context.
     */
    private static void setupDrivers(Application application) {
        Job2dDriver loggerDriver = new LoggerDriver();
        DriverFeature.addDriver("Logger Driver", loggerDriver);
        DriverFeature.getDriverManager().setCurrentDriver(loggerDriver);

        Job2dDriver solidDriver = new DrawerAdapter();
        DriverFeature.addDriver("Custom Line Driver", solidDriver);

        Job2dDriver specialDriver = new LineDrawerAdapter();
        DriverFeature.addDriver("Special Line Driver", specialDriver);

        setupLineParams(application, (DrawerAdapter) solidDriver);

        DriverFeature.updateDriverInfo();
    }

    /**
     * Auxiliary routines to enable using Buggy Simulator.
     *
     * @param application Application context.
     */
    private static void setupDefaultDrawerVisibilityManagement(Application application) {
        DefaultDrawerFrame defaultDrawerWindow = DefaultDrawerFrame.getDefaultDrawerFrame();
        application.addComponentMenuElementWithCheckBox(DrawPanelController.class, "Default Drawer Visibility",
                new SelectChangeVisibleOptionListener(defaultDrawerWindow), true);
//		defaultDrawerWindow.setVisible(true);
    }

    /**
     * Setup menu for adjusting logging settings.
     *
     * @param application Application context.
     */
    private static void setupLogger(Application application) {
        application.addComponentMenu(Logger.class, "Logger", 0);
        application.addComponentMenuElement(Logger.class, "Clear log",
                (ActionEvent e) -> application.flushLoggerOutput());
        application.addComponentMenuElement(Logger.class, "Fine level", (ActionEvent e) -> logger.setLevel(Level.FINE));
        application.addComponentMenuElement(Logger.class, "Info level", (ActionEvent e) -> logger.setLevel(Level.INFO));
        application.addComponentMenuElement(Logger.class, "Warning level",
                (ActionEvent e) -> logger.setLevel(Level.WARNING));
        application.addComponentMenuElement(Logger.class, "Severe level",
                (ActionEvent e) -> logger.setLevel(Level.SEVERE));
        application.addComponentMenuElement(Logger.class, "OFF logging", (ActionEvent e) -> logger.setLevel(Level.OFF));
    }
    /**
     *  Setup for adjusting line parameters
     * @param application Application context
     */
    private static void setupLineParams(Application application, DrawerAdapter drawerAdapter){
        application.addComponentMenu(DrawerAdapter.class, "Line Params");
        application.addComponentMenuElement(DrawerAdapter.class, "Color: Red", (ActionEvent e) -> drawerAdapter.setLineColor(Color.RED));
        application.addComponentMenuElement(DrawerAdapter.class, "Color: Blue", (ActionEvent e) -> drawerAdapter.setLineColor(Color.BLUE));
        application.addComponentMenuElement(DrawerAdapter.class, "Thickness: 1.0f", (ActionEvent e) -> drawerAdapter.setThickness(1.0f));
        application.addComponentMenuElement(DrawerAdapter.class, "Thickness: 2.0f", (ActionEvent e) -> drawerAdapter.setThickness(2.0f));
        application.addComponentMenuElementWithCheckBox(DrawerAdapter.class, "Dotted", (ActionEvent e) -> drawerAdapter.setIsDotted(!drawerAdapter.getIsDotted()), false);
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Application app = new Application("2d jobs Visio");
                DrawerFeature.setupDrawerPlugin(app);
                setupDefaultDrawerVisibilityManagement(app);

                DriverFeature.setupDriverPlugin(app);
                setupDrivers(app);
                setupPresetTests(app);
                setupLogger(app);

                app.setVisibility(true);
            }
        });
    }

}
