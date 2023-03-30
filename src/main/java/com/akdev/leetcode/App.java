package com.akdev.leetcode;

import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Hello world!
 */
public final class App {
    private App() {}

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("LeetCode Questions");
        // palindromeNumberA1(121);
        // palindromeNumberA2(121);
        // System.out.println("Q2 ans: "+ palindromeNumberA1(112211));
        // System.out.println("Q2 ans: "+ palindromeNumberA2(112211));
        // romanToInt("XX");
        // System.out.println(romanToIntAns("LVIII"));

        // String[] arr = {"asdf", "as"};
        // System.out.println(longestCommonPrefixA1(arr));

        System.out.println(isValid("([}}])"));
    }



    /*
     * Q2 - Palindrome Number
     */
    public static boolean palindromeNumberA1(int num) {

        String s = Integer.toString(num);
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1))
                return false;
        }

        return true;
    }

    public static boolean palindromeNumberA2(int num) {
        int oriNum = num;
        int revNum = 0;
        while (num > 0) {
            revNum = revNum * 10 + num % 10;
            num /= 10;
        }
        System.out.println(revNum);
        if (oriNum == revNum) {
            return true;
        }
        return false;
    }

    public static int romanToIntA1(String s) {

        Map<Character, Integer> rMap = new HashMap<Character, Integer>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };
        int num = 0;


        for (int i = 0; i < s.length(); i++) {
            if (s.length() == 1) {
                num += rMap.get(s.charAt(i));
            } else {
                if (i != s.length() - 1 && rMap.get(s.charAt(i)) < rMap.get(s.charAt(i + 1))) {
                    num += rMap.get(s.charAt(i + 1)) - rMap.get(s.charAt(i));
                    ++i;
                    continue;
                } else {
                    num += rMap.get(s.charAt(i));
                }
            }
        }
        return num;
    }

    public static int romanToIntAns(String s) {
        int ans = 0, number = 0, preNum = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'M':
                    number = 1000;
                    break;
                case 'D':
                    number = 500;
                    break;
                case 'C':
                    number = 100;
                    break;
                case 'L':
                    number = 50;
                    break;
                case 'X':
                    number = 10;
                    break;
                case 'V':
                    number = 5;
                    break;
                case 'I':
                    number = 1;
                    break;
            }

            if (preNum > number) {
                ans -= number;
            } else {
                ans += number;
            }
            preNum = number;
        }

        return ans;

    }

    public static String longestCommonPrefixA1(String[] strs) {
        long st = System.nanoTime();
        Arrays.sort(strs);
        long et = System.nanoTime();
        long duration = (et - st) / 1000000;
        System.out.println(duration);
        int i = strs[0].length() > strs[strs.length - 1].length() ? strs[strs.length - 1].length()
                : strs[0].length();
        String s = "";
        for (int j = 0; j < i; j++) {
            if (strs[0].charAt(j) == strs[strs.length - 1].charAt(j)) {
                s = s + "" + strs[0].charAt(j);
                continue;
            }
            break;
        }
        return s;
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0)
            return false;
        Stack<Character> stk = new Stack<>();

        for (char a : s.toCharArray()) {
            if (a == '(' || a == '{' || a == '[') {
                stk.push(a);
            } else if (a == ')' && !stk.isEmpty() && stk.peek() == '(') {
                stk.pop();
            } else if (a == '}' && !stk.isEmpty() && stk.peek() == '{') {
                stk.pop();
            } else if (a == ']' && !stk.isEmpty() && stk.peek() == '[') {
                stk.pop();
            }
        }
        if (stk.isEmpty())
            return true;
        return false;
    }
}
