package DictionariesLambdaStreamAPI;
import java.util.*;
public class PhonebookUpgrade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeMap<String, String> phonebook = new TreeMap<>();

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
            }else if (tokens[0].equals("ListAll")){
                for (Map.Entry<String, String> stringStringEntry : phonebook.entrySet()) {
                    System.out.printf("%s -> %s%n", stringStringEntry.getKey(), stringStringEntry.getValue());
                }
            }
        }
    }
}