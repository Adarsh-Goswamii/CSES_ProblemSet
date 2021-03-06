import java.util.*;
import java.io.*;

class CollectingNumbers {
    PrintWriter out;
    StringTokenizer st;
    BufferedReader br;
    final int imax = Integer.MAX_VALUE, imin = Integer.MIN_VALUE;
    final int mod = 1000000007;

    /**
     *
     */

    void solve() throws Exception {
        read();
        int n = ni();

        int[] arr= new int[n+1]; read();
        for(int i=1;i<=n;i++) arr[ni()]= i;

        int prev= n+2, ans= 0;
        for(int i=1;i<=n;i++) {
            if(arr[i]> prev) prev= arr[i];
            else {
                ans++;
                prev= arr[i];
            }
        }

        out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new CollectingNumbers().run();
    }

    void run() throws Exception {
        out = new PrintWriter(System.out);
        br = new BufferedReader(new InputStreamReader(System.in));

//        File file= new File("C:\\Users\\Adarsh Goswami\\Downloads\\test_input (2).txt");
//        br = new BufferedReader(new FileReader(file));
//        out= new PrintWriter("output.txt");

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