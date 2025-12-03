package com.ke.utopia.ailab;

import java.util.HashMap;
import java.util.Map;

/**
 * 类名：IsSubsequence
 * 描述：给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 进阶：
 * <p>
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * <p>
 * 致谢：
 * <p>
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * 两个字符串都只由小写字符组成。
 * <p>
 * 作者：zifengchen
 * 日期：2025/12/2
 */
public class IsSubsequence {

    public static void main(String[] args) {
        String s = "acb";
        String t = "ahbgdc";

        boolean subsequence = isSubsequence1(s, t);
        System.out.println(subsequence);

    }


    public static boolean isSubsequence(String s, String t) {
        int[] sArray = new int[26];
        int[] tArray = new int[26];

        Map<Character, Integer> tMap = new HashMap<>();

        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();

        for (int i = 0; i < sCharArray.length; i++) {
            sArray[sCharArray[i] - 'a']++;
        }
        for (int i = 0; i < tCharArray.length; i++) {
            tArray[tCharArray[i] - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (tArray[i] < sArray[i]) {
                return false;
            }
        }

        return true;
    }


    public static boolean isSubsequence1(String s, String t) {
        int length = s.length();
        if (t.length()< length) {
            return false;
        }

        if (t.length()== length) {
            return t.equals(s);
        }


        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();


        int index = 0;

        int i = 0;
        for (i = 0; i < length; ) {
            if (index == t.length()) {
                return false;
            }
            if (sCharArray[i] == tCharArray[index]) {
                index++;
                i++;
                continue;
            }
            while (index < t.length() && tCharArray[index] != sCharArray[i]) {
                index++;
            }

        }

        return i== length;
    }


}
