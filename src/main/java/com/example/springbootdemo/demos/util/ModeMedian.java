package com.example.springbootdemo.demos.util;

import java.util.*;

public class ModeMedian {
    public static void main(String[] args) {
        // 示例输入
        int[] array = {1, 2, 2, 3, 3, 3, 4, 5};

        // 计算众数数组的中位数并输出
        double median = findMedianOfModes(array);
        System.out.println("众数组成的新数组的中位数为: " + median);
    }

    public static double findMedianOfModes(int[] array) {
        // 1. 查找众数
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : array) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // 找到最大频率
        int maxCount = Collections.max(countMap.values());

        // 2. 构建众数数组
        List<Integer> modes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == maxCount) {
                for (int i = 0; i < entry.getValue(); i++) {
                    modes.add(entry.getKey()); // 添加众数对应的个数
                }
            }
        }

        // 3. 计算中位数
        Collections.sort(modes); // 排序众数数组
        return calculateMedian(modes);
    }

    public static double calculateMedian(List<Integer> modes) {
        int size = modes.size();
        if (size == 0) {
            return 0.0; // 如果没有众数，返回0（或其他合适的值）
        }

        // 判断数组大小为奇数还是偶数
        if (size % 2 == 1) {
            return modes.get(size / 2); // 奇数个数，中位数为中间元素
        } else {
            return (modes.get(size / 2 - 1) + modes.get(size / 2)) / 2.0; // 偶数个数，中位数为中间两个元素的平均值
        }
    }
}

