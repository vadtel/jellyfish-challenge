package org.vadtel.jellyfishchallenge.model;

public class Jellyfish {
    private Tank tank;
    private Cell cell;
    private Orientation orientation;
    private boolean lost;

    public Jellyfish(Tank tank, Cell cell, Orientation orientation) {
        this.tank = tank;
        this.cell = cell;
        this.orientation = orientation;

    }
    public void doInstruction(String s) {
        if (!isLost()) {
            Instruction.valueOf(s).action(this);
        }
    }

    public boolean isLost() {
        return lost;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }

    public Tank getTank() {
        return tank;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return "" + cell.getX() + cell.getY() + orientation.toString() + (lost ? "LOST" : "");
    }


}
