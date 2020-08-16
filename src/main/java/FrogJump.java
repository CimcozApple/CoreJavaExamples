import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrogJump {

    public static void main(String[] args) {

        String s = "abccbd";
        int[] blocks = {1,1,1,1,1};

        System.out.println(solution(blocks));

    }

    public static int solution(int[] blocks) {

        List<Integer> frogJumpsMap = new ArrayList();

        for (int k = 0; k < blocks.length; k++) {
            int frogJump1 = 0;
            int frogJump2 = 0;
            for (int i = k; i >= 1; i--) {
                if (blocks[i] <= blocks[i - 1]) {
                    frogJump1++;
                } else {
                    break;
                }
            }

            for (int j = k; j < blocks.length - 1; j++) {
                if (blocks[j] <= blocks[j + 1]) {
                    frogJump2++;
                } else {
                    break;
                }
            }
            frogJumpsMap.add(frogJump1 + frogJump2 + 1);
            k += frogJump2;
        }

        Integer max = frogJumpsMap.stream().mapToInt(v -> v).max().getAsInt();
        return max;
    }
}
