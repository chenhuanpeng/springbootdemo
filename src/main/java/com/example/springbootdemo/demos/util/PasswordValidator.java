package com.example.springbootdemo.demos.util;

public class PasswordValidator {
    public static void main(String[] args) {
        // 示例输入
        String input = "ABC<c89%000<";

        // 处理密码
        String password = processInput(input);

        // 校验密码安全性
        boolean isSecure = isPasswordSecure(password);

        // 输出结果
        System.out.println(password + "," + isSecure);
    }

    // 处理输入，构建最终的密码字符串
    public static String processInput(String input) {
        StringBuilder passwordBuilder = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (c == '<') {
                // 退格处理
                if (passwordBuilder.length() > 0) {
                    passwordBuilder.deleteCharAt(passwordBuilder.length() - 1); // 移除最后一个字符
                }
            } else {
                // 添加有效字符
                passwordBuilder.append(c);
            }
        }

        return passwordBuilder.toString(); // 返回最终构建的密码字符串
    }

    // 校验密码安全性
    public static boolean isPasswordSecure(String password) {
        if (password.length() < 8) {
            return false; // 密码长度不够
        }

        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true; // 识别特殊字符
            }
        }

        return hasUppercase && hasLowercase && hasDigit && hasSpecialChar; // 检查所有条件
    }
}

