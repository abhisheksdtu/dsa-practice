/*
Write a method to replace all spaces in a string with '%20'. You may assume that the string
has sufficient space at the end to hold the additional characters, and that you are given the "true"
length of the string. (Note: If implementing in Java, please use a character array so that you can
perform this operation in place.)
*/

import java.util.Arrays;

public class Main {

    /*
     * WE ARE GIVEN THAT OUT CHARACTER ARRAY HAS ENOUGH CHARACTERS TO STORE %20
     * FIRST COUNT ALL THE SPACES IN THE STRING
     * THEN FIND THE INDEX WHERE THE LAST CHARACTER WILL GO 
     * IDX - LENGTH + SPACE_COUNT * 2 - AS WE HAVE ONE SPACE IN THE ORIGINAL STRING
     * ITERATE FROM THE BACK OF THE STRING
     * IF CHARACTER IS SPACE THEN ADD %20 IN ARRAY IN REVERSE ORDER
     * ELSE JUST APPEND THE CHARACTER
     * 
     * TC - O(N)
     * SC - O(1)
     */
    public static void brute(char arr[], int trueLength) {
        int spaceCount = 0;
        for (int i = 0; i < trueLength; i++) {
            if (arr[i] == ' ') {
                spaceCount++;
            }
        }
        int idx = trueLength + spaceCount * 2;
        for (int i = trueLength - 1; i >= 0; i--) {
            if (arr[i] == ' ') {
                arr[idx--] = '0';
                arr[idx--] = '2';
                arr[idx--] = '%';
            } else {
                arr[idx--] = arr[i];
            }
        }
    }

    public static void main(String[] args) {

        String s = "Mr John Smith                ";
        char arr[] = s.toCharArray();
        System.out.println(Arrays.toString(arr));
        System.out.println("----------------------");
        brute(arr, 13);
        System.out.println(Arrays.toString(arr));
    }
}