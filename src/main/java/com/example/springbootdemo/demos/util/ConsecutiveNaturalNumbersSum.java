package com.example.springbootdemo.demos.util;

import java.util.ArrayList;
import java.util.List;

public class ConsecutiveNaturalNumbersSum {
    public static void main(String[] args) {
        int target = 10; // 目标整数
        List<List<Integer>> result = findConsecutiveSum(target);

        System.out.println("表达 " + target + " 的连续自然数之和组合：");
        for (List<Integer> sequence : result) {
            System.out.println(sequence);
        }
    }

    public static List<List<Integer>> findConsecutiveSum(int target) {
        List<List<Integer>> result = new ArrayList<>();

        // 从 k = 1 开始向上迭代 k
        for (int k = 1; k < target; k++) {
            // 计算 n
            int n = (target - (k * (k - 1)) / 2) / k;
            // 检查 n 是否为自然数（大于等于1）
            if (n >= 1 && (target - (k * (k - 1)) / 2) % k == 0) {
                List<Integer> sequence = new ArrayList<>();
                for (int i = 0; i < k; i++) {
                    sequence.add(n + i); // 构建连续自然数序列
                }
                result.add(sequence);
            }
        }

        return result;
    }
}
