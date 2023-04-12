package medium;

import java.util.HashSet;
import java.util.Set;

public class Q1319NumOfOperationToMakeNetwork {
    public static int makeConnected(int n, int[][] connections) {
        if (n > connections.length +1){
            return -1;
        }
        Set<Integer> reachedNode = new HashSet<>();
        int redundantConnections = 0;

        for(int i=0; i<connections.length; i++){
            boolean bothExist = reachedNode.add(connections[i][0]);
            bothExist = reachedNode.add(connections[i][1]) && bothExist;
            if (bothExist){
                redundantConnections++;
            }
        }
        int missingConnections = 0;
        for (int i=0; i<n; i++){
            if (!reachedNode.contains(n)) missingConnections++;
        }

        return Math.min(redundantConnections, missingConnections);

    }
}
