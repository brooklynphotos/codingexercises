package photos.brooklyn.practice.codingexercises.java.codility;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BiggestNumberInGrid {

    /**
     *
     * @param Board |Board| and ||Board|| are between 1 and 100, b is between 0 and 9
     * @return a four digit number that doesn't start with 0
     */
    public int solution(int[][] Board) {
        int res = 0;
        for (int r = 0; r < Board.length; r++) {
            int solutionForRow = findSolutionForRow(r, Board);
            res = Math.max(res, solutionForRow);
        }
        return res;
    }

    private static int makeNumber(final int[][] board, final List<Coordinate> coordinates) {
        StringBuilder numberString = new StringBuilder();
        for (int i = 0; i < coordinates.size(); i++) {
            final Coordinate c = coordinates.get(i);
            numberString.append(board[c.row][c.col]);
        }
        return Integer.parseInt(numberString.toString());
    }

    private static int findSolutionForRow(final int row, final int[][] board) {
        Coordinate maxC = null;
        final int[] rowData = board[row];

        for (int col = 0; col < rowData.length; col++) {
            final int digit = board[row][col];
            if (digit > 0 && (maxC == null || digit > rowData[col])) {
                maxC = new Coordinate(row, col);
            }
        }
        if (maxC == null) {
            return 0;
        }
        List<Coordinate> coordinates = new ArrayList<>(4);
        coordinates.add(maxC);
        return findSolutionForCoordinate(coordinates, board);
    }

    private static int findSolutionForCoordinate(final List<Coordinate> coordinates, final int[][] board) {
        if (coordinates.size() == 4) {
            return makeNumber(board, coordinates);
        }
        final Coordinate lastCoordinate = coordinates.get(coordinates.size() - 1);
        final List<Coordinate> maxCoordinates = getSurroundingCoordinates(lastCoordinate, coordinates, board);
        if (maxCoordinates.size() == 0) {
            return 0;
        }
        int max = 0;
        for (Coordinate maxCoord : maxCoordinates) {
            coordinates.add(maxCoord);
            max = Math.max(max, findSolutionForCoordinate(coordinates, board));
            coordinates.remove(maxCoord);
        }
        return max;
    }

    private static List<Coordinate> getSurroundingCoordinates(final Coordinate lastCoordinate, final List<Coordinate> coordinates, final int[][] board) {
        final Stream<Coordinate> possibilities = Stream.of(
                new Coordinate(lastCoordinate.row - 1, lastCoordinate.col),
                new Coordinate(lastCoordinate.row - 1, lastCoordinate.col),
                new Coordinate(lastCoordinate.row - 1, lastCoordinate.col),
                new Coordinate(lastCoordinate.row - 1, lastCoordinate.col)
        );
        return possibilities.filter(coordinate -> coordinate.col >= 0 && coordinate.col < board[0].length && coordinate.row >= 0 && coordinate.row < board.length).collect(Collectors.toList());
    }


    static class Coordinate{
        int row;

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final Coordinate that = (Coordinate) o;
            return row == that.row &&
                    col == that.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }

        int col;

        Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
