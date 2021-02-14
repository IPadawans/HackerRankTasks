import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Contacts {

    /*
     * Complete the contacts function below.
     */
    static int[] contacts(String[][] queries) {
        List<Integer> teste = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String[] data : queries){
            if (data[0].equals("add")){
                for (int j = 1; j <= data[1].length(); j++){
                    String sub = data[1].substring(0, j);
                    if (map.get(sub) == null){
                        map.put(sub, 1);
                    } else {
                        map.put(sub, map.get(sub) + 1);
                    }
                }
            } else {
                if (map.get(data[1]) == null){
                    teste.add(0);
                } else {
                    teste.add(map.get(data[1]));
                }

            }
        }

        return teste.stream().mapToInt(i->i).toArray();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int queriesRows = Integer.parseInt(scanner.nextLine().trim());

        String[][] queries = new String[queriesRows][2];

        for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
                String queriesItem = queriesRowItems[queriesColumnItr];
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int[] result = contacts(queries);

//        for (int resultItr = 0; resultItr < result.length; resultItr++) {
//            bufferedWriter.write(String.valueOf(result[resultItr]));
//
//            if (resultItr != result.length - 1) {
//                bufferedWriter.write("\n");
//            }
//        }
//
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
    }
}
