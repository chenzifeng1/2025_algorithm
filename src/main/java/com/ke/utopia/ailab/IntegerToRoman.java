package com.ke.utopia.ailab;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 类名：IntegerToRoman
 * 描述：
 * 七个不同的符号代表罗马数字，其值如下：
 * <p>
 * 符号	值
 * I	1
 * V	5
 * X	10
 * L	50
 * C	100
 * D	500
 * M	1000
 * 罗马数字是通过添加从最高到最低的小数位值的转换而形成的。将小数位值转换为罗马数字有以下规则：
 * <p>
 * 如果该值不是以 4 或 9 开头，请选择可以从输入中减去的最大值的符号，将该符号附加到结果，减去其值，然后将其余部分转换为罗马数字。
 * 如果该值以 4 或 9 开头，使用 减法形式，表示从以下符号中减去一个符号，例如 4 是 5 (V) 减 1 (I): IV ，9 是 10 (X) 减 1 (I)：IX。仅使用以下减法形式：4 (IV)，9 (IX)，40 (XL)，90 (XC)，400 (CD) 和 900 (CM)。
 * 只有 10 的次方（I, X, C, M）最多可以连续附加 3 次以代表 10 的倍数。你不能多次附加 5 (V)，50 (L) 或 500 (D)。如果需要将符号附加4次，请使用 减法形式。
 * 给定一个整数，将其转换为罗马数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 3749
 * <p>
 * 输出： "MMMDCCXLIX"
 * <p>
 * 解释：
 * <p>
 * 3000 = MMM 由于 1000 (M) + 1000 (M) + 1000 (M)
 * 700 = DCC 由于 500 (D) + 100 (C) + 100 (C)
 * 40 = XL 由于 50 (L) 减 10 (X)
 * 9 = IX 由于 10 (X) 减 1 (I)
 * 注意：49 不是 50 (L) 减 1 (I) 因为转换是基于小数位
 * 示例 2：
 * <p>
 * 输入：num = 58
 * <p>
 * 输出："LVIII"
 * <p>
 * 解释：
 * <p>
 * 50 = L
 * 8 = VIII
 * 示例 3：
 * <p>
 * 输入：num = 1994
 * <p>
 * 输出："MCMXCIV"
 * <p>
 * 解释：
 * <p>
 * 1000 = M
 * 900 = CM
 * 90 = XC
 * 4 = IV
 * 作者：zifengchen
 * 日期：2025/11/24
 */
public class IntegerToRoman {

    public static Map<Integer, String> map = new LinkedHashMap<>();

    static {

        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
    }


    public static void main(String[] args) {
        System.out.println(intToRoman(58));


    }

    public static String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        while (num > 0) {

            if (num >= 1000) {
                num -= 1000;
                result.append(map.get(1000));
            } else if (num >= 900) {
                num -= 900;
                result.append(map.get(900));
            }else if (num>= 500) {
                num-=500;
                result.append(map.get(500));
            }else if (num>=400) {
                num-=400;
                result.append(map.get(400));
            }else if (num>= 100) {
                num-=100;
                result.append(map.get(100));
            }else if (num>= 90) {
                num-=90;
                result.append(map.get(90));
            }else if (num>= 50) {
                num-=50;
                result.append(map.get(50));
            }else if (num>= 40) {
                num-=40;
                result.append(map.get(40));
            }else if (num>= 10) {
                num-=10;
                result.append(map.get(10));
            }else if (num>=9) {
                num-=9;
                result.append(map.get(9));
            }else if (num>= 5) {
                num-=5;
                result.append(map.get(5));
            }else if (num>=4) {
                num-=4;
                result.append(map.get(4));
            }else if (num>= 1) {
                num-= 1;
                result.append(map.get( 1));
            }
        }

        return result.toString();
    }
}
