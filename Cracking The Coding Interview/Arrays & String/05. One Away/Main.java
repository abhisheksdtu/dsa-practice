/*
There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away. 
*/

public class Main {

    /*
     * 
     * TC - O(N)
     * SC - O(1)
     */
    public static boolean brute(String s) {
        int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                continue;
            }
            freq[ch - 'a']++;
        }
        
        int c = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] % 2 == 1) {
                c++;
            }
        }
        return c <= 1;
    }

    public static void main(String[] args) {
        System.out.println(brute("tact coa"));
    }
}