import java.util.*;

public class Para {
    public static void main(String[] args) {
        int x = 12021;
        
        //System.out.println(Para.isPalindrome(x));

    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x%10 == 0 && x >0)) {
            return false;
        }
        
        int revertedNum = 0;
        while(x > revertedNum) {
            revertedNum = revertedNum * 10 + x % 10;
            x /= 10;
        }
        
        return (x == revertedNum) || (x == revertedNum/10);
    }
}
