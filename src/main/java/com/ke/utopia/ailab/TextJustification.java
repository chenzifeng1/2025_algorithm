package com.ke.utopia.ailab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类名：TextJustification
 * 描述：
 * 给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * <p>
 * 你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * <p>
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * <p>
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * <p>
 * 注意:
 * <p>
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * 输出:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * 示例 2:
 * <p>
 * 输入:words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * 输出:
 * [
 * "What   must   be",
 * "acknowledgment  ",
 * "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 * 因为最后一行应为左对齐，而不是左右两端对齐。
 * 第二行同样为左对齐，这是因为这行只包含一个单词。
 * 示例 3:
 * <p>
 * 输入:words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"]，maxWidth = 20
 * 输出:
 * [
 * "Science  is  what we",
 * "understand      well",
 * "enough to explain to",
 * "a  computer.  Art is",
 * "everything  else  we",
 * "do                  "
 * ]
 * 作者：zifengchen
 * 日期：2025/12/1
 */
public class TextJustification {

    public static void main(String[] args) {
        String[] array = new String[]{"What","must","be","acknowledgment","shall","be"};
        List<String> strings = fullJustify(array, 16);

        System.out.println(Arrays.toString(strings.toArray()));
    }


    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        int length = words.length;

        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < length; i++) {

            if (temp.length() + words[i].length() <= maxWidth) {
                temp.append(words[i]).append(" ");
            } else {
                // 如果没办法增加了，需要重接
                String tempString = temp.toString();
                String replace = tempString.replace(" ", "");

                String[] s = tempString.split(" ");
                List<String> list = new ArrayList<>(Arrays.stream(s).filter(v -> !v.equals(" ")).toList());
                int addNum = maxWidth - replace.length();
                int size = list.size();
                if (size != 1) {
                    for (int j = 0; j < addNum; j++) {
                        list.set(j % (size - 1), list.get(j % (size - 1)) + " ");
                    }
                }

                String join = String.join("", list);
                result.add(join);

                temp = new StringBuilder();
                if (words[i].length()<maxWidth) {
                    temp.append(words[i]).append(" ");
                }

            }
        }

        if (temp.length() < maxWidth) {
            int needAdd = maxWidth - temp.length();
            temp.append(" ".repeat(Math.max(0, needAdd)));
            result.add(temp.toString());
        }

        return result;
    }
}


