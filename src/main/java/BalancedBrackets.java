import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BalancedBrackets {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        if (s == null || s.length() % 2 != 0) {
            return "NO";
        }
        Deque<Character> stack = new LinkedList<>();

        for(int idx = 0; idx < s.length(); idx ++){
            char actualChar = s.charAt(idx);
            if(actualChar == '{' || actualChar == '[' || actualChar == '('){
                stack.add(actualChar);
                continue;
            }

            if(stack.isEmpty()){
                return "NO";
            }
            char checkCharacter;
            switch (actualChar){
                case '}':
                    checkCharacter = stack.pollLast();
                    if(checkCharacter == '[' || checkCharacter == '('){
                        return "NO";
                    }
                    break;

                case ']':
                    checkCharacter = stack.pollLast();
                    if(checkCharacter == '{' || checkCharacter == '('){
                        return "NO";
                    }
                    break;

                case ')':
                    checkCharacter = stack.pollLast();
                    if(checkCharacter == '{' || checkCharacter == '['){
                        return "NO";
                    }
                    break;
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String result = isBalanced("{[()]}");
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int t = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int tItr = 0; tItr < t; tItr++) {
//            String s = scanner.nextLine();
//
//            String result = isBalanced(s);
//
//            bufferedWriter.write(result);
//            bufferedWriter.newLine();
//        }
//
//        bufferedWriter.close();
//
//        scanner.close();
    }
}
