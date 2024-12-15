package edu.kis.powp.command;

public class ComplexCommand implements DriverCommand {
    private DriverCommand[] driverCommands;

    public ComplexCommand(DriverCommand[] driverCommands) {
        this.driverCommands = driverCommands;
    }

    @Override
    public void execute() {
        for (DriverCommand driverCommand : driverCommands) {
            driverCommand.execute();
        }
    }
}
