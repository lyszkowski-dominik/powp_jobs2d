package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.CustomLineFeature;
import edu.kis.powp.jobs2d.features.DrawerFeature;

import java.awt.*;

/**
 * driver adapter to drawer with several bugs.
 */
public class DrawerAdapter extends DrawPanelController implements Job2dDriver {
    private int startX = 0, startY = 0;
    private final DrawPanelController drawPanelController;
    private Color lineColor = Color.BLACK;
    private float thickness = 1.0f;
    private boolean dotted = false;

    public DrawerAdapter() {
        super();
        this.drawPanelController = DrawerFeature.getDrawerController();
    }

    @Override
    public void setPosition(int x, int y) {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void operateTo(int x, int y) {
        CustomLineFeature line = new CustomLineFeature(lineColor, thickness, dotted);
        line.setStartCoordinates(this.startX, this.startY);
        line.setEndCoordinates(x, y);

        this.drawPanelController.drawLine(line);
        setPosition(x, y);
    }

    @Override
    public String toString() {
        return "Custom Line Driver";
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    public void setThickness(float thickness) {
        this.thickness = thickness;
    }

    public void setIsDotted(boolean dotted) {
        this.dotted = dotted;
    }

    public boolean getIsDotted() {
        return this.dotted;
    }
}
