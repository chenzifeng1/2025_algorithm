package com.ke.utopia.ailab;

import java.util.Arrays;

/**
 * 类名：ValidPalindrome
 * 描述：
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * <p>
 * 字母和数字都属于字母数字字符。
 * <p>
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 * 示例 2：
 * <p>
 * 输入：s = "race a car"
 * 输出：false
 * 解释："raceacar" 不是回文串。
 * 示例 3：
 * <p>
 * 输入：s = " "
 * 输出：true
 * 解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
 * 由于空字符串正着反着读都一样，所以是回文串。
 * 作者：zifengchen
 * 日期：2025/12/2
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        String str = "race a car";
        boolean palindrome = isPalindrome(str);

        System.out.println(palindrome);


    }


    public static boolean isPalindrome(String s) {

        String cleaned = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        char[] charArray = cleaned.toCharArray();
        int right = cleaned.length() - 1;
        int left = 0;

        while (left < right) {
            if (charArray[left++] != charArray[right--]) {
                return false;
            }

        }
        return true;
    }

    public static boolean isPalindrome1(String s) {

        String cleaned = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        return new StringBuilder(cleaned).reverse().toString().equals(cleaned);

    }

}
