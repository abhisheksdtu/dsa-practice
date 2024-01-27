/*
 * TC - O(N)
 * SC - O(1)
 */

class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" ");

        StringBuilder res = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            String word = words[i];
            if (word.length() > 0) {
                res.append(words[i]);
                res.append(" ");
            }
        }
        return res.toString().trim();
    }
}