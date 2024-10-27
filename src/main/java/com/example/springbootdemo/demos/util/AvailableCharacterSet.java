package com.example.springbootdemo.demos.util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AvailableCharacterSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入字符串
        String input = scanner.nextLine();

        // 解析字符集
        String[] parts = input.split("@");
        String fullSetPart = parts[0];
        String occupiedSetPart = parts.length > 1 ? parts[1] : "";

        // 存储全量字符集和已占用字符集
        Map<String, Integer> fullSet = parseCharacterMap(fullSetPart);
        Map<String, Integer> occupiedSet = parseCharacterMap(occupiedSetPart);

        // 计算可用字符集
        StringBuilder availableSet = new StringBuilder();
        for (Map.Entry<String, Integer> entry : fullSet.entrySet()) {
            String character = entry.getKey();
            int availableCount = entry.getValue() - occupiedSet.getOrDefault(character, 0);

            if (availableCount > 0) {
                availableSet.append(character).append(":").append(availableCount).append("\n");
            }
        }

        // 输出可用字符集
        if (availableSet.length() > 0) {
            System.out.print(availableSet.toString().trim());  // 输出结果并去掉最后的换行符
        } else {
            System.out.println("全部字符已被占用");
        }
    }

    // 解析字符集字符串到Map
    private static Map<String, Integer> parseCharacterMap(String part) {
        Map<String, Integer> characterMap = new LinkedHashMap<>();
        String[] characters = part.split(",");

        for (String character : characters) {
            if (character.isEmpty()) {
                continue;
            }
            String[] keyValue = character.split(":");
            if (keyValue.length == 2) {
                String charKey = keyValue[0];
                int count = Integer.parseInt(keyValue[1]);
                characterMap.put(charKey, count);
            }
        }

        return characterMap;
    }
}

