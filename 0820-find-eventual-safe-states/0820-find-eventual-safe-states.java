class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // Using BFS
        int n = graph.length;
        int[] indegree = new int[n];
        List<List<Integer>> adjRev = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjRev.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int it : graph[i]) {
                adjRev.get(it).add(i); // reverse the direction of node
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> safenode = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            safenode.add(node);
            for (int it : adjRev.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    q.add(it);
            }
        }
        Collections.sort(safenode);
        return safenode;
    }
}