import java.util.HashMap;
import java.util.Map;

public class oneEditDistance {
   // Given two strings S and T, determine if they are both one edit distance apart.
   // one modify: CAT -> BAT
    // one insertion: AT -> CAT
    // one removal : CAT -> AT,   CAT -> CATT


    // O(N) time and O(N) space is trivial: use a hashmap to put characters and check if the other string has
    // characters in the map. If there is not, increment the counter. If the counter > 1, return false. Else true.


    // O(N) Time and O(1) space is tricky
   public static boolean oneEditDist(String s1, String s2) {
        if(s2.length() - s1.length() > 1)
            return false;

       String longer = s1;
       String shorter = s2;
       boolean isEqual = false;

       if(s1.length() < s2.length()) {
           longer = s2;
           shorter = s1;
       } else if(s1.length() == s2.length()) {
           isEqual = true;
       }

       int count = 0;
       int index = 0;
       for(int i=0;i<longer.length();i++) {
           if(isEqual && shorter.charAt(index++) != longer.charAt(i)) {
                count++;
           }

           if(!isEqual){
               if(index < shorter.length() && shorter.charAt(index) != longer.charAt(i)){
                   count++;
                   continue;
               } else {
                   if(index == shorter.length()-1 && i != longer.length()-1) {
                       count++;
                   }
                   index++;
               }

           }
       }

       if(count ==1) {
           return true;
       }

       return false;
   }
}

class oneEditDistanceSolution {

    public static void main(String args[]) {
        oneEditDistance e = new oneEditDistance();

        System.out.println(e.oneEditDist("at", "cat"));  // true

        System.out.print("\n");

        System.out.println(e.oneEditDist("bat", "cat")); // true
        System.out.print("\n");

        System.out.println(e.oneEditDist("cat", "catt")); // true
        System.out.print("\n");

        System.out.println(e.oneEditDist("cat", "at")); // true
        System.out.print("\n");

        System.out.println(e.oneEditDist("cat", "cta")); // false
        System.out.print("\n");

        System.out.println(e.oneEditDist("cat", "catfg")); // false
        System.out.print("\n");

        System.out.println(e.oneEditDist("cat", "cat")); // false
        System.out.print("\n");

        System.out.println(e.oneEditDist("at", "atc"));  // true
        System.out.print("\n");

        System.out.println(e.oneEditDist("abcd", "abc"));  // true

        System.out.println(e.oneEditDist("cat", "cast"));  // true
    }
}