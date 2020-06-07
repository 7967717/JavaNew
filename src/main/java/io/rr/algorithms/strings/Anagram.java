package io.rr.algorithms.strings;

import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {

        String word = "java2blog";
        String anagram = "aj2vabgol";

        System.out.println("java2blog and aj2vabgol are anagrams :" + isAnagramUsingStringMethods(word, new StringBuilder(anagram)));
        System.out.println("java2blog and aj2vabgol are anagrams :" + isAnagramArraysSort(word, anagram));
        System.out.println("java2blog and aj2vabgol are anagrams :" + isAnagram(word, anagram));

    }

    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int count[] = new int[256];
        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i)]++;
            count[str2.charAt(i)]--;
        }
        for (int i = 0; i < 256; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    static boolean isAnagramArraysSort(String word, String anagram) {
        if (word.length() != anagram.length())
            return false;
        char[] chars1 = word.toCharArray();
        char[] chars2 = anagram.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }

    static boolean isAnagramUsingStringMethods(String word, StringBuilder anagram) {
        if (word.length() != anagram.length())
            return false;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = anagram.indexOf(String.valueOf(c));
            // If index of any character is -1, then two strings are not anagrams
            // If index of character is not equal to -1, then remove the character from the
            // String
            if (index != -1) {
                anagram.deleteCharAt(index);
            } else
                return false;
        }
        return anagram.toString().isEmpty();
    }
}
