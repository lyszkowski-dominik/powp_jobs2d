package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class OperateToCommand implements DriverCommand {
    private int x;
    private int y;
    private Job2dDriver job2dDriver;

    public OperateToCommand(int x, int y, Job2dDriver job2dDriver) {
        this.x = x;
        this.y = y;
        this.job2dDriver = job2dDriver;
    }

    @Override
    public void execute() {
        System.out.println("Driver operateTo (x:" + x + ", y:" + y + ") ");
        job2dDriver.operateTo(x, y);
    }
}
