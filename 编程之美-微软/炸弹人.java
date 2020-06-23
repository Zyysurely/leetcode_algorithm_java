class Solution {
    public int maxKilledEnemies(char[][] grid) {
          int max = 0;
          for (int i = 0; i < grid.length; i++) {
              for (int j = 0; j < grid[0].length; j++) {
                  int count = 0;
                  if (grid[i][j] == '0') {
                      // 上下搜索
                      int up = i - 1;
                      int down = i + 1;
                      // 向上搜索
                      while (up >= 0) {
                          if (grid[up][j] == 'W') {
                              break;
                          }
                          if (grid[up][j] == 'E') {
                              count++;
                          }
                          up--;
  
                      }
                      // 向下搜索
                      while (down < grid.length) {
                          if (grid[down][j] == 'W') {
                              break;
                          }
                          if (grid[down][j] == 'E') {
                              count++;
                          }
                          down++;
                      }
                      // 左右搜索
                      int left = j - 1;
                      int right = j + 1;
                      while (left >= 0) {
                          if (grid[i][left] == 'W') {
                              break;
                          }
                          if (grid[i][left] == 'E') {
                              count++;
                          }
                          left--;
  
                      }
                      // 向下搜索
                      while (right < grid[0].length) {
                          if (grid[i][right] == 'W') {
                              break;
                          }
                          if (grid[i][right] == 'E') {
                              count++;
                          }
                          right++;
                      }
                      max = Math.max(count, max);
                  }
              }
          }
          return max;
      }
  }