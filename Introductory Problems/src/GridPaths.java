import java.util.*;
import java.io.*;

class GridPaths {
    PrintWriter out;
    StringTokenizer st;
    BufferedReader br;
    final int imax = Integer.MAX_VALUE, imin = Integer.MIN_VALUE;
    final int mod = 1000000007;

    /**
     *  TODO: 24th April 2021
     */

    void solve() throws Exception {
        char[] r= ns().toCharArray();
        ans= 0;
        dp= new int[7][7][48];
        for(int[][] i: dp) for(int[] j: i) Arrays.fill(j, -1);
        out.println(dfs(r, new boolean[7][7], 0, 0, 0));
    }

    int ans= 0;
    int[][][] dp;
    private int dfs(char[] r, boolean[][] v, int i, int j, int k) {
        if(k>= 46)System.out.println(i+" "+j+" "+k);
        if(i<0 || j< 0 || i> 6 || j>6) return 0;
        else if(v[i][j]) return 0;
        else if(k== r.length && i== 6 && j== 0) return 1;
        else if(k== r.length) return 0;
//        else if(dp[i][j][k]!= -1) return dp[i][j][k];
        else {
            v[i][j]= true;
            int val= 0;
            if(r[k]== 'U') val= dfs(r, v, i-1, j, k+1);
            else if(r[k]== 'D') val= dfs(r, v, i+1, j, k+1);
            else if(r[k]== 'L') val= dfs(r, v, i, j-1, k+1);
            else if(r[k]== 'R') val= dfs(r, v, i, j+1, k+1);
            else {
                val+= dfs(r, v, i-1, j, k+1);
                val+= dfs(r, v, i+1, j, k+1);
                val+= dfs(r, v, i, j-1, k+1);
                val+= dfs(r, v, i, j+1, k+1);
            }
            v[i][j]= false;
            dp[i][j][k]= val;
            return val;
        }
    }

    public static void main(String[] args) throws Exception {
        new GridPaths().run();
    }

    void run() throws Exception {
        out = new PrintWriter(System.out);
        br = new BufferedReader(new InputStreamReader(System.in));

        solve();
        out.flush();
    }

    void read() throws Exception {
        st = new StringTokenizer(br.readLine());
    }

    int ni() {
        return Integer.parseInt(st.nextToken());
    }

    long nl() {
        return Long.parseLong(st.nextToken());
    }

    double nd() {
        return Double.parseDouble(st.nextToken());
    }

    String ns() throws Exception {
        String s = br.readLine();
        return s.length() == 0 ? br.readLine() : s;
    }

    void print(int[] arr) {
        for (int i : arr)
            out.print(i + " ");
        out.println();
    }

    void print(long[] arr) {
        for (long i : arr)
            out.print(i + " ");
        out.println();
    }

    void print(int[][] arr) {
        for (int[] i : arr) {
            for (int j : i)
                out.print(j + " ");
            out.println();
        }
    }

    void print(long[][] arr) {
        for (long[] i : arr) {
            for (long j : i)
                out.print(j + " ");
            out.println();
        }
    }

    long add(long a, long b) {
        if (a + b >= mod)
            return (a + b) - mod;
        else
            return a + b;
    }

    long mul(long a, long b) {
        return (a * b) % mod;
    }
}