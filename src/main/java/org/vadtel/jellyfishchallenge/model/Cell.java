package org.vadtel.jellyfishchallenge.model;

import java.util.HashSet;
import java.util.Set;

public class Cell {
    private final int x;
    private final int y;
    private Scent scent;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void addScent(Orientation orientation) {
        if (scent == null) {
            scent = new Scent();
        }
        scent.addScentOrientation(orientation);
    }

    public boolean isScent(Orientation orientation) {
        if (scent == null) {
            return false;
        }
        return scent.check(orientation);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "org.vadtel.jellyfishchallenge.model.Cell{" +
                "x=" + x +
                ", y=" + y +
                ", scent=" + scent +
                '}';
    }

    private class Scent {
        private Set<Orientation> orientations = new HashSet<>();

        public boolean check(Orientation orientation) {
            if (orientations.isEmpty()) {
                return false;
            }
            for (Orientation o : orientations) {
                if (o.equals(orientation)) {
                    return true;
                }
            }
            return false;
        }

        public void addScentOrientation(Orientation orientation) {
            orientations.add(orientation);
        }

        @Override
        public String toString() {
            return "Scent{" +
                    "orientations=" + orientations +
                    '}';
        }
    }


}