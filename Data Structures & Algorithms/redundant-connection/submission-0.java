class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= edges.length; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
            boolean[] visited = new boolean[edges.length + 1];

            if (isCycle(u, -1, adjList, visited)) {
                return edge;
            }
        }
        return new int[0];
    }

    private boolean isCycle(int node, int parent, List<List<Integer>> adjList, boolean[] visited) {
        if (visited[node]) {
            return true;
        }

        visited[node] = true;

        for (int neighbor : adjList.get(node)) {
            if (neighbor == parent) {
                continue;
            }
            if (isCycle(neighbor, node, adjList, visited)) {
                return true;
            }
        }
        return false;
    }
}
