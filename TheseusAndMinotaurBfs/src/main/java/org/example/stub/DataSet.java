package org.example.stub;

import org.example.Coord;
import org.example.Labyrinth;
import org.example.charcters.Minotaur;
import org.example.charcters.Theseus;

public class DataSet {

    private Labyrinth labyrinth;

    private Theseus theseus;

    private Minotaur minotaur;

    private Coord escapeCoord;

    public DataSet(Labyrinth labyrinth, Theseus theseus, Minotaur minotaur, Coord escapeCoord) {
        this.labyrinth = labyrinth;
        this.theseus = theseus;
        this.minotaur = minotaur;
        this.escapeCoord = escapeCoord;
    }

    public Labyrinth getLabyrinth() {
        return labyrinth;
    }

    public Theseus getTheseus() {
        return theseus;
    }

    public Minotaur getMinotaur() {
        return minotaur;
    }

    public Coord getEscapeCoord() {
        return escapeCoord;
    }
}
