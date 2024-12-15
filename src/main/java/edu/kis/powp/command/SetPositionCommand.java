package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class SetPositionCommand implements DriverCommand {
    private int x;
    private int y;

    public Job2dDriver getJob2dDriver() {
        return job2dDriver;
    }

    public void setJob2dDriver(Job2dDriver job2dDriver) {
        this.job2dDriver = job2dDriver;
    }

    private Job2dDriver job2dDriver;

    public SetPositionCommand(int x, int y, Job2dDriver job2dDriver) {
        this.x = x;
        this.y = y;
        this.job2dDriver = job2dDriver;
    }

    @Override
    public void execute() {
        System.out.println("Driver setPosition (x:" + x + ", y:" + y + ") ");
        job2dDriver.setPosition(x, y);
    }
}
