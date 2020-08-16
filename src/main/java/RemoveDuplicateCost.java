import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveDuplicateCost {

    public static void main(String[] args) {

        String s = "abccbd";
        int[] a = {0,1,2,3,4};

        System.out.println(solution(s , a));

    }
    public static int solution(String S, int[] C) {
        char[] stringArray = S.toCharArray();
        int len = stringArray.length;
        Map<Integer, List<Integer>> duplicateIndexMap = new HashMap();
        int i = 0;
        int j = 1;
        int costTotal = 0;
        if(len < 2 || S.length() != C.length) {
            return 0;
        }

        int mapIndexCount = 1;

        while (j < len) {
            if (stringArray[i] != stringArray[j]) {
                List<Integer> l =  new ArrayList<>();
                for(int z = i ; z <= j-1 ; z++) {
                    l.add(z);
                }
                duplicateIndexMap.put(mapIndexCount,l);
                mapIndexCount++;
                i=j;
            }

            if(j == len -1) {
                List<Integer> l =  new ArrayList<>();
                for(int z = i ; z <= len-1 ; z++) {
                    l.add(z);
                }
                duplicateIndexMap.put(mapIndexCount,l);
            }
            j++;
        }

        System.out.println(duplicateIndexMap);

        for (Map.Entry<Integer, List<Integer>> entry : duplicateIndexMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
            if(entry.getValue().size() > 1) {
                List<Integer> duplicateIndexList = new ArrayList<>();
                for (Integer x: entry.getValue()) {
                    duplicateIndexList.add(C[x]);
                }
                Integer max = duplicateIndexList.stream().mapToInt(v -> v).max().getAsInt();
                duplicateIndexList.remove(max);
                costTotal += duplicateIndexList.stream().mapToInt(y -> y.intValue()).sum();
            }
        }

        return costTotal;

    }
}
