package com.ke.utopia.ailab;

/**
 * 类名：FindTheIndexOfTheFirstOccurrenceInAString
 * 描述：
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * 示例 2：
 * <p>
 * 输入：haystack = "zxcdadleetoode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= haystack.length, needle.length <= 104
 * haystack 和 needle 仅由小写英文字符组成
 * 作者：zifengchen
 * 日期：2025/11/28
 */
public class FindTheIndexOfTheFirstOccurrenceInAString {


    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "sipp";
        int i = strStr(haystack, needle);
        System.out.println(i);
    }


    public static int strStr(String haystack, String needle) {
        boolean contains = haystack.contains(needle);
        if (!contains) {
            return -1;
        }

        int length = haystack.length();
        int index = 0;
        int needleLength = needle.length();

        char[] haystackCharArray = haystack.toCharArray();

        char[] needleCharArray = needle.toCharArray();
        int i = 0;
        for ( i = 0; i < length; i++) {

            if (haystackCharArray[i] == needleCharArray[0]) {
                int j = 0;
                while (j < needleLength && i+j <length && haystackCharArray[i + j] == needleCharArray[j]) {
                    j++;
                }
                if (j == needleLength) {
                    return i;
                }
               
            }


        }

        return i;

    }
}
