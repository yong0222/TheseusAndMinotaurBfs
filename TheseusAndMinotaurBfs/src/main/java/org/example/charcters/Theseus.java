package org.example.charcters;

import org.example.Coord;
import org.example.Direction;

public class Theseus extends Character {
    public Theseus(Coord coord, String name) {
        super(coord, name);
    }

    @Override
    public Theseus move(Direction direction) {
        return new Theseus(
                new Coord(getCoord().getX() + direction.getDx(), getCoord().getY() + direction.getDy()),
                getName()
        );
    }
}
