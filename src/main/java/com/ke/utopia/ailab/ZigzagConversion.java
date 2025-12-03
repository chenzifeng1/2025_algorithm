package com.ke.utopia.ailab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类名：ZigzagConversion
 * 描述：
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 * <p>
 * 输入：s = "A", numRows = 1
 * 输出："A"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 * 作者：zifengchen
 * 日期：2025/11/25
 */
public class ZigzagConversion {

    public static void main(String[] args) {
        String input = "PAYPALISHIRING";
        int numRows = 3;
        String expected = "PAHNAPLSIIGYIR";
        String actual = convert(input, numRows);
        System.out.println(actual);
    }


    public static String convert(String s, int numRows) {
        List<StringBuffer> stringBufferList = new ArrayList<>();
        if(numRows ==1) {
            return s;
        }

        //  初始化
        for (int i = 0; i < numRows; i++) {
            stringBufferList.add(new StringBuffer());
        }

        char[] charArray = s.toCharArray();
        int i = 0;
        int flag = -1;
        for (char c : charArray) {
            stringBufferList.get(i).append(c);
            if (i ==0 || i == numRows-1) {
                flag = -flag;
            }
            i+=flag;
        }

        StringBuilder result = new StringBuilder();
        for (int j = 0; j < stringBufferList.size(); j++) {
            result.append(stringBufferList.get(j).toString());
        }

        return result.toString();
    }



}
