package String;

public class StringQ6 {
    public static void main(String[] args) {
        System.out.println(StringQ6.stringCompression("aabcccccaaa"));
    }

    static String stringCompression(String input) {
        // 算出最終長度是否會變小，變小代表有compression發生
        int finalLength = finalLength(input);
        if (finalLength >= input.length()) { return input; }

        // assign capacity給StringBuffer，以避免空間不夠而double capacity size
        StringBuffer result = new StringBuffer(finalLength);
        int count = 0;
        
        for (int i = 0; i < input.length(); i++) {
            count++;

            // 檢查i+1是否>=字串長度 or 目前的char和下個char是否相異
            if (i+1 >= input.length() || input.charAt(i) != input.charAt(i+1)) {
                result.append(input.charAt(i));
                result.append(count);
                count = 0;
            }
        }

        return result.toString();
    }

    static int finalLength(String input) {
        int finalLength = 0;
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            count++;

            if (i+1 >= input.length() || input.charAt(i) != input.charAt(i+1)) {
                finalLength += 1 + String.valueOf(count).length();
                count = 0;
            }
        }
        return finalLength;
    }
}
