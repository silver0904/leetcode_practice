package medium;

import java.util.*;

public class Q207CourseSchedule {

    /**
     * BFS approach
     * @return
     */
    public static boolean canFinish2(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] prerequisiteCountOfCourse = new int[numCourses];

        for (int i=0; i< numCourses; i++){
            map.put(i, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites){
            List list = map.get(prerequisite[1]);
            list.add(prerequisite[0]);
            map.put(prerequisite[1], list);
            prerequisiteCountOfCourse[prerequisite[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i=0; i< prerequisiteCountOfCourse.length; i++){
            if (prerequisiteCountOfCourse[i] == 0){
                queue.offer(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()){
            int course = queue.poll();
            List<Integer> prerequisite = map.get(course);
            prerequisite.stream().forEach(i ->{
                int index = i;
                if (--prerequisiteCountOfCourse[index] == 0){
                    queue.offer(prerequisiteCountOfCourse[index]);
                }
            });
            count++;

        }
        return count == numCourses;
    }


    /**
     * DFS approach
     * Time: O(n+p), p = number of prerequisite
     * Space: O(n)
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> visitSet = new HashSet<>();

        for(int i = 0; i < numCourses; i++)
            map.put(i, new HashSet<>());

        for(int[] edge : prerequisites)
            map.get(edge[0]).add(edge[1]);

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i, map, visitSet)) return false;
        }

        return true;
    }

    private boolean dfs(int curr, Map<Integer, Set<Integer>> dep, Set<Integer> visitSet) {
        if(visitSet.contains(curr)) return false;
        if(dep.get(curr).isEmpty()) return true;

        visitSet.add(curr);
        for(int pre : dep.get(curr)) {
            if(!dfs(pre, dep, visitSet))
                return false;
        }

        visitSet.remove(curr);
        dep.get(curr).clear();

        return true;
    }
}
