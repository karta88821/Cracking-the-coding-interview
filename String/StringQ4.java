package String;

class StringQ4 {
    public static void main(String[] args) {
        StringQ4.isNoMoreTwoEdit("pale", "pala");
    }

    static void isNoMoreTwoEdit(String input1, String input2) {
        /*
        int len1 = input1.length();
        int len2 = input2.length();

        if (Math.abs(len1 - len2) == 1) {
            return true;
        }
        */
        int[] chars = new int[128];
        for (int i = 0; i < input1.length(); i++) {
            chars[i]++;
        }
        for (int i = 0; i < input2.length(); i++) {
            System.out.println(chars[i]);
        }
 
    }
}