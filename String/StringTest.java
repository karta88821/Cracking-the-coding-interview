package String;
import java.util.Arrays;
import java.util.HashMap;

public class StringTest {
   public static void main(String[] args) {
        
   } 



   /*
   static String urlify(String input, int trueLength) {
        char[] chars = input.toCharArray();
        int index = 0, spaceCount = 0;
        for (int i = 0; i < trueLength; i++) {
            if (chars[i] == ' ') {
                spaceCount++;
            }
        }
        index = trueLength + spaceCount * 2;

        for (int i = trueLength - 1; i >= 0; i--) {
            if (input.charAt(i) == ' ') {
                chars[index - 1] = '0';
                chars[index - 2] = '2';
                chars[index - 3] = '%';
                index -= 3;
            } else {
                chars[index - 1] = chars[i];
                index --;
            }
        }

        return new String(chars);
        
   }
   */

   /*
   static String sort(String string) {
        char[] charArray = string.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
   }
   */
   

   /*
   static boolean isTwoStringTheSame(String input1, String input2) {
        if (input1.length() != input2.length()) {
            return false;
        }

        return sort(input1).equals(sort(input2));
   } 
   */

   static boolean isTwoStringTheSame(String input1, String input2) {
    if (input1.length() != input2.length()) {
        return false;
    }

    int[] chars = new int[128]; // ASCII
    for (char c : input1.toCharArray()) {
        chars[c]++;
    }

    for (char c : input2.toCharArray()) {
        chars[c]--;
        System.out.println(chars[c]);
        if (chars[c] < 0) {
            
            return false;
        }
    }

    return true;
} 

   static boolean isUniqueChar(String input) {
       int checker = 0;
        for (int i = 0; i < input.length(); i++) {
            int val = input.charAt(i) - 'a';
            if ((checker & (1<<val)) > 0) {
                return false;
            }
            checker |= 1<<val;
        }
        return true;
   }
}
