package com.example.springbootdemo.demos.util;

public class MaxConnectedServers {
    private static int maxServers = 0;  // 存储最大的局域网服务器数量
    private static boolean[][] visited;  // 记录已访问的服务器

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };

        System.out.println(maxConnectedServers(matrix));  // 输出最大的局域网包含的服务器个数
    }

    public static int maxConnectedServers(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int n = matrix.length;          // 行数
        int m = matrix[0].length;      // 列数
        visited = new boolean[n][m];   // 初始化访问记录

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {  // 找到未访问的服务器
                    int currentCount = dfs(matrix, i, j, n, m);
                    maxServers = Math.max(maxServers, currentCount);  // 更新最大局域网
                }
            }
        }

        return maxServers;  // 返回最大局域网服务器数量
    }

    private static int dfs(int[][] matrix, int x, int y, int n, int m) {
        // 边界条件和访问记录
        if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matrix[x][y] == 0) {
            return 0;
        }

        visited[x][y] = true;  // 标记当前服务器为已访问
        int count = 1;  // 计数当前服务器

        // 四个方向的DFS搜索
        count += dfs(matrix, x + 1, y, n, m);  // 下
        count += dfs(matrix, x - 1, y, n, m);  // 上
        count += dfs(matrix, x, y + 1, n, m);  // 右
        count += dfs(matrix, x, y - 1, n, m);  // 左

        return count;  // 返回连接的服务器数量
    }
}

