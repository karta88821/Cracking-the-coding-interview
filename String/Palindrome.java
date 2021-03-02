package String;
import java.util.HashMap;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(Palindrome.isPermPalindromeBitVersion("acbac"));
    }

    static int convertCharToNum(Character input) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int inputValue = Character.getNumericValue(input);
        if (inputValue >= a && inputValue <= z) {
            return inputValue - a;
        }
        return -1;
    }

    static boolean isPermPalindromeBitVersion(String input) {
        int bitVector = Palindrome.createBitVector(input);
        return bitVector == 0 || Palindrome.isExactlyOnebit(bitVector);
        // 全部char各自的數量皆為even或只有一個char的數量為odd
    }

    static int createBitVector(String input) {
        int bitVector = 0;
        for (Character c : input.toCharArray()) {
            bitVector = Palindrome.toggle(bitVector, Palindrome.convertCharToNum(c));
        }
        return bitVector;
    }

    static int toggle(int bitVector, int index) {
        if (index < 0) { return bitVector; }

        // index=0 -> mask = 1
        // index=1 -> mask = 2
        // index=2 -> mask = 4
        // bitVector的每一個bits代表一個狀態，即某個char的狀態, 
        // 0代表為even, 1代表為odd, 而我們要的最終結果是bitVector的所有bits皆為0(even)或是有一個bit為1(odd)
        int mask = 1 << index; 

        // 此行確認這個char是否為even
        // (mask & bitVector) == 0 -> 此char目前為even，將其改成odd
        // (mask & bitVector) > 0 -> 此char目前為odd，將其改成even

        if((mask & bitVector) == 0) { // >0: on狀態, ==0: off狀態
            bitVector |= mask; // 將bitVector中mask為1的位置設為1
            //      xxxx xxxx  -> bitVector
            //  OR  0000 0010  -> mask
            //  =   xxxx xx1x
        } else {
            bitVector &= ~mask; // 將bitVector中mask為1的位置設為0
            //      xxxx xxxx  -> bitVector
            //  AND 1111 1101  -> mask
            //  =   xxxx xx0x
        }

        return bitVector;
    }

    static boolean isExactlyOnebit(int bitVector) {
        return (bitVector & bitVector - 1) == 0;
    }





    static boolean isPermPalindrome(String input) {
        int oddCount = 0;
        int[] table = new int[Character.getNumericValue('a') + Character.getNumericValue('z') - 1];
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            int val = Palindrome.convertCharToNum(currentChar);
            if (val != -1) {
                table[val]++;
                if (table[val] % 2 == 1) {
                    oddCount++;
                } else {
                    oddCount--;
                }
            }
        }
        return oddCount <= 1;
    }
}
