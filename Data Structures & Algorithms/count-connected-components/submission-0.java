class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        int total = 0;

        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                dfs(adjacencyList, visited, node);
                total++;
            }
        }
        return total;
    }

    private void dfs(List<List<Integer>> adjacencyList, boolean[] visited, int node) {
        visited[node] = true;

        for (int neighbor : adjacencyList.get(node)) {
            if (!visited[neighbor]) {
                dfs(adjacencyList, visited, neighbor);
            }
        }
    }
}
