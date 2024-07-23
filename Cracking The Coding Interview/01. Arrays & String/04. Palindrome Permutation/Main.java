/*
Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
EXAMPLE
Input: Tact Coa
Output: True (permutations: "taco cat", "atco eta", etc.)
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