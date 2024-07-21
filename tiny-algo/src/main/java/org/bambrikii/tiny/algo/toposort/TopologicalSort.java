package org.bambrikii.tiny.algo.toposort;

import java.util.*;

public class TopologicalSort<T> {
    private final Map<T, Set<T>> graph;

    public TopologicalSort() {
        graph = new HashMap<>();
    }

    public TopologicalSort dep(T from, T to) {
        graph.compute(from, (k, v) -> {
            if (v == null) {
                v = new HashSet<T>();
            }
            v.add(to);
            return v;
        });
        return this;
    }

    public List<T> sort() {
        var indegree = new HashMap<T, Integer>();
        for (var entry : graph.entrySet()) {
            var vals = entry.getValue();
            for (var val : vals) {
                indegree.compute(val, (k, v) -> v == null ? 1 : v + 1);
            }
        }
        var result = new ArrayList<T>();
        var queue = new LinkedList<T>();
        for (var entry : graph.entrySet()) {
            var key = entry.getKey();
            if (!indegree.containsKey(key)) {
                queue.add(key);
                result.add(key);
            }
        }
        while (!queue.isEmpty()) {
            var key = queue.poll();
            var children = graph.get(key);
            if (children != null && !children.isEmpty()) {
                for (var child : children) {
                    indegree.compute(child, (k, v) -> v == null ? 0 : v - 1);
                    if (indegree.get(child) == 0) {
                        result.add(child);
                        queue.offer(child);
                    }
                }
            }
        }
        return result;
    }
}
