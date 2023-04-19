### BOJ 2098

### [유튜브](https://youtu.be/XaXsJJh-Q5Y)

### [블로그](https://youtu.be/XaXsJJh-Q5Y)

``` java
import java.io.*;
import java.util.*;

public class Main {
    static int[][] W, dp;
    static final int INF = 1987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        dp = new int[N][(1 << N) - 1];
        for (int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; ++i) {
            Arrays.fill(dp[i], INF);
        }

        int res = TSP(0, (1 << N) - 1, N);

        System.out.println(res);
    }

    static int TSP(int node, int left, int N) {
        left &= ~(1 << node);

        if (dp[node][left] != INF) {
            return dp[node][left];
        }

        if (left == 0) {
            if (W[node][0] == 0) {
                return dp[node][left] = INF/2;
            }
            return dp[node][left] = W[node][0];
        }

        for (int i = 0; i < N; ++i) {
            if (W[node][i] > 0 && (left & (1 << i)) != 0) {
                int nextCost = TSP(i, left & ~(1 << i), N);
                    dp[node][left] = Math.min(dp[node][left], W[node][i] + nextCost);
            }
        }
        return dp[node][left];
    }
}



```
