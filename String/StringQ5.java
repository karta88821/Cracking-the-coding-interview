package String;

public class StringQ5 {
    public static void main(String[] args) {
        System.out.println(StringQ5.checkOneEdit("ab", "abc"));
    }

    static boolean checkOneEdit(String input1, String input2) {
        // 檢查兩字串長度是否<=1
        if (Math.abs(input1.length() - input2.length()) > 2) {
            return false;
        }

        // 字串較短者放上面，字串較長者放下面，方便做指標移動
        String string1 = input1.length() < input2.length() ? input1 : input2;
        String string2 = input1.length() < input2.length() ? input2 : input1;

        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;

        while(index1 < string1.length() && index2 < string2.length()) {
            if (string1.charAt(index1) != string2.charAt(index2)) {
                if (foundDifference) return false;
                foundDifference = true;

                // replace case: move shortest string
                if (string1.length() == string2.length()) {
                    index1++;
                }
            } else {
                index1++;
            }
            index2++;
        }

        return true;
    }

    /*
    static boolean checkOneEdit(String input1, String input2) {
        if (input1.length() == input2.length()) {
            return oneEdit(input1, input2);
        } else if (input1.length() + 1 == input2.length()) {
            return oneInsert(input1, input2);
        } else if (input1.length() - 1 == input2.length()) {
            return oneInsert(input2, input1);
        }
        return false;
    }

    static boolean oneEdit(String input1, String input2) {
        boolean foundReplacement = false;

        for (int i = 0; i < input1.length(); i++) {
            if (input1.charAt(i) != input2.charAt(i)) {

                // 若進來代表有兩個位置不同
                if (foundReplacement) {
                    return false;
                }

                foundReplacement = true;
            }
        }

        return true;
    }

    static boolean oneInsert(String input1, String input2) {
        int index1 = 0;
        int index2 = 0;
        while(index1 < input1.length() && index2 < input2.length()) {
            if (input1.charAt(index1) != input2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                } else {
                    index2++;
                }
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    */
}
