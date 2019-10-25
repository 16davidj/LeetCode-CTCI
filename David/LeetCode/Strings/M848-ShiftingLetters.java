/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/shifting-letters/

Description:
We have a string S of lowercase letters, and an integer array shifts.

Call the shift of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes
'a').

For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.

Now for each shifts[i] = x, we want to shift the first i+1 letters of S, x times.

Return the final string after all such shifts to S are applied.

Solution:


Runtime:

Space Complexity:

*/

public String shiftingLetters(String s, int[] shifts) {

  int[] shiftsCopy = new int[shifts.length];
  shiftsCopy[shifts.length - 1] = shifts[shifts.length - 1];
  for(int i = shifts.length - 2; i >= 0; i--) {
    shiftsCopy[i] = shiftsCopy[i+1] + (shifts[i] % 26); //do %26 in case of int overflow
  }

  StringBuilder sb = new StringBuilder();
  char [] charArr = s.toCharArray();
  for(int i = 0; i < charArr.length; i++) {
    sb.append(shiftChar(charArr[i], shiftsCopy[i]));
  }
  return sb.toString();
}

public char shiftChar(char c, int shift) {
  int start = Character.isUpperCase(c) ? 'A' : 'a';
  return (char) ((shift + c - start) % 26 + start);
}
