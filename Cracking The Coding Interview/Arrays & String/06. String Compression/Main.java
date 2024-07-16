/*
Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
"compressed" string would not become smaller than the original string, your method should return
the original string. You can assume the string has only uppercase and lowercase letters (a - z).

Example 
String - aabbcccccaaa -> a2b2c5a3
String - abc -> abc
*/

public class Main {
    /*
     * 
     * TC - O(N)
     * SC - O(1)
     */
    public static String brute(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            int idx = 1;

            while ((i + idx) < s.length() && s.charAt(i) == s.charAt(i + idx)) {
                idx++;
            }

            sb.append(ch);
            sb.append(idx);
            i += idx;
        }

        String compressed = sb.toString();
        return s.length() > compressed.length() ? compressed : s;
    }

    public static void main(String[] args) {
        System.out.println(brute("aabbcccccaaa"));
        System.out.println(brute("abc"));
    }
}