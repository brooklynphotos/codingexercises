package photos.brooklyn.practice.codingexercises.java.hackerrank;

import java.util.*;

public class GenaHanoi {
    private static class State {
        private int level;
        private int[] posts;
        private Integer idHash;

        public State(final int level, final int[] posts) {
            this.level = level;
            this.posts = posts;
            this.idHash = Arrays.hashCode(posts);
        }
    }
    public static int hanoi(List<Integer> posts) {
        final Queue<State> queue = new LinkedList<>();
        final Set<Integer> visited = new HashSet<>();
        queue.add(new State(0, toArray(posts)));
        final int[] targetState = new int[posts.size()];
        while (!queue.isEmpty()) {
            final State top = queue.poll();
            if(visited.contains(top.idHash)) continue;
            visited.add(top.idHash);
            if (Arrays.equals(top.posts, targetState)) {
                return top.level;
            }
            final Collection<State> newStates = findNewStates(top);
            queue.addAll(newStates);
        }
        throw new IllegalStateException("Weird, we couldn't find any way to get everything to the first post");
    }

    private static Collection<State> findNewStates(final State origin) {
        final List<State> newStates = new LinkedList<>();
        final int[] pollTops = findPollTops(origin);
        final Integer[] sortedPosts = sortPosts(pollTops);
        for (int i = 0; i < sortedPosts.length - 1; i++) {
            final int post = sortedPosts[i];
            final int size = pollTops[post];
            if (size == Integer.MAX_VALUE) {
                continue;
            }
            for (int j = i + 1; j < sortedPosts.length; j++) {
                int[] newState = createNewState(origin.posts, size - 1, sortedPosts[j]);
                newStates.add(new State(origin.level + 1, newState));
            }
        }
        return newStates;
    }

    private static Integer[] sortPosts(final int[] pollTops) {
        final Integer[] posts = new Integer[pollTops.length];
        for (int i = 0; i < pollTops.length; i++) {
            posts[i] = i;
        }
        Arrays.sort(posts, Comparator.comparingInt(a -> pollTops[a]));
        return posts;
    }

    private static int[] createNewState(final int[] currentPosts, final int disk, final int newPost) {
        final int[] newPosts = Arrays.copyOf(currentPosts, currentPosts.length);
        newPosts[disk] = newPost;
        return newPosts;
    }

    private static int[] findPollTops(final State state) {
        final int[] tops = new int[4];
        Arrays.fill(tops, Integer.MAX_VALUE);
        for (int i = 0; i < state.posts.length; i++) {
            final int post = state.posts[i];
            final int currentSize = tops[post];
            final int size = i + 1;
            if (currentSize > size) {
                tops[post] = size;
            }
        }
        return tops;
    }

    private static int[] toArray(List<Integer> posts) {
        return posts.stream().mapToInt(i -> i - 1).toArray();
    }
}
