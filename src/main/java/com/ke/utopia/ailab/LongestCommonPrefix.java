package com.ke.utopia.ailab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类名：LongestCommonPrefix
 * 描述：
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 如果非空，则仅由小写英文字母组成
 * 作者：zifengchen
 * 日期：2025/11/25
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] array = new String[]{"cir","car"};
        String s = longestCommonPrefix(array);
        System.out.println(s);
    }


    public static String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length == 1) {
            return strs[0];
        }
        int strMinLen = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            strMinLen = Math.min(strMinLen, strs[i].length());
        }

        int i = 0;
        StringBuilder builder = new StringBuilder();

        while (i < strMinLen) {
            char c = strs[0].charAt(i);
            Boolean isCheck = true;
            for (String str : strs) {
                if (c != str.charAt(i)) {
                    isCheck = false;
                    break;
                }
            }
            if (isCheck) {
                builder.append(c);
            }else {
                break;
            }
            i++;

        }
        return builder.toString();
    }
}

