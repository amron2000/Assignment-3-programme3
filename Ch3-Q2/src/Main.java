
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("text.txt");
//////////////////////////////////// part 1 ///////////////////////////////////////
        HashMap<String, Integer> has = new HashMap<>();
        System.out.println("number of occurrences of each word in the string :");
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            String string = input.next();
            if (has.containsKey(string)) {
                has.replace(string, has.get(string), has.get(string) + 1);

            } else {
                has.put(string, 1);
            }
        }
        for (String key : has.keySet()) {
            System.out.println(key + ":" + has.get(key));
        }
//////////////////////////////////// part 2 ///////////////////////////////////////
        System.out.println("number of occurrences of each letter in the string :");
        HashMap<String, Integer> hash = new HashMap<>();
        int i = 1;
        Scanner input1 = new Scanner(file);
        while (input1.hasNextLine()) {
            while (input1.hasNext()) {
                String string1 = input1.next();
                for (int j = 0; j < string1.length(); j++) {
                    String q = string1.substring(j, j + 1);
                    if (hash.containsKey(q)) {
                        hash.replace(q, hash.get(q), hash.get(q) + 1);
                    } else {
                        hash.put(q, 1);
                    }
                }
            }
            for (String key : hash.keySet()) {
                System.out.print(key + ":" + hash.get(key)+" ");

            }

        }
    }

}