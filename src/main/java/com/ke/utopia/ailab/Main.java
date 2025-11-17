package com.ke.utopia.ailab;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;


/**
 * 类名：${NAME}
 * 描述：${DESCRIPTION}
 * 作者：zifengchen
 * 日期：2025/11/14
 */
public class Main {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
        int[] ints1 = {2, 1, 3};
        List<Integer> list = Arrays.stream(ints).boxed().toList();

        List<Integer> list1 = Arrays.stream(ints1).boxed().toList();

        List<List<Integer>> result = new ArrayList<>();
        result.add(list);
        System.out.println(result.contains(list1));



    }
}