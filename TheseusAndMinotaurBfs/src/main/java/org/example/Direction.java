package org.example;

import java.util.Objects;

public class Direction {

    private String name;

    private int dx;

    private int dy;

    public Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Direction(String name, int dx, int dy) {
        this.name = name;
        this.dx = dx;
        this.dy = dy;
    }

    public String getName() {
        return name;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return dx == direction.dx && dy == direction.dy;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dx, dy);
    }
}
