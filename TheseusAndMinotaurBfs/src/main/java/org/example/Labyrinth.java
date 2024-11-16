package org.example;

import java.util.HashMap;
import java.util.Map;

public class Labyrinth {

    private Map<Coord, Tile> tiles = new HashMap<>();

    public Labyrinth(Labyrinth labyrinth) {
        this.tiles = labyrinth.tiles;
    }

    public Labyrinth(Path[][] path2D) {
        for (int h = 0; h < path2D.length; h++) {
            for (int w = 0; w < path2D[h].length; w++) {
                Coord tileCoord = new Coord(w, h);
                tiles.put(tileCoord, new Tile(tileCoord, path2D[h][w]));
            }
        }
    }

    public Path getPath(Coord coord) {
        return this.tiles.get(coord).getPath();
    }

    public boolean canMove(Coord coord, int dx, int dy) {
        Tile tile = tiles.get(coord);
        Direction direction = new Direction(dx, dy);

        return tile.getPath().getPaths().contains(direction);
    }

    class Tile {

        private Coord coord;

        private Path path;

        public Tile(Coord coord, Path path) {
            this.coord = coord;
            this.path = path;
        }

        public Coord getCoord() {
            return coord;
        }

        public Path getPath() {
            return path;
        }
    }

}
