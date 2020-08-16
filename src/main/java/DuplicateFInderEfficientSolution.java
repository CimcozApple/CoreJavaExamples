import java.util.ArrayList;
import java.util.List;

public class DuplicateFInderEfficientSolution {


    public static void main(String[] args) {

        String s = "aaaaabbaa";
        int[] a = {0,1,2,3,4,5,6,7,8};

        System.out.println(solution(s , a));

    }
        public static int solution(String S, int[] C) {
            int cost = 0;
            char[] charArray = S.toCharArray();
            if(charArray.length == C.length) {
                for (int i = 0; i < charArray.length; i++) {
                    int endPosition = 0;
                    int startPosition = i;
                    int j;
                    for (j = i + 1; j < charArray.length; j++) {
                        if (charArray[i] == charArray[j])
                            endPosition = j;
                        else {
                            break;
                        }
                    }
                    if (endPosition > 0) {
                        cost += findCost(C, startPosition, endPosition);
                    }
                    i = j - 1;
                }
            }
            return cost;
        }

        private static int findCost(int[] c, int startPosition, int endPosition){
            int cost = 0;
            List<Integer> duplicateIndexList = new ArrayList<>();
            for(int i = startPosition; i <= endPosition; i++){
                duplicateIndexList.add(c[i]);
            }
            Integer max = duplicateIndexList.stream().mapToInt(v -> v).max().getAsInt();
            duplicateIndexList.remove(max);
            cost += duplicateIndexList.stream().mapToInt(y -> y.intValue()).sum();
            return cost;
        }
}
