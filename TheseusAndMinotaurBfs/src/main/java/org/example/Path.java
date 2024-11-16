package org.example;

import java.util.HashSet;
import java.util.Set;

public class Path {

    private Set<Direction> paths = new HashSet<>(Set.of(new Direction("S", 0, 0)));

    private final Direction R_DIR = new Direction("R", 1, 0);

    private final Direction U_DIR = new Direction("U", 0, -1);

    private final Direction L_DIR = new Direction("L", -1, 0);

    private final Direction D_DIR = new Direction("D", 0, 1);

    public Path(Set<Direction> paths) {
        this.paths = paths;
    }

    public Path(String... dirs) {
        for (String d : dirs) {
            switch (d) {
                case "R":
                    paths.add(R_DIR);
                    break;
                case "U":
                    paths.add(U_DIR);
                    break;
                case "L":
                    paths.add(L_DIR);
                    break;
                case "D":
                    paths.add(D_DIR);
                    break;
            }
        }
    }

    public Path(boolean hasEastPath, boolean hasSouthPath, boolean hasWestPath, boolean hasNorthPath) {
        if (hasEastPath) {
            paths.add(R_DIR);
        }

        if (hasSouthPath) {
            paths.add(U_DIR);
        }

        if (hasWestPath) {
            paths.add(L_DIR);
        }

        if (hasNorthPath) {
            paths.add(D_DIR);
        }
    }

    public Set<Direction> getPaths() {
        return paths;
    }

    public static Path[][] stringToPath(String[][][] strPath) {
        Path[][] path = new Path[strPath.length][strPath[0].length];

        for (int h = 0; h < strPath.length; h++) {
            for (int w = 0; w < strPath[h].length; w++) {
                path[h][w] = new Path(strPath[h][w]);
            }
        }

        return path;
    }

}
