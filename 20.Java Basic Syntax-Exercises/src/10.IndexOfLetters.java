package Arrays;
import java.util.*;
public class IndexOfLetters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();

        for (int i = 0; i < word.length(); i++) {

            int currentCharIndex = word.charAt(i) - 'a';

            System.out.printf("%s -> %d%n", word.charAt(i), currentCharIndex);
        }
    }
}