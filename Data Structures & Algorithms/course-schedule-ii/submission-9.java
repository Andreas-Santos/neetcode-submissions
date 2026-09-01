class Solution {
    
    private List<Integer> courses;
    private Map<Integer, List<Integer>> prereqMap;
    private Set<Integer> visited;
    private Set<Integer> cycle;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        courses = new ArrayList<>();
        prereqMap = new HashMap<>();
        visited = new HashSet<>();
        cycle = new HashSet<>();

        for(int[] prereq : prerequisites) {
            if(!prereqMap.containsKey(prereq[0])) {
                prereqMap.put(prereq[0], new ArrayList<>());
            }

            prereqMap.get(prereq[0]).add(prereq[1]);
        }

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i)) {
                return new int[0];
            }
        }

        int[] result = new int[courses.size()];

        for(int i = 0; i < courses.size(); i++) {
            result[i] = courses.get(i);
        }

        return result;
    }

    public boolean dfs(int index) {
        if(cycle.contains(index)) {
            return false;
        }

        if(visited.contains(index)) {
            return true;
        }

        cycle.add(index);
        for(int prereq : prereqMap.getOrDefault(index, new ArrayList<>())) {
            if(!dfs(prereq)) {
                return false;
            }
        }
        
        visited.add(index);
        cycle.remove(index);
        courses.add(index);

        return true;
    }
}
