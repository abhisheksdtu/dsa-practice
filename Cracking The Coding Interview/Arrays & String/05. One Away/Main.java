/*
There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away.
EXAMPLE
pale, ple -> true
pales, pale -> true
pale, bale -> true
pale, bake -> false
*/

public class Main {

    /*
     * 
     * TC - O(N)
     * SC - O(1)
     */
    public static boolean brute(String a, String b) {
        if (Math.abs(a.length() - b.length()) > 1) {
            return false;
        }

        String m = a.length() >= b.length() ? a : b;
        String n = a.length() < b.length() ? a : b;

        int freq[] = new int[26];
        for (int i = 0; i < m.length(); i++) {
            char ch = m.charAt(i);
            freq[ch - 'a']++;
        }

        for (int i = 0; i < n.length(); i++) {
            char ch = n.charAt(i);
            freq[ch - 'a']--;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(brute("pale", "ple"));
        System.out.println(brute("ple", "pale"));
        System.out.println(brute("pales", "pale"));
        System.out.println(brute("pales", "ple"));
        System.out.println(brute("pale", "bake"));
    }
}