package photos.brooklyn.practice.codingexercises.java.codility;

public class PlaneSeats {

    /**
     *
     * @param N row count ranging from 1 to 50
     * @param S |S| 0 to 1_909
     * @return
     */
    public int solution(int N, String S) {
        final int[][] occupancy = createOccupancy(N, S);
        int count = 0;
        for (int r = 0; r < N; r++) {
            count += countRow(occupancy[r]);
        }
        return count;
    }

    static int[][] createOccupancy(final int N, final String S) {
        int[][] occupancy = new int[N][10];
        if(S.equals("")) return occupancy;
        for (String occupied : S.split("\\s+")) {
            int row = Integer.parseInt(occupied.substring(0, occupied.length() - 1)) - 1;
            char colChar = occupied.charAt(occupied.length() - 1);
            int col = colChar - 'A';
            if (colChar > 'I') {
                col--;
            }
            occupancy[row][col] = 1;
        }
        return occupancy;
    }

    static int countRow(int[] occupancyRow) {
        return Math.max(countRowCenter(occupancyRow), countRowAisles(occupancyRow));
    }

    private static int countRowAisles(final int[] r) {
        int count = 0;
        if(r[1] + r[2] + r[3] + r[4] == 0) count++;
        if(r[5] + r[6] + r[7] + r[8] == 0) count++;
        return count;
    }

    static int countRowCenter(final int[] r) {
        if (r[3] + r[4] + r[5] + r[6] == 0) {
            return 1;
        }
        return 0;
    }
}
