package Lists;

import java.util.*;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> numList = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
        String[] tokens = scan.nextLine().split(" ");
        int bomb = Integer.parseInt(tokens[0]);
        int power = Integer.parseInt(tokens[1]);

        while (numList.contains(bomb)) {
            int bombIndex = numList.indexOf(bomb);
            int startIndex = 0;
            if (bombIndex > power - 1) {
                startIndex = bombIndex - power;
            }
            int endIndex = numList.size() - 1;
            if (numList.size() - 1 - bombIndex > power) {
                endIndex = bombIndex + power;
            }
            for (int i = endIndex; i >= startIndex; i--) {
                numList.remove(i);
            }
        }
        int sum = 0;
        for (Integer integer : numList) {
            sum += integer;
        }
        System.out.println(sum);
    }
}