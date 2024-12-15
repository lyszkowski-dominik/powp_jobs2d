package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class ComplexCommandFactory {
    public static ComplexCommand createRectangle(Job2dDriver job2dDriver, int x, int y, int width, int height) {
        DriverCommand[] driverCommands = new DriverCommand[4];
        driverCommands[0] = new SetPositionCommand(x, y, job2dDriver);
        driverCommands[1] = new OperateToCommand(x + width, y, job2dDriver);
        driverCommands[2] = new OperateToCommand(x + width, y + height, job2dDriver);
        driverCommands[3] = new OperateToCommand(x, y + height, job2dDriver);
        return new ComplexCommand(driverCommands);
    }

    public static ComplexCommand createTriangle(int x1, int y1, int x2, int y2, int x3, int y3, Job2dDriver job2dDriver) {
        DriverCommand[] driverCommands = new DriverCommand[3];
        driverCommands[0] = new SetPositionCommand(x1, y1, job2dDriver);
        driverCommands[1] = new OperateToCommand(x2, y2, job2dDriver);
        driverCommands[2] = new OperateToCommand(x3, y3, job2dDriver);
        return new ComplexCommand(driverCommands);
    }
}
