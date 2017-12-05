package DictionariesLambdaStreamAPI;
import java.util.*;
public class Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<String, String> phonebook = new HashMap<>();

        while (true){
            String[] tokens = scan.nextLine().split(" ");

            if (tokens[0].equals("END")){
                break;

            }else if (tokens[0].equals("A")){
                String name = tokens[1];
                String phone = tokens[2];
                phonebook.put(tokens[1], tokens[2]);

            }else if (tokens[0].equals("S")){
                String name = tokens[1];
                if (phonebook.containsKey(name)){
                    System.out.printf("%s -> %s%n", name, phonebook.get(name));
                }else{
                    System.out.printf("Contact %s does not exist.%n", name);
                }
            }
        }
    }
}