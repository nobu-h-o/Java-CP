/*
Here are some song recs | 今聞いてる曲です。
I Really Want to Stay at Your House
HVN ON EARTH
MY EYES
SDP Interlude extended
FE!N
 */

// my library uses some code from
// https://www.youtube.com/watch?v=d7Vqq_CBg-w

import java.util.*;
import java.io.*;
import static java.util.Arrays.*;
import static java.lang.Math.*;


// i honestly don't know a single thing going on here
class FastScanner {
    private BufferedReader reader = null;
    private StringTokenizer tokenizer = null;

    public FastScanner(InputStream in) {
        reader = new BufferedReader(new InputStreamReader(in));
        tokenizer = null;
    }

    public String next() {
        if (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public String nextLine() {
        if (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return tokenizer.nextToken("\n");
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public int[] nextIntArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = nextInt();
        return a;
    }

    public long[] nextLongArray(int n) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++)
            a[i] = nextLong();
        return a;
    }
}

//        Graphs
//        ArrayList<Integer> G[] = new ArrayList[N + 1];
//        for (int i = 1; i <= N; i++) {
//            G[i] = new ArrayList<>();
//        }
//        for (int i = 1; i <= M; i++) {
//            G[A[i]].add(B[i]);
//            G[B[i]].add(A[i]);
//        }

class lib{
    // Arrays.sort() uses quicksort
    // Collections.sort() uses mergesort
    static void sort(int[] a){
        ArrayList<Integer> b = new ArrayList<>();
        for(int i : a) b.add(i);
        Collections.sort(b);
        for(int i=0;i<a.length;i++) a[i] = b.get(i);
    }
    static void reverse(int[] a){
        ArrayList<Integer> b = new ArrayList<>();
        for(int i : a) b.add(i);
        Collections.reverse(b);
        for(int i=0;i<a.length;i++) a[i] = b.get(i);
    }
    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    static void swap(long[] a, int i, int j) {
        long temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    static void swap(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    // Returns true if s is a subsequence of t
    static boolean isSubseq(String s, String t){
        int sp = 0;
        int tp = 0;
        while (sp < s.length() && tp < t.length()) {
            if (s.charAt(sp) == t.charAt(tp)) {
                sp++;
            }
            tp++;
        }
        return sp == s.length();
    }
    static boolean isPalindrome(String s){
        StringBuilder sb = new StringBuilder(s);
        for(char ch : s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                sb.append(Character.toLowerCase(ch));
            }
        }
        return sb.toString().contentEquals(sb.reverse());
    }
    static boolean isPalindrome(int n){
        String s = Integer.toString(n);
        return isPalindrome(s);
    }
    static boolean isPalindrome(long n){
        String s = Long.toString(n);
        return isPalindrome(s);
    }
    static int lowerBound(int[] B, int x){
        int left = 0;
        int right = B.length; // exclusive

        while(left < right){
            int mid = left + (right - left) / 2;
            if(B[mid] < x){
                left = mid +1;
            }
            else{
                right = mid;
            }
        }

        return left;
    }
    static long encodePosition(int x, int y) {
        return (((long)x) << 32) | (y & 0xFFFFFFFFL);
    }
    static long powmod(long base, long exponent, long mod) {
        if(mod == 1) return 0;
        long result = 1;
        base %= mod;
        while(exponent > 0){
            if((exponent & 1) == 1){
                result = multiplyMod(result, base, mod);
            }
            base = multiplyMod(base, base, mod);
            exponent >>= 1;
        }
        return result;
    }

    static long multiplyMod(long a, long b, long mod){
        return (a * b) % mod;
    }

}

public class Main {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        //code here

        pw.close();
    }
}