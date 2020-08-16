public class FrogJumpEfficient {

    public static void main(String[] args) {

        String s = "abccbd";
        int[] blocks = {1,1,2,3};

        System.out.println(solution(blocks));

    }
    public static int solution(int[] blocks) {
        int distance = 0;
        for(int sit = 0; sit < blocks.length; sit++){
            int toRight = 0;
            int toLeft = 0;
            int apartBy = 0;
            int i, j;
            for(i = sit; i < (blocks.length - 1); i++){
                if(!canJump(blocks[i], blocks[i + 1])) break;
            }
            toRight = i - sit;
            for(j = sit; j >= 1; j--){
                if(!canJump(blocks[j], blocks[j -1])) break;
            }
            toLeft = sit - j;
            apartBy = toRight + toLeft + 1;
            sit += toRight; //next sitting position should be after the right distance, as all in between should be
            //lesser
            if(apartBy > distance)
                distance = apartBy;
        }
        return distance;
    }
    private static boolean canJump(int block1, int block2){
        return block1 <= block2;
    }
}
