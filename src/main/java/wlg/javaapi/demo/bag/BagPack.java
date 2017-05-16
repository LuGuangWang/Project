package wlg.javaapi.demo.bag;

/**
 * 背包问题
 * 
 * 背包问题具体例子：假设现有容量10kg的背包，另外有3个物品，分别为a1，a2，a3。物品a1重量为3kg，价值为4；物品a2重量为4kg，价值为5；物品a3重量为5kg，价值为6。
 * 将哪些物品放入背包可使得背包中的总价值最大？
 * w[i] :  第i个物体的重量；
 * p[i] : 第i个物体的价值；
 * c[i][m] ： 前i个物体放入容量为m的背包的最大价值；
 * c[i-1][m] ： 前i-1个物体放入容量为m的背包的最大价值；
 * c[i-1][m-w[i]] ： 前i-1个物体放入容量为m-w[i]的背包的最大价值；
 * 
 * c[i][m]=max{c[i-1][m-w[i]]+p[i] , c[i-1][m]}
 */
public class BagPack {
  
  public static void main(String[] args) {
    int m = 10;
    int n = 3;
    int w[] = {3, 4, 5};
    int p[] = {5, 4, 6};
    int c[][] = BackPack_Solution(m, n, w, p);
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        System.out.print(c[i][j] + "\t");
        if (j == m) {
          System.out.println();
        }
      }
    }
    // printPack(c, w, m, n);

  }

  /**
   * @param m 表示背包的最大容量
   * @param n 表示商品个数
   * @param w 表示商品重量数组
   * @param p 表示商品价值数组
   */
  public static int[][] BackPack_Solution(int m, int n, int[] w, int[] p) {
    // c[i][v]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值
    int c[][] = new int[n + 1][m + 1];
    for (int i = 0; i < n + 1; i++)
      c[i][0] = 0;
    for (int j = 0; j < m + 1; j++)
      c[0][j] = 0;

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        // 当物品为i件重量为j时，如果第i件的重量(w[i-1])小于重量j时，c[i][j]为下列两种情况之一：
        // (1)物品i不放入背包中，所以c[i][j]为c[i-1][j]的值
        // (2)物品i放入背包中，则背包剩余重量为j-w[i-1],所以c[i][j]为c[i-1][j-w[i-1]]的值加上当前物品i的价值
        if (w[i - 1] <= j) {
          if (c[i - 1][j] < (c[i - 1][j - w[i - 1]] + p[i - 1]))
            c[i][j] = c[i - 1][j - w[i - 1]] + p[i - 1];
          else
            c[i][j] = c[i - 1][j];
        } else
          c[i][j] = c[i - 1][j];
      }
    }
    return c;
  }
}
