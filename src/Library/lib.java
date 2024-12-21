package Library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lib {
    
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
    static int upperBound(int[] B, int x) {
        int left = 0;
        int right = B.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (B[mid] <= x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
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
    static List<Integer> calculatePrimes(int n) {
        if (n < 2) {
            return new ArrayList<>();
        }

        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}
