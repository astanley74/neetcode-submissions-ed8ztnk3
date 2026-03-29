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
            if (!isNoCycle(course)) {
                return false;
            }
        }
        return true;
    }

    private boolean isNoCycle(int course) {
        if (this.visiting.contains(course)) {
            return false;
        }

        if (this.preReqs.get(course).isEmpty()) {
            return true;
        }

        this.visiting.add(course);

        for (int prereq : this.preReqs.get(course)) {
            if (!isNoCycle(prereq)) {
                return false;
            }
        }
        this.visiting.remove(course);
        this.preReqs.put(course, new ArrayList<>());
        return true;
    }
}
