package com.ke.utopia.ailab;

import java.util.HashMap;
import java.util.Map;

/**
 * 类名：LengthOfLongestSubstring
 * 描述：给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。注意 "bca" 和 "cab" 也是正确答案。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 作者：zifengchen
 * 日期：2025/11/18
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String input = "bbbbb";
        int i = lengthOfLongestSubstring(input);
        System.out.println(i);


    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        char[] charArray = s.toCharArray();

        int length = charArray.length;
        int maxLength = 0;


        while (right < length) {
            if (!map.containsKey(charArray[right])) {
                map.put(charArray[right], 1);
                right++;
                maxLength = Math.max(right - left, maxLength);
            } else {
                while (map.containsKey(charArray[right])) {
                    map.remove(charArray[left++]);
                }
            }
        }

        return maxLength;
    }
}
