package org.example.charcters;

import org.example.Coord;
import org.example.Direction;

public class Minotaur extends Character {

    public Minotaur(Coord coord, String name) {
        super(coord, name);
    }

    public Minotaur(Minotaur minotaur) {
        super(
                new Coord(minotaur.getCoord().getX(), minotaur.getCoord().getY()),
                minotaur.getName()
        );
    }

    @Override
    public Minotaur move(Direction direction) {
        return new Minotaur(
                new Coord(getCoord().getX() + direction.getDx(), getCoord().getY() + direction.getDy()),
                getName()
        );
    }

}
