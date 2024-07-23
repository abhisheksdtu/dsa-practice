/*
Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, sl and s2, write code to check if s2 is a rotation of sl using only one call to isSubstring (e.g., "waterbottle" is a rotation of "erbottlewat")
*/

public class Main {
    public static boolean brute(String m, String n) {
        StringBuilder sb = new StringBuilder(m);
        sb.append(m);
        return sb.toString().contains(n);
    }

    public static void main(String[] args) {
        System.out.println(brute("waterbottle", "erbottlewat"));
    }
}