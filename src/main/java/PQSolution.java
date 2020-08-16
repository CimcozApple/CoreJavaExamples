import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class PQSolution {

    public static  int solution(String S) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0 ; i < S.length(); ++i) {
            char c = S.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int count = 0;
        PriorityQueue pq = new PriorityQueue<>(Collections.reverseOrder()); ;

        for (Map.Entry<Character,Integer> entry : map.entrySet())
        {
            pq.add( entry.getValue());
        }

        while (pq.size() != 0) {
            int mfreq = (Integer) pq.poll();
            if (pq.size() == 0 ) { return count; }

            if (mfreq == (Integer)pq.peek()) {
                if (mfreq > 1) {
                    pq.add(mfreq - 1);
                }
                count++;
            }
        }
        return count;
    }

}
