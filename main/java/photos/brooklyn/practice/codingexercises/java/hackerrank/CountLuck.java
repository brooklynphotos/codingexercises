package photos.brooklyn.practice.codingexercises.java.hackerrank;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/count-luck/problem
 */
public class CountLuck {

    private static class SpecialCoordinates {
        private Coordinate start;

        public SpecialCoordinates(final Coordinate start, final Coordinate end) {
            if (start == null || end == null) {
                throw new IllegalArgumentException("Start and end cannot be null");
            }
            this.start = start;
            this.end = end;
        }

        private Coordinate end;
    }

    private static class Coordinate {
        private int parentWaveCount;

        public Coordinate(final int row, final int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final Coordinate that = (Coordinate) o;
            return row == that.row && column == that.column;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }

        @Override
        public String toString() {
            return "(" + row + "," + column + ", " + parentWaveCount + ')';
        }

        private int row;
        private int column;
    }

    public static String countLuck(List<String> matrix, int k) {
        if (countLuck(getStarting(matrix), matrix) == k) {
            return "Impressed";
        } else {
            return "Oops!";
        }
    }

    private static int countLuck(final SpecialCoordinates startEnd, final List<String> matrix) {
        Queue<Coordinate> steps = new LinkedList<>();
        Set<Coordinate> visited = new HashSet<>();
        steps.add(startEnd.start);
        while (!steps.isEmpty()) {
            final Coordinate top = steps.poll();
            visited.add(top);
            final Set<Coordinate> neighbors = findNewNeighbors(top, matrix, visited);
            if(neighbors.contains(startEnd.end))
                return neighbors.iterator().next().parentWaveCount;
            steps.addAll(neighbors);
        }
        throw new IllegalStateException("Weird, there should always be a path");
    }

    private static Set<Coordinate> findNewNeighbors(final Coordinate coordinate, final List<String> matrix, final Set<Coordinate> visited) {
        Set<Coordinate> neighbors = new HashSet<>();
        if (coordinate.row < matrix.size() - 1) {
            final Coordinate newCoord = new Coordinate(coordinate.row + 1, coordinate.column);
            if (getValue(newCoord, matrix) != 'X' && !visited.contains(newCoord)) {
                neighbors.add(newCoord);
            }
        }
        if (coordinate.row > 0) {
            final Coordinate newCoord = new Coordinate(coordinate.row - 1, coordinate.column);
            if (getValue(newCoord, matrix) != 'X' && !visited.contains(newCoord)) {
                neighbors.add(newCoord);
            }
        }
        final String sample = matrix.get(0);
        if (coordinate.column < sample.length() - 1) {
            final Coordinate newCoord = new Coordinate(coordinate.row, coordinate.column + 1);
            if (getValue(newCoord, matrix) != 'X' && !visited.contains(newCoord)) {
                neighbors.add(newCoord);
            }
        }
        if (coordinate.column > 0) {
            final Coordinate newCoord = new Coordinate(coordinate.row, coordinate.column - 1);
            if (getValue(newCoord, matrix) != 'X' && !visited.contains(newCoord)) {
                neighbors.add(newCoord);
            }
        }
        if (neighbors.size() > 1) {
            neighbors.forEach(n->n.parentWaveCount = coordinate.parentWaveCount + 1);
        }else {
            neighbors.forEach(n->n.parentWaveCount = coordinate.parentWaveCount);
        }
        return neighbors;
    }

    private static char getValue(final Coordinate coord, final List<String> matrix) {
        return matrix.get(coord.row).charAt(coord.column);
    }

    private static SpecialCoordinates getStarting(final List<String> matrix) {
        Coordinate start = null;
        Coordinate end = null;
        for (int r = 0; r < matrix.size(); r++) {
            int s = matrix.get(r).indexOf('M');
            if (s > -1) {
                start = new Coordinate(r, s);
            }
            int e = matrix.get(r).indexOf('*');
            if (e > -1) {
                end = new Coordinate(r, e);
            }
        }
        return new SpecialCoordinates(start, end);
    }

}
