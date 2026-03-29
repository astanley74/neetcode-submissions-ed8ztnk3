class Solution {
    private Map<Integer, List<Integer>> map = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i ++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            map.get(pre[0]).add(pre[1]);
        }

        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course) {
        if (this.visited.contains(course)) {
            return false;
        }
        if (map.get(course).isEmpty()) {
            return true;
        }
        this.visited.add(course);
        for (int pre : map.get(course)) {
            if (!dfs(pre)) {
                return false;
            }
        }
        this.visited.remove(course);
        map.put(course, new ArrayList<>());
        return true;
    }
}
