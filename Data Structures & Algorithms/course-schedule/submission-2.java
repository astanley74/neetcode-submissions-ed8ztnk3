class Solution {
    private Map<Integer, List<Integer>> preReqs = new HashMap<>();
    private Set<Integer> visiting = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            preReqs.put(i, new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            preReqs.get(prereq[0]).add(prereq[1]);
        }

        for (int course = 0; course < numCourses; course++) {
            if (containsCycle(course)) {
                return false;
            }
        }
        return true;
    }

    private boolean containsCycle(int course) {
        if (this.visiting.contains(course)) {
            return true;
        }

        if (this.preReqs.get(course).isEmpty()) {
            return false;
        }

        this.visiting.add(course);

        for (int prereq : this.preReqs.get(course)) {
            if (containsCycle(prereq)) {
                return true;
            }
        }
        this.visiting.remove(course);
        this.preReqs.put(course, new ArrayList<>());
        return false;
    }
}
