package org.example.charcters;

import org.example.Coord;
import org.example.Direction;

import java.util.Objects;

public abstract class Character {

    private Coord coord;

    private String name;

    public Character(Coord coord, String name) {
        this.coord = coord;
        this.name = name;
    }

    public Coord getCoord() {
        return coord;
    }

    public String getName() {
        return name;
    }

    public abstract Character move(Direction direction);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return coord.equals(character.coord) && name.equals(character.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coord, name);
    }

}
