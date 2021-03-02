package String;

public class StringQ9 {
    public static void main(String[] args) {
        String input1 = "waterbottle";
        String input2 = "erbottlewat";
        System.out.println(StringQ9.isSub(input1, input2));
    }

    // e.g. s1 = apple  => x = app, y = le
    //                  => s1 = xy
    //      s2 = leapp  => s2 = yx
    //
    //      s1s1 = xyxy
    //              yx  = s2 -> s2 must be the substring of s1s1
    static boolean isSub(String input1, String input2) {
        int len = input1.length();

        if (len > 0 && len == input2.length()) {
            String s1s1 = input1 + input1;
            return s1s1.contains(input2);
        }

        return false;
    }
}
