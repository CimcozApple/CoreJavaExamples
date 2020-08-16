import org.omg.PortableInterceptor.ORBInitInfoPackage.DuplicateNameHelper;

import java.util.*;
import java.util.stream.Collectors;

public class HelloWorld {

    public static void main(String[] args) {

        String s = "ddddaa";
        int[] a = {1,2,3,4,5,6};

        //DuplicateCharFinder.findIt(s);

        System.out.println(solution(s , a));
        
    }

    public static int solution(String S, int[] C) {
        // write your code in Java SE 8

        char[] initString = S.toCharArray();
        int len = initString.length;

        if(len < 2) {
            return 0;
        }

        int count = 0;
        int i = 0;

        while(i < len ) {
            int temp = i;
            boolean isDiff = false;
            for(int j = i + 1 ; j < len ; j++) {
                if (initString[i] != initString[j]) {
                    i = j;
                    isDiff = true;
                    break;
                }

            }
            //temp = 0
            //i == 2
            if(isDiff) {
                List<Integer> listForCostInit = new ArrayList<>();
                for (int z = temp; z < i; z++) {
                    listForCostInit.add(C[z]);
                }
                System.out.println(listForCostInit);
                if (listForCostInit != null && listForCostInit.size() > 0) {
                    Integer max = listForCostInit.stream().mapToInt(v -> v).max().getAsInt();
                    listForCostInit.remove(max);

                    for (Integer var : listForCostInit) {
                        count += var;
                    }
                }
            }
            if(!isDiff)
            i++;

            isDiff = false;
        }



        return  count;
    }
    }










