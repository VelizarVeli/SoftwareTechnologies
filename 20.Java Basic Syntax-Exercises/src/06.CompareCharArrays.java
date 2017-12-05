package Arrays;

import java.util.*;

public class CompareCharArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char[] firstArr = scan.nextLine().replaceAll(" ", "").toCharArray();
        char[] secondArr = scan.nextLine().replaceAll(" ", "").toCharArray();

        int compare = 0;

        compare = compare(firstArr, secondArr, compare);

        printResult(firstArr, secondArr, compare);

    }

    private static void printResult(char[] firstArr, char[] secondArr, int compare) {
        if (compare < 1) {
            for (char c : firstArr) {
                System.out.print(c);
            }
            System.out.println();
            for (char c : secondArr) {
                System.out.print(c);
            }
        } else {
            for (char c : secondArr) {
                System.out.print(c);
            }
            System.out.println();
            for (char c : firstArr) {
                System.out.print(c);
            }
        }
    }

    private static int compare(char[] firstArr, char[] secondArr, int compare) {
        for (int i = 0; i < secondArr.length; i++) {
            try {
                if (firstArr[i] == secondArr[i]) {
                    continue;
                } else if (firstArr[i] < secondArr[i]) {
                    compare = -1;
                    break;
                } else {
                    compare = 1;
                    break;
                }

            } catch (IndexOutOfBoundsException ex) {
                compare = 0;
                break;
            }
        }
        if (compare == 0 && firstArr.length <= secondArr.length) {
            compare = -1;
        } else if (compare == 0 && firstArr.length > secondArr.length) {
            compare = 1;
        }
        return compare;
    }
}