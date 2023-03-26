package medium;

import java.util.Arrays;

public class Q1921EliminateMaxNumOfMonster {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int elimated = 0;
        while(elimated < dist.length){
            int localMin = Integer.MAX_VALUE;
            int localMinPos = 0;
            int[] newDist = new int[dist.length];
            for (int i=0; i< dist.length; i++){
                // monster is dead
                if (dist[i] == Integer.MAX_VALUE){
                    newDist[i] = dist[i];
                    continue;
                }

                // monster has reached city
                if (dist[i] <= 0){
                    return elimated;
                }

                // find the monster which is closest to the city in next minute
                newDist[i] = dist[i] - speed[i];
                if (localMin > newDist[i]);
                localMin = newDist[i];
                localMinPos = i;
            }

            // kill monster
            newDist[localMinPos] = Integer.MAX_VALUE;
            dist = newDist;
            elimated++;
        }
        return elimated;
    }

    public int eliminateMaximum2(int[] dist, int[] speed) {
        int elimated = 0;
        int[] time = new int[dist.length];
        for (int i=0; i<dist.length; i++){
            time[i] = (int)Math.ceil((double)dist[i]/speed[i]);
        }
        Arrays.sort(time);
        for (int i=0; i< time.length; i++){
            if (time[i] <= elimated){
                return elimated;
            }
            elimated++;
        }
        return elimated;
    }
}
