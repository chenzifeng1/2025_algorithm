package com.ke.utopia.ailab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类名：FindAnagrams
 * 描述：给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * 示例 2:
 * <p>
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length, p.length <= 3 * 104
 * s 和 p 仅包含小写字母
 * 作者：zifengchen
 * 日期：2025/11/18
 */
public class FindAnagrams {


    public static void main(String[] args) {

        String s = "abab";
        String p = "ab";
        List<Integer> anagrams = findAnagrams1(s, p);
        System.out.println(anagrams);

    }


    public static List<Integer> findAnagrams(String s, String p) {

        char[] charArray = p.toCharArray();
        Arrays.sort(charArray);
        String target = new String(charArray);

        int tLen = p.length();
        List<Integer> result = new ArrayList<>();
        char[] sCharArray = s.toCharArray();

        for (int i = 0; i < sCharArray.length - tLen + 1; i++) {
            if (check(sCharArray, i, i + tLen, target)) {
                result.add(i);
            }
        }


        return result;
    }


    public static boolean check(char[] sArray, int left, int right, String target) {
        int len = right - left;

        char[] temp = new char[len];

        for (int i = 0; i < len; i++) {
            temp[i] = sArray[left + i];
        }

        Arrays.sort(temp);
        return target.equals(new String(temp));
    }


    /**
     * 滑动时间窗口
     *
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams1(String s, String p) {
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        if(s.length()<p.length()) {
            return new ArrayList<>();
        }

        char[] pCharArray = p.toCharArray();
        char[] sCharArray = s.toCharArray();
        int pl = p.length();

        for (int i = 0; i < pCharArray.length; i++) {
            sCount[sCharArray[i] - 'a']++;
            pCount[pCharArray[i] - 'a']++;
        }

        List<Integer> result = new ArrayList<>();

        if (Arrays.equals(sCount, pCount)) {
            result.add(0);
        }

        for (int i = 0; i < s.length()- pl; i++) {
            sCount[sCharArray[i]-'a']--;
            sCount[sCharArray[i+pl]-'a']++;

            if (Arrays.equals(sCount, pCount)) {
                result.add(i+1);
            }
        }

        return result;
    }
}
