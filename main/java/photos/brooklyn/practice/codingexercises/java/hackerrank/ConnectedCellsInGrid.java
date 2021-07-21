package photos.brooklyn.practice.codingexercises.java.hackerrank;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/connected-cell-in-a-grid/problem
 */
public class ConnectedCellsInGrid {
    private static class Coordinate {
        private int row;

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
            return "(" + row + "," + column + ')';
        }

        private int column;
    }

    public static int connectedCell(List<List<Integer>> matrix) {
        final Set<Coordinate> visited = new HashSet<>();
        int maxCount = 0;
        for (int r = 0; r < matrix.size(); r++) {
            final List<Integer> row = matrix.get(r);
            for (int c = 0; c < row.size(); c++) {
                final int val = row.get(c);
                final Coordinate coord = new Coordinate(r, c);
                if (val == 0 || visited.contains(coord)) {
                    continue;
                }
                maxCount = Math.max(maxCount, findRegionCount(matrix, coord, visited));
            }
        }
        return maxCount;
    }

    /**
     * counts the size of the region using BFS
     *
     * @param matrix
     * @param coord
     * @param visited
     * @return
     */
    private static int findRegionCount(final List<List<Integer>> matrix, final Coordinate coord, final Set<Coordinate> visited) {
        final Queue<Coordinate> q = new LinkedList<>();
        q.add(coord);
        int count = 0;
        while (!q.isEmpty()) {
            final Coordinate top = q.poll();
            if (visited.contains(top)) {
                continue;
            }
            count++;
            visited.add(top);
            final Collection<Coordinate> newNeighbors = getNewNeighbors(top, visited, matrix);
            q.addAll(newNeighbors);
        }
        return count;
    }

    private static Collection<Coordinate> getNewNeighbors(final Coordinate coordinate, final Set<Coordinate> visited, final List<List<Integer>> matrix) {
        final List<Coordinate> newNeighbors = new ArrayList<>(8);
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                final Coordinate neighbor = new Coordinate(coordinate.row + i, coordinate.column + j);
                if (neighbor.row < 0 || neighbor.row >= matrix.size() || neighbor.column < 0 || neighbor.column >= matrix.get(0).size() ||
                        matrix.get(neighbor.row).get(neighbor.column) != 1 ||
                        visited.contains(neighbor)
                ) {
                    continue;
                }
                newNeighbors.add(neighbor);
            }
        }
        return newNeighbors;
    }
}
