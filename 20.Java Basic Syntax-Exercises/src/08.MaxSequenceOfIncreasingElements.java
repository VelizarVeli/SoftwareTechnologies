package Arrays;

import java.util.*;

public class MaxSequenceOfIncreasingElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        int count = 1;
        int maxCount = 1;
        int beginIndex = -1;
        int endIndex = -1;
        int currentBeginIndex = -1;
        int currentEndIndex = -1;

        for (int i = 1; i < numbers.length - 1; i++) {

            if (i == 1) {
                if (numbers[i - 1] < numbers[i]) {
                    count++;
                    currentBeginIndex = 0;
                    currentEndIndex = 0;
                    beginIndex = 0;
                    endIndex = 1;
                    maxCount = 2;
                }
            }

            if (numbers[i] < numbers[i + 1]) {
                count++;
                if (currentBeginIndex < 0) {
                    currentBeginIndex = i;
                }
                currentEndIndex = i + 1;
                if (count > maxCount) {
                    maxCount = count;
                    beginIndex = currentBeginIndex;
                    endIndex = currentEndIndex;
                }

            } else {
                currentBeginIndex = -1;
                currentEndIndex = -1;
                count = 1;
            }
        }

        for (int i = beginIndex; i <= endIndex; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}