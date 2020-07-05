package org.vadtel.jellyfishchallenge.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Tank {

    private static final int MAX_COORD = 50;
    private final int xMax;
    private final int yMax;
    private List<Jellyfish> jellyfishes = new ArrayList<>();
    private Cell[][] cells;


    public Tank(int xMax, int yMax) {
        this.xMax = xMax <= MAX_COORD ? xMax : 50;
        this.yMax = yMax <= MAX_COORD ? yMax : 50;

        Cell[][] cells = IntStream.rangeClosed(0, yMax)
                .mapToObj(y -> IntStream.rangeClosed(0, xMax)
                        .mapToObj(x -> new Cell(x, y))
                        .toArray(Cell[]::new))
                .toArray(Cell[][]::new);

        this.cells = cells;
    }

    public Jellyfish addJellyfish(int x, int y, Orientation orientation) {
        Jellyfish jellyfish = new Jellyfish(this, getCell(x, y), orientation);
        jellyfishes.add(jellyfish);
        return jellyfish;
    }

    public List<Jellyfish> getJellyFishes(){
        return jellyfishes;
    }

    public int getxMax() {
        return xMax;
    }

    public int getyMax() {
        return yMax;
    }

    public Cell getCell(int x, int y) {
        return cells[y][x];
    }


}
