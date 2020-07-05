package org.vadtel.jellyfishchallenge.model;

public enum Orientation {

    N("N", "E", "W"),
    S("S", "W", "E"),
    E("E", "S", "N"),
    W("W", "N", "S");

    private final String value;
    private final String right;
    private final String left;

    Orientation(String value, String right, String left) {
        this.value = value;
        this.right = right;
        this.left = left;
    }

    public static Orientation parseOrientation(String s) {
        for (Orientation orientation : Orientation.values()) {
            if (s.equals(orientation.getValue())) {
                return orientation;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public String getRight() {
        return right;
    }

    public String getLeft() {
        return left;
    }
}
