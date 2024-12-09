package edu.kis.powp.jobs2d.features;

import edu.kis.legacy.drawer.shape.ILine;

import java.awt.*;

public class CustomLineFeature implements ILine {
    private int startX, startY, endX, endY;
    private final Color color;
    private final float thickness;
    private final boolean dotted;

    public CustomLineFeature(Color color, float thickness, boolean dotted){
        this.color = color;
        this.thickness = thickness;
        this.dotted = dotted;
    }

    @Override
    public Object clone() {
        try {
            return (CustomLineFeature) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public float getThickness() {
        return thickness;
    }

    @Override
    public boolean isDotted() {
        return dotted;
    }

    @Override
    public int getStartCoordinateX() {
        return startX;
    }

    @Override
    public int getEndCoordinateX() {
        return endX;
    }

    @Override
    public int getStartCoordinateY() {
        return startY;
    }

    @Override
    public int getEndCoordinateY() {
        return endY;
    }

    @Override
    public void setStartCoordinates(int x, int y) {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void setEndCoordinates(int x, int y) {
        this.endX = x;
        this.endY = y;
    }
}
