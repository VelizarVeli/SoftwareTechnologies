package Arrays;

import java.util.*;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int maxCount = 1;
        int element = numbers[0];
        int currentCount = 1;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == numbers[i - 1]) {
                currentCount++;
                if (currentCount > maxCount){
                    maxCount = currentCount;
                    element = numbers[i];
                }
            }else{
                currentCount = 1;
            }
        }
        for (int i = 0; i < maxCount; i++) {
            System.out.print(element + " ");
        }
    }
}