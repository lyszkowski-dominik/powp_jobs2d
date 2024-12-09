package edu.kis.powp.jobs2d.tests;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class Figure1TestStrategy implements TestStrategy{
    @Override
    public void execute(DriverManager driverManager) {
        FiguresJoe.figureScript1(driverManager.getCurrentDriver());
    }
}