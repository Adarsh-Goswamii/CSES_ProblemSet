import java.util.*;
import java.io.*;

class TowerOfHanoi {
    PrintWriter out;
    StringTokenizer st;
    BufferedReader br;
    final int imax = Integer.MAX_VALUE, imin = Integer.MIN_VALUE;
    final int mod = 1000000007;
    long count;
    StringBuilder ans;

    /**
     *
     */

    void solve() throws Exception {
        read();
        int n= ni();

        count= 0l;
        ans= new StringBuilder();
        towerOfHanoi(n, 1, 3, 2);
        out.println(count);
        out.print(ans);
    }

    void towerOfHanoi(int n, int from_rod, int to_rod, int aux_rod)
    {
        if (n == 1)
        {
            ans.append(from_rod+" "+to_rod+"\n");
            count++;
            return;
        }
        towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);
        ans.append(from_rod +" "+to_rod+"\n");
        count++;
        towerOfHanoi(n - 1, aux_rod, to_rod, from_rod);
    }

    public static void main(String[] args) throws Exception {
        new TowerOfHanoi().run();
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