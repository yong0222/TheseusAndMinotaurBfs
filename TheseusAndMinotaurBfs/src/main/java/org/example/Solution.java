package org.example;

import org.example.charcters.Minotaur;
import org.example.charcters.Theseus;

import java.util.*;

public class Solution {

    Labyrinth labyrinth;

    Coord escapeCoord;

    Theseus startingTheseus;

    Minotaur startingMinotaur;

    public Solution(Labyrinth labyrinth, Coord escapeCoord, Theseus startingTheseus, Minotaur startingMinotaur) {
        this.labyrinth = labyrinth;
        this.escapeCoord = escapeCoord;
        this.startingTheseus = startingTheseus;
        this.startingMinotaur = startingMinotaur;
    }

    public String bfsSolution() {
        return bfs(new State(startingTheseus, startingMinotaur));
    }

    public List<State> nextTheseusPosition(State startingState) {
        List<State> statesList = new ArrayList<>();

        Theseus theseus = startingState.getTheseus();
        Path paths = labyrinth.getPath(theseus.getCoord());

        for (Direction dir : paths.getPaths()) {
            Theseus movedTheseus = theseus.move(dir);
            Minotaur minotaur = new Minotaur(startingState.getMinotaur());

            State newState = new State(movedTheseus, minotaur, startingState.theseusMoveLog + dir.getName());
            statesList.add(newState);
        }

        return statesList;
    }

    public int moveTowards(int m, int t) {
        return Integer.compare(t, m);
    }

    public void nextMinotaurPosition(State startingState) {
        Coord theseusCoord = startingState.getTheseus().getCoord();
        Coord minotaurCoord = startingState.getMinotaur().getCoord();

        for (int i = 0; i < 2; i++) {
            // horizontal movement
            int dx = moveTowards(minotaurCoord.getX(), theseusCoord.getX());
            if (dx != 0 && labyrinth.canMove(minotaurCoord, dx, 0)) {
                minotaurCoord.setX(minotaurCoord.getX() + dx);
                continue;
            }

            // vertical movement
            int dy = moveTowards(minotaurCoord.getY(), theseusCoord.getY());
            if (dy != 0 && labyrinth.canMove(minotaurCoord, 0, dy)) {
                minotaurCoord.setY(minotaurCoord.getY() + dy);
                continue;
            }
        }
    }

    public String bfs(State startingState) {
        Queue<State> queue = new LinkedList<>(List.of(startingState));
        Set<State> discovered = new HashSet<>();

        while(!queue.isEmpty()) {
            State current = queue.poll();

//            System.out.println(current.theseusMoveLog);
            if (current.theseusMoveLog.startsWith("URRRRRDDDDLDDRSLULLLULLUDRDDDLSRRUURRRDRRUUDSDULUUUUURSSLDLLLLLLU")) {
                System.out.println();
            }
            for (State nextState : nextTheseusPosition(current)) {
                if (checkEscape(nextState)) {
                    return nextState.getTheseusMoveLog();
                }
// 5 4   2 2
                nextMinotaurPosition(nextState);
                if (!nextState.isTheseusCaptured() && discovered.add(nextState)) {
                    queue.add(nextState);
                }
            }
        }

        return "No solution!";
    }

    public boolean checkEscape(State state) {
        return state.getTheseus().getCoord().equals(escapeCoord);
    }

    private class State {

        private Theseus theseus;

        private Minotaur minotaur;

        private String theseusMoveLog = "";

        public State(Theseus theseus, Minotaur minotaur) {
            this.theseus = theseus;
            this.minotaur = minotaur;
        }

        public State(Theseus theseus, Minotaur minotaur, String theseusMoveLog) {
            this.theseus = theseus;
            this.minotaur = minotaur;
            this.theseusMoveLog = theseusMoveLog;
        }

        public Theseus getTheseus() {
            return theseus;
        }

        public Minotaur getMinotaur() {
            return minotaur;
        }

        public String getTheseusMoveLog() {
            return theseusMoveLog;
        }

        public boolean isTheseusCaptured() {
            return theseus.getCoord().equals(minotaur.getCoord());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return Objects.equals(theseus, state.theseus) && Objects.equals(minotaur, state.minotaur);
        }

        @Override
        public int hashCode() {
            return Objects.hash(theseus, minotaur);
        }
    }

}
