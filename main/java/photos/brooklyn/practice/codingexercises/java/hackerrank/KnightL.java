package photos.brooklyn.practice.codingexercises.java.hackerrank;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/knightl-on-chessboard/problem
 */
public class KnightL {
    public static List<List<Integer>> knightlOnAChessboard(int n) {
        final List<List<Integer>> res = new ArrayList<>(n);
        final Integer[][] memo = new Integer[n][n];
        for (int r = 1; r < n; r++) {
            final List<Integer> rowRes = new ArrayList<>(n);
            for (int c = 1; c < n; c++) {
                int m;
                if(memo[r][c] != null){
                    m = memo[r][c];
                }else{
                    m = knightlOnAChessboard(r, c, n);
                    memo[r][c] = m;
                    memo[c][r] = m;
                }
                rowRes.add(m);
            }
            res.add(rowRes);
        }
        return res;
    }

    private static int knightlOnAChessboard(final int a, final int b, final int boardSize) {
        System.out.println("Getting res for " + a + "," + b);
        Queue<Coordinate> q = new LinkedList<>();
        Set<Coordinate> visited = new HashSet<>();
        q.add(new Coordinate(0, 0));
        final Coordinate endCoord = new Coordinate(boardSize - 1, boardSize - 1);
        while (!q.isEmpty()) {
            final Coordinate top = q.poll();
            if (visited.contains(top)) {
                continue;
            }
            if (top.equals(endCoord)) return top.level;
            visited.add(top);
            // symmetric
            final Coordinate mirror = new Coordinate(top.col, top.row);
            mirror.level = top.level;
            visited.add(mirror);
            q.addAll(getNextMoves(top, a, b, boardSize, visited));
        }
        return -1;
    }

    private static Collection<Coordinate> getNextMoves(final Coordinate origin, final int a, final int b, final int boardSize, final Set<Coordinate> visited) {
        Set<Coordinate> nextMoves = new HashSet<>(Arrays.asList(
                new Coordinate(origin.row - a, origin.col + b),
                new Coordinate(origin.row - a, origin.col - b),
                new Coordinate(origin.row + a, origin.col + b),
                new Coordinate(origin.row + a, origin.col - b),
                new Coordinate(origin.row - b, origin.col + a),
                new Coordinate(origin.row - b, origin.col - a),
                new Coordinate(origin.row + b, origin.col + a),
                new Coordinate(origin.row + b, origin.col - a)
        ));
        final List<Coordinate> res = new ArrayList<>(nextMoves.size());
        for (Coordinate possible : nextMoves) {
            if (possible.row < 0 || possible.col < 0 || possible.row >= boardSize || possible.col >= boardSize || visited.contains(possible)) {
                continue;
            }
            possible.level = origin.level + 1;
            res.add(possible);
        }
        return res;
    }

    private static class Coordinate {
        int row;
        int level;

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final Coordinate that = (Coordinate) o;
            return row == that.row &&
                    col == that.col;
        }

        @Override
        public String toString() {
            return "(" + row + "," + col + "): " + level;
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

        public int getValue(final int[][] board) {
            return board[row][col];
        }
    }
}
