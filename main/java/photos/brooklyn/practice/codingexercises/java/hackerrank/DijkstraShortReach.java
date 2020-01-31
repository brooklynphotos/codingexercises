package photos.brooklyn.practice.codingexercises.java.hackerrank;

import java.io.*;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/dijkstrashortreach/problem
 */
public class DijkstraShortReach {

    // Complete the shortestReach function below.
    static int[] shortestReach(int n, int[][] edges, int s) {
        final Map<Integer, Map<Integer, Integer>> graph = makeGraph(edges);
        final Map<Integer, Integer> res = new HashMap<>();
        res.put(s, 0);
        final Map<Integer, Integer> markedNodes = new HashMap<>();
        final PriorityQueue<NeighborDistance> prioritizedMarkedNodes = new PriorityQueue<>(n, Comparator.comparingInt(NeighborDistance::getWeight));
        int currentNode = s;
        while(true) {
            final Map<Integer, Integer> neighbors = graph.get(currentNode);
            for (final int neighbor : neighbors.keySet()) {
                if (res.containsKey(neighbor)) continue;
                final int newDistance = res.get(currentNode) + neighbors.get(neighbor);
                final int currentNeighborDistance = markedNodes.getOrDefault(neighbor, Integer.MAX_VALUE);
                if (newDistance < currentNeighborDistance) {
                    markedNodes.put(neighbor, newDistance);
                    prioritizedMarkedNodes.remove(new NeighborDistance(neighbor, currentNeighborDistance));
                    prioritizedMarkedNodes.offer(new NeighborDistance(neighbor, markedNodes.get(neighbor)));
                }
            }
            final NeighborDistance nabeDist = prioritizedMarkedNodes.poll();
//            final Map.Entry<Integer, Integer> entry = getEntryOfSmallestDistance(markedNodes);
            if (nabeDist == null) break; // no more to explore
            res.put(nabeDist.neighbor, nabeDist.weight);
            markedNodes.remove(nabeDist.neighbor);
            currentNode = nabeDist.neighbor;
        }
        final int[] output = new int[n - 1];
        int o = 0;
        for (int i = 1; i <= n; i++) {
            if(i==s) continue;
            output[o++] = res.getOrDefault(i, -1);
        }
        return output;
    }

    private static class NeighborDistance implements Comparable<NeighborDistance>{
        private int neighbor;
        private int weight;

        public NeighborDistance(final int neighbor, final int weight) {
            this.neighbor = neighbor;
            this.weight = weight;
        }

        int getWeight(){
            return weight;
        }

        @Override
        public int compareTo(final NeighborDistance o) {
            return Integer.compare(weight, o.weight);
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final NeighborDistance that = (NeighborDistance) o;
            return neighbor == that.neighbor &&
                    weight == that.weight;
        }

        @Override
        public int hashCode() {
            return Objects.hash(neighbor, weight);
        }
    }

    private static Map.Entry<Integer, Integer> getEntryOfSmallestDistance(final Map<Integer, Integer> markedNeighbors) {
        Map.Entry<Integer, Integer> smallest = null;
        for (final Map.Entry<Integer, Integer> e : markedNeighbors.entrySet()) {
            if (smallest == null || e.getValue() < smallest.getValue()) {
                smallest = e;
            }
        }
        return smallest;
    }

    private static Map<Integer, Map<Integer, Integer>> makeGraph(final int[][] edges) {
        final Map<Integer, Map<Integer, Integer>> m = new HashMap<>();
        for (final int[] edge : edges) {
            putInMap(m, edge[0], edge[1], edge[2]);
            putInMap(m, edge[1], edge[0], edge[2]);
        }
        return m;
    }

    private static void putInMap(final Map<Integer, Map<Integer, Integer>> m, final int a, final int b, final int w) {
        final Map<Integer, Integer> edgeRel = m.getOrDefault(a, new HashMap<>());
        edgeRel.compute(b, (k, v)->Math.min(v==null ? Integer.MAX_VALUE : v, w));
        m.put(a, edgeRel);
    }

    private static final Scanner scanner = new Scanner(new BufferedInputStream(System.in, 65536));

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int[][] edges = new int[m][3];

            for (int i = 0; i < m; i++) {
                String[] edgesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 3; j++) {
                    int edgesItem = Integer.parseInt(edgesRowItems[j]);
                    edges[i][j] = edgesItem;
                }
            }

            int s = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = shortestReach(n, edges, s);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
